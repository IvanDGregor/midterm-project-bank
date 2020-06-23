package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {
}
