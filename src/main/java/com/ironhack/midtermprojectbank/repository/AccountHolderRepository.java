package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder,Long> {
}
