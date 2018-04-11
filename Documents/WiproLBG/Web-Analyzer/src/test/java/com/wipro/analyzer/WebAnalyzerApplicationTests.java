package com.wipro.analyzer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebAnalyzerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamWebAnalyzerRequestShouldReturnWiproDigitalcom() throws Exception {

        this.mockMvc.perform(get("/wipro/webAnalyzer")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.linkName").value("http://wiprodigital.com/"))
                .andExpect(jsonPath("$.images").exists())
                .andExpect(jsonPath("$.externalLinks").exists());

        ;
    }

    @Test
    public void paramWebAnalyzerRequestShouldReturndomain() throws Exception {

        this.mockMvc.perform(get("/wipro/webAnalyzer").param("domain", "http://java.com/"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.linkName").value("http://java.com/"));
    }

    @Test
    public void checkWhenTherearenoChildLinks() throws Exception {

        this.mockMvc.perform(get("/wipro/webAnalyzer").param("domain", "http://java.com/"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.childLinks").doesNotExist());
    }

    @Test
    public void checkWhenThereareImages() throws Exception {

        this.mockMvc.perform(get("/wipro/webAnalyzer").param("domain", "http://java.com/"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.images").exists());
    }

}
