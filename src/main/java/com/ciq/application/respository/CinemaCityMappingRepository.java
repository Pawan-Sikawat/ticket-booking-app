package com.ciq.application.respository;

import java.util.List;

import com.ciq.application.entity.Cinema;
import com.ciq.application.entity.CinemaCityMapping;
import com.ciq.application.entity.City;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaCityMappingRepository extends JpaRepository<CinemaCityMapping,Integer>{
    CinemaCityMapping findByCinema(Cinema cinema);
    List<CinemaCityMapping> findAllByCity(City city);
}
