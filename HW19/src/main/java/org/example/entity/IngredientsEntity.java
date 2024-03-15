package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ingredients")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class IngredientsEntity {


    @Id
    @SequenceGenerator(name = "ingredients_seq", sequenceName ="ingredients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredients_seq")
    private Integer id;

    //private Integer recipe_id;

    @Column(columnDefinition = "TEXT")
    private String name;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipe;
}
