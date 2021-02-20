package de.leuphana.shop.webshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// -> Builder Pattern automatically implemented
// From Lombok -> Creates getters and setters
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {

    @Null
    private UUID id;

    @NotBlank
    private String manufacturer;

    @NotBlank
    private String name;

    @Positive
    private Long price;



}
