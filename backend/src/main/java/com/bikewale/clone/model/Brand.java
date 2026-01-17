package com.bikewale.clone.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String logoUrl;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Bike> bikes;

    public Brand() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLogoUrl() { return logoUrl; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }
    
    // Omitting getBikes to avoid infinite recursion in JSON if not handled, or using @JsonIgnore
}
