package com.lilacode.smoothie.backend.ingredient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lilacode.smoothie.backend.smoothie.Smoothie;
import jakarta.persistence.*;

import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "INGREDIENT")
public class Ingredient {
    @Id
    @Column
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;
    @Column(name = "INGREDIENT_NAME")
    private String name;
    @Column
    private int amount;
    @ManyToOne
    @JoinColumn(name = "SMOOTHIE_ID", nullable = false)
    @JsonIgnore
    private Smoothie smoothie;

    public Ingredient() {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Smoothie getSmoothie() {
        return smoothie;
    }

    public void setSmoothie(Smoothie smoothie) {
        this.smoothie = smoothie;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Ingredient) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                this.amount == that.amount &&
                Objects.equals(this.smoothie, that.smoothie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount, smoothie);
    }

    @Override
    public String toString() {
        return "Ingredient[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "amount=" + amount + "]";
    }

}
