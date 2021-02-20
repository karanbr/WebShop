package de.leuphana.shop.webshop.services;

import de.leuphana.shop.webshop.model.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j // Logger
@Service
public class ArticleServiceImpl implements ArticleService {

    private static List<ArticleDto> articleDtoList = new ArrayList<>();

    // Builder
    @Override
    public ArticleDto getArticleById(UUID articleId) {

        return ArticleDto.builder()
                .id(UUID.randomUUID())
                .manufacturer("Apple")
                .name("iPhone")
                .price(1299L)
                .build();
    }

    @Override
    public ArticleDto saveNewArticle(ArticleDto articleDto) {

        articleDtoList.add(articleDto);

        return ArticleDto.builder()
                .id(UUID.randomUUID())
                .manufacturer("Sony")
                .name("Playstation 5")
                .price(500L)
                .build();
    }

    @Override
    public void updateArticle(UUID articleId, ArticleDto articleDto) {
        // todo impl would update a real article

    }

    @Override
    public void deleteById(UUID articleId) {
        log.debug("Deleting an Article...");
    }
}
