package com.bikewale.clone.repository;

import com.bikewale.clone.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
    List<Bike> findByBrandId(Long brandId);
    List<Bike> findByNameContainingIgnoreCase(String name);
}
