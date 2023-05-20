package com.sip.ams_back.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @NotBlank(message = "Label is mandatory")
    @Column(name = "label")
    private String label;



    @Column(name = "price")
    private float price;

    @Column(name = "picture")
    private String picture;


    public Article() {}


    public Article(String label, float price, String picture) {
        this.price = price;
        this.label = label;
        this.picture = picture;
    }


    public void setId(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }


    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }


    public float getPrice() {
        return price;
    }


    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getPicture() {
        return picture;
    }


    public void setPrice(float price) {
        this.price = price;
    }



    /**** Many To One ****/

    /****
     *
     FetchType.LAZY = Doesn’t load the relationships unless explicitly “asked for” via getter
     FetchType.EAGER = Loads ALL relationships
     */

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "provider_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Provider provider;


    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider=provider;
    }

}

