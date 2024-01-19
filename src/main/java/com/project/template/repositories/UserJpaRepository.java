package com.project.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.template.entities.UserEntity;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long>{
}
