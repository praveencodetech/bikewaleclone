package com.bikewale.clone.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double priceMin;
    private Double priceMax;
    private String imageUrl;
    
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @JsonIgnore
    private Brand brand;

    @OneToMany(mappedBy = "bike", cascade = CascadeType.ALL)
    private List<Specification> specifications;

    public Bike() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPriceMin() { return priceMin; }
    public void setPriceMin(Double priceMin) { this.priceMin = priceMin; }
    public Double getPriceMax() { return priceMax; }
    public void setPriceMax(Double priceMax) { this.priceMax = priceMax; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }
    public List<Specification> getSpecifications() { return specifications; }
    public void setSpecifications(List<Specification> specifications) { this.specifications = specifications; }
}
