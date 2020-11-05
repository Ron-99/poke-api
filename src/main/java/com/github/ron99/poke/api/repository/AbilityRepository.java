package com.github.ron99.poke.api.repository;

import com.github.ron99.poke.api.model.database.AbilityDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityRepository extends JpaRepository<AbilityDB, Integer> {
}
