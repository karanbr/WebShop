package de.leuphana.shop.webshop.controller;

import de.leuphana.shop.webshop.model.ArticleDto;
import de.leuphana.shop.webshop.services.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/article")
@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping({"/{articleId}"})
    public ResponseEntity<ArticleDto> getArticle(@PathVariable("articleId") UUID articleId) {
        return new ResponseEntity<>(articleService.getArticleById(articleId), HttpStatus.OK);
    }
}
