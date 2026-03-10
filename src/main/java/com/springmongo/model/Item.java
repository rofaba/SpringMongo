package com.springmongo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    private String id;

    @NotBlank(message = "El nombre es obligatorio")
    private String title;

    @NotBlank
    private Double price;

    @NotBlank
    private String category;

    @NotBlank
    private String description;

    @NotBlank
    private Double rate;

    @NotBlank
    private int count;

    @NotBlank
    private String color;

    @NotBlank
    private String manufacturer;

    @NotBlank
    private String EAN;

    @NotBlank
    private String image;
}