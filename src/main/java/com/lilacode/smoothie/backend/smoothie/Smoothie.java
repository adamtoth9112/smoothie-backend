package com.lilacode.smoothie.backend.smoothie;

import com.lilacode.smoothie.backend.ingredient.Ingredient;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "SMOOTHIE")
public class Smoothie {
    @Id
    @Column(name = "SMOOTHIE_ID")
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;
    @Column(name = "SMOOTHIE_NAME")
    private String name;
    @Column
    private String description;
    @OneToMany(mappedBy = "smoothie")
    private List<Ingredient> ingredients;

    public Smoothie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Smoothie) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "Smoothie[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "description=" + description + ", " +
                "ingredients=" + ingredients + ']';
    }

}
