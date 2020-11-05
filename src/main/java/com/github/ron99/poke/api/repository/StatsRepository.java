package com.github.ron99.poke.api.repository;

import com.github.ron99.poke.api.model.database.StatsDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<StatsDB, Integer> {
}
