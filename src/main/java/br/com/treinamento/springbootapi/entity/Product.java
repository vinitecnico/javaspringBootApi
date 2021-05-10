package br.com.treinamento.springbootapi.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double value;
    private String description;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    // @JsonIgnore
    private Set<Client> Clients = new HashSet<>();

    public Product() {
    }

    public Product(String name, Double value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }
}
