package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RecipeEntity {


    @Id
    @SequenceGenerator(name = "recipes_seq", sequenceName ="recipes_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipes_seq")
    Integer id;


    @Column(columnDefinition = "TEXT")
    private String name;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<IngredientsEntity> ingredientsEntityList = new ArrayList<>();
}
