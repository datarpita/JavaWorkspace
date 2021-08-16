package com.tsc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsc.entity.Bike;

@Repository
public interface BikeDao extends JpaRepository<Bike, Long>{

}
