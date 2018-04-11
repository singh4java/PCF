/**
 * 
 */
package com.wipro.analyzer.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.wipro.analyzer.domain.WebPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wipro")
public class WebAnalyzerController {

	public static Set<String> webLinks = new HashSet<String>();
	public static String domainName = null;
	public static String domainNameWithoutBackSlash = null;

	/**
	 * This method gets called when the /webAnalyzer path is invoked.
	 * 
	 * @param domainName
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/webAnalyzer")
	public @ResponseBody WebPage webCrawl(
			@RequestParam(value = "domain", defaultValue = "http://wiprodigital.com/") String domainName)
			throws IOException {

		this.domainName = domainName;
		this.domainNameWithoutBackSlash = domainName.substring(0, domainName.length() - 1);
		WebPage rootWebPage = new WebPage(domainName);
		processWebPageInternalCall(rootWebPage);
		return rootWebPage;
	}

	/**
	 * This method recurcisvely crawls through webpages and retrieves the
	 * respective information.
	 * 
	 * @param rootWebPage
	 */
	public static void processWebPageInternalCall(WebPage rootWebPage) throws IOException {

		Document doc = Jsoup.connect(rootWebPage.getLinkName()).get();
		webLinks.add(rootWebPage.getLinkName());
		Elements links = doc.select("a[href]");
		Elements images = doc.select("img[src]");
		List<WebPage> childLinks = links.parallelStream().filter(link -> link.attr("href").startsWith(domainName))
				.map(s -> new WebPage(s.attr("href"))).collect(Collectors.toList());
		List<String> imagesList = images.parallelStream().map(s -> s.attr("src")).collect(Collectors.toList());
		List<String> externalLinks = links.parallelStream()
				.filter(link -> (!link.attr("href").startsWith(domainNameWithoutBackSlash)
						&& !link.attr("href").startsWith("#")))
				.map(s -> s.attr("href")).collect(Collectors.toList());
		rootWebPage.setExternalLinks(externalLinks);
		rootWebPage.setImages(imagesList);
		if (!childLinks.isEmpty()) {
			rootWebPage.setChildLinks(childLinks);
			for (WebPage webPage : rootWebPage.getChildLinks()) {
				if (!webLinks.contains(webPage.getLinkName())) {
					processWebPageInternalCall(webPage);
				}
			}
		}
	}

}