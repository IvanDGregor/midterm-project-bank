package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.accounts.Savings;
import com.ironhack.midtermprojectbank.model.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {
    @Query(value = "SELECT * FROM student_checking WHERE id = ?1 AND primary_owner_id = ?2", nativeQuery = true)
    Savings findByIdAccountAndIdOwner(Long idAccount, Long idOwner);
}
