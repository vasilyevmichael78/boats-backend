package com.Michael.boats.repo;

import com.Michael.boats.models.Boat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoatsRepository extends JpaRepository<Boat,Long> {

}
