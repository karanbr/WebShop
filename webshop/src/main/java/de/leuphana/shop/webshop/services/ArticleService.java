package de.leuphana.shop.webshop.services;

import de.leuphana.shop.webshop.model.ArticleDto;

import java.util.UUID;

public interface ArticleService {
    ArticleDto getArticleById(UUID articleId);

    ArticleDto saveNewArticle(ArticleDto articleDto);

    void updateArticle(UUID articleId, ArticleDto articleDto);

    void deleteById(UUID articleId);
}
