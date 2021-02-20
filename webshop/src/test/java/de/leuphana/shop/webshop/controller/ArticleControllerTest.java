package de.leuphana.shop.webshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.leuphana.shop.webshop.model.ArticleDto;
import de.leuphana.shop.webshop.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

import static org.junit.Assert.*;
//@Slf4j
//@RunWith(SpringRunner)
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
        given(articleService.getArticleById(any(UUID.class))).willReturn(validArticle);

//        mockMvc.perform(get("/api/article/" + validArticle.getId().toString()).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$.id", is(validArticle.getId().toString())))
//                .andExpect(jsonPath("$.name", is("Article1")));
    }

    @Test
    public void handlePost() throws Exception {
        //given
        ArticleDto articleDto = validArticle;
        //articleDto.setId(null);
        ArticleDto savedDto = ArticleDto.builder().id(UUID.randomUUID()).name("New Article").build();
        String articleDtoJson = objectMapper.writeValueAsString(articleDto);

        given(articleService.saveNewArticle(any())).willReturn(savedDto);

//        mockMvc.perform(post("/api/article/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(articleDtoJson))
//                .andExpect(status().isCreated());

    }

//    @Test
//    public void handleUpdate() throws Exception {
//        //given
//        ArticleDto articleDto = validArticle;
//        //articleDto.setId(null);
//        String articleDtoJson = objectMapper.writeValueAsString(articleDto);
//
//        given(articleService.updateArticle(articleDto.getId(), articleDto));
//        //when
////        mockMvc.perform(put("/api/v1/article/" + UUID.randomUUID())
////                .contentType(MediaType.APPLICATION_JSON)
////                .content(articleDtoJson))
////                .andExpect(status().isNoContent());
//
////        then(articleService).should().updateArticle(articleDto.getId(), articleDto);
////        then(articleService.updateArticle(articleDto.getId(), articleDto));
//    }

}