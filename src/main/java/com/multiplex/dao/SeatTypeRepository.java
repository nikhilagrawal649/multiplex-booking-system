package com.multiplex.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.multiplex.entity.SeatType;

public interface SeatTypeRepository extends JpaRepository<SeatType,Integer> {

}