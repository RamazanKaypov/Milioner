package com.example.milioner.repository;

import com.example.milioner.entity.Levels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "levels")
public interface LevelRepository extends JpaRepository<Levels,Integer> {

    Levels getLevelsByLevel(int level);


}
