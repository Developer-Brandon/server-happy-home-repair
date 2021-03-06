package com.dkstudio.happyhomerepair.repository;

import com.dkstudio.happyhomerepair.model.entity.Estimate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimateRepository extends JpaRepository<Estimate, Long>{
}
