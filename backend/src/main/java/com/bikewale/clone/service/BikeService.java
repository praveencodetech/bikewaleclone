package com.bikewale.clone.service;

import com.bikewale.clone.model.Bike;
import com.bikewale.clone.model.Brand;
import com.bikewale.clone.repository.BikeRepository;
import com.bikewale.clone.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    public List<Bike> getBikesByBrand(Long brandId) {
        return bikeRepository.findByBrandId(brandId);
    }

    public Optional<Bike> getBikeById(Long id) {
        return bikeRepository.findById(id);
    }
    
    public List<Bike> searchBikes(String query) {
        return bikeRepository.findByNameContainingIgnoreCase(query);
    }
}
