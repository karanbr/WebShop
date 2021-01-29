package de.leuphana.shop.webshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.leuphana.shop.webshop.model.ArticleDto;
import de.leuphana.shop.webshop.services.ArticleService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {

    @MockBean
    ArticleService articleService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    ArticleDto validArticle;

    @Before
    public void setUp() {
        validArticle = ArticleDto.builder()
                .id(UUID.randomUUID())
                .name("Book")
                .manufacturer("Springer")
                .price(399L)
                .build();
    }

    @Test
    public void getArticle() throws Exception{

    }

    @AfterEach
    void tearDown() {
    }
}