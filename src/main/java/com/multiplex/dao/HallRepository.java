package com.multiplex.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.multiplex.entity.Hall;

public interface HallRepository extends JpaRepository<Hall, Integer> {

}