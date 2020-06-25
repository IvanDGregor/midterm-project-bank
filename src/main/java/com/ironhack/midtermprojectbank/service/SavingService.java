package com.ironhack.midtermprojectbank.service;

import com.ironhack.midtermprojectbank.dto.SavingGetDTO;
import com.ironhack.midtermprojectbank.model.accounts.Savings;
import com.ironhack.midtermprojectbank.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.YEARS;

@Service
public class SavingService {
    @Autowired
    SavingsRepository savingsRepository;

    public SavingGetDTO findByIdAccountAndIdOwner(Long idOwner, Long idAccount){
        Savings foundSaving = savingsRepository.findByIdAccountAndIdOwner(idOwner,idAccount);
        // Get the current time
        LocalDateTime now = LocalDateTime.now();
        //Calculate the number of Years
        Long yearsPrimaryOwner = YEARS.between(foundSaving.getDateInterest(),now);
        //If the calculate years are more than 1 add to balance the interest rate
        if(yearsPrimaryOwner >= 1){
            BigDecimal amountInterest = foundSaving.getInterestRate().multiply(BigDecimal.valueOf(yearsPrimaryOwner));
            foundSaving.getBalance().increaseAmount(amountInterest.multiply(foundSaving.getBalance().getAmount()));
            foundSaving.setDateInterest(foundSaving.getDateInterest().plusYears(yearsPrimaryOwner));
            savingsRepository.save(foundSaving);
        }

        return new SavingGetDTO(foundSaving.getBalance().getAmount(), foundSaving.getBalance().getCurrency());
    }
}
