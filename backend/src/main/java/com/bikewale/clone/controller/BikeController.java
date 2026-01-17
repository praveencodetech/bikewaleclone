package com.bikewale.clone.controller;

import com.bikewale.clone.model.Bike;
import com.bikewale.clone.model.Brand;
import com.bikewale.clone.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/brands")
    public List<Brand> getAllBrands() {
        return bikeService.getAllBrands();
    }

    @GetMapping("/bikes")
    public List<Bike> getAllBikes(@RequestParam(required = false) Long brandId) {
        if (brandId != null) {
            return bikeService.getBikesByBrand(brandId);
        }
        return bikeService.getAllBikes();
    }

    @GetMapping("/bikes/{id}")
    public ResponseEntity<Bike> getBikeById(@PathVariable Long id) {
        return bikeService.getBikeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public List<Bike> searchBikes(@RequestParam String query) {
        return bikeService.searchBikes(query);
    }
}
