package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {
}
