package com.recipeKeeper.RecipeBackend.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="recipes")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int cookTime;
    private String steps;
}
