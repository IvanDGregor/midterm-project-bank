package com.ironhack.midtermprojectbank.service;

import com.ironhack.midtermprojectbank.exception.AccountNotFoundException;
import com.ironhack.midtermprojectbank.model.accounts.Checking;
import com.ironhack.midtermprojectbank.repository.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CheckingService {
    @Autowired
    CheckingRepository checkingRepository;

    public List<Checking> findAll() {
        return checkingRepository.findAll();
    }

    public Checking findById(Long id) {
        Checking checkingFound = checkingRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Not found an account with his ID."));
        BigDecimal minBalance = checkingFound.getMinimumBalance();
        if(checkingFound.getBalance().getAmount().compareTo(minBalance) < 0){
            checkingFound.getBalance().decreaseAmount(checkingFound.getPenaltyFee());
            return checkingFound;
        }
        else
            return checkingFound;
    }
}
