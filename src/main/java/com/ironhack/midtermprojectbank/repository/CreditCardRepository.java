package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import com.ironhack.midtermprojectbank.model.accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    @Query(value = "SELECT * FROM credit_card WHERE id = ?1 AND primary_owner_id = ?2", nativeQuery = true)
    CreditCard findByIdAccountAndIdOwner(Long idAccount, Long idOwner);
}
