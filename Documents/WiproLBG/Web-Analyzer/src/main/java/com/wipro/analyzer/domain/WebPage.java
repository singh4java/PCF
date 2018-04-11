package com.wipro.analyzer.domain;

/**
 * @author manvendrasingh
 *
 */
import java.util.List;


public class WebPage {

	String linkName;
	List<WebPage> childLinks;
	List<String> externalLinks;
	List<String> images;

	public List<String> getExternalLinks() {
		return externalLinks;
	}

	public void setExternalLinks(List<String> externalLinks) {
		this.externalLinks = externalLinks;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public WebPage(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkName() {
		return linkName;
	}

	public List<WebPage> getChildLinks() {
		return childLinks;
	}

	public void setChildLinks(List<WebPage> childLinks) {
		this.childLinks = childLinks;
	}

}