package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {
    @Query(value = "SELECT * FROM savings WHERE id = ?1 AND primary_owner_id = ?2", nativeQuery = true)
    Savings findByIdAccountAndIdOwner(Long idAccount, Long idOwner);
}
