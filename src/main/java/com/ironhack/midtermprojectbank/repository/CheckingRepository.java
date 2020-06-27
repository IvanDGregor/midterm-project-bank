package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.accounts.Checking;
import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {
    @Query(value = "SELECT * FROM checking WHERE id = ?1 AND primary_owner_id = ?2", nativeQuery = true)
    Checking findByIdAccountAndIdOwner(Long idAccount, Long idOwner);
}
