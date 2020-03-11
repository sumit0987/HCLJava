package com.example.timetracking.timetrackingJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.timetracking.timetrackingJPA.bean.SwipeMovement;

@Repository
public interface SwipeMovementRepository extends JpaRepository<SwipeMovement, Integer> {

}
