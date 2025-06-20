package com.belajar.sales;

import com.belajar.sales.services.ProdukService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class ProdukTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProdukService produkService;

    public static String jwtToken;

    @BeforeAll
    public void loginAndGetToken() throws Exception {
        String loginJson = """
            {
                "username": "almi",
                "password": "123"
            }
        """;

        MvcResult result = mockMvc.perform(post("/auth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.token").exists())
                .andReturn();

        // Ambil token dari response
        String responseJson = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        jwtToken = mapper.readTree(responseJson).get("data").get("token").asText();
    }

    @Test
    public void serviceTest() throws Exception{
        var produk = produkService.getPageProduk("MIE",1);

        assertEquals("INDOMIE", produk.getContent().getFirst().getName());
        assertFalse(produk.getContent().isEmpty());
    }

    @Test
    public void endpointTest() throws Exception{

        mockMvc.perform(get("/produk").param("search","MI").header("Authorization", String.format("Bearer %s", jwtToken)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.[0].id").value("PEP"))
                .andExpect(jsonPath("$.data.length()").value(3));
    }

    @Test
    public void endpointPagedTest() throws Exception{
        mockMvc.perform(get("/produk/page").param("page","2").header("Authorization", String.format("Bearer %s", jwtToken)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.[0].id").value("ES"))
                .andExpect(jsonPath("$.data.length()").value(1));
    }
}
