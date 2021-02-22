package de.leuphana.shop.webshop.mappers;

import de.leuphana.shop.webshop.domain.Article;
import de.leuphana.shop.webshop.model.ArticleDto;
import org.mapstruct.Mapper;

@Mapper // for mapstruct -> ArticleMapperImpl gets generated automatically (in target folder under mappers)
public interface ArticleMapper {

    ArticleDto articleToArticleDto(Article article);
    Article articleDtoToArticle(ArticleDto articleDto);
}
