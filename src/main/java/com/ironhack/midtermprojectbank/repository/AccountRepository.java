package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.accounts.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
