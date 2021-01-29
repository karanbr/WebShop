package de.leuphana.shop.webshop.services;

import de.leuphana.shop.webshop.model.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {
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
}
