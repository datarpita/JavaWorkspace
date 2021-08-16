package com.tsc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsc.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long>{

}
