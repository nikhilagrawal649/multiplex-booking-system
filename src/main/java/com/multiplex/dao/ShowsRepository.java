package com.multiplex.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.multiplex.entity.Shows;

public interface ShowsRepository extends JpaRepository<Shows, Integer> {

}