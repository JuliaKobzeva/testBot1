package com.example.testbot2.repositories;

import com.example.testbot2.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Owner getOwnerByChatId(Long chatID);
    List<Owner> findAll();
}
