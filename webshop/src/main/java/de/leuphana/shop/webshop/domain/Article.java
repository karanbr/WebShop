package de.leuphana.shop.webshop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

// Article entity for persistence layer -> e.g. JPA or MongoDB
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    private UUID id;
    private String name;
    private String manufacturer;
    private Long price;
}
