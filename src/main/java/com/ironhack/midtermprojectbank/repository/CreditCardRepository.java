package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
