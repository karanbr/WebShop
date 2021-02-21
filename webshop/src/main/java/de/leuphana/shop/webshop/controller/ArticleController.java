package de.leuphana.shop.webshop.controller;

import de.leuphana.shop.webshop.model.ArticleDto;
import de.leuphana.shop.webshop.services.ArticleService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
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

    @PostMapping // create a new Article
    public ResponseEntity handlePost(@Valid @RequestBody ArticleDto articleDto) {

        ArticleDto savedArticle = articleService.saveNewArticle(articleDto);

        // ResponseEntity needs a location Header
        HttpHeaders headers = new HttpHeaders();
        // todo Add host name to url
        headers.add("Location", "/api/v1/article" + savedArticle.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{articleId}"})
    public ResponseEntity handleUpdate (@PathVariable("articleId") UUID articleId, @Valid @RequestBody ArticleDto articleDto) {
        articleService.updateArticle(articleId, articleDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{articleId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT) // Alternative to returning the Status in the Method. THis way we simply use void and @RequestStatus
    public void handleDelete(@PathVariable("articleId") UUID articleId) {
        articleService.deleteById(articleId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
