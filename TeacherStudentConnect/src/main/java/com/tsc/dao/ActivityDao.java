package com.tsc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsc.entity.Activity;

@Repository
public interface ActivityDao extends JpaRepository<Activity, Long>{

}
