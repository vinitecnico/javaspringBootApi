package br.com.treinamento.springbootapi.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "CLIENT_PRODUCT", joinColumns = { @JoinColumn(name = "CLIENT_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "PRODUCT_ID") })
    public Set<Product> products = new HashSet<>();

    public Client() {
    }

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getters and setters, equals(), toString() .... (omitted for brevity)
}
