package com.ironhack.midtermprojectbank.service;

import com.ironhack.midtermprojectbank.dto.CheckingGetDTO;
import com.ironhack.midtermprojectbank.dto.CreditCardGetDTO;
import com.ironhack.midtermprojectbank.exception.AccountNotFoundException;
import com.ironhack.midtermprojectbank.model.accounts.Checking;
import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import com.ironhack.midtermprojectbank.repository.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CheckingService {
    @Autowired
    CheckingRepository checkingRepository;

    public CheckingGetDTO findByIdAccountAndIdOwner(Long idOwner, Long idAccount){
        Checking foundChecking = checkingRepository.findByIdAccountAndIdOwner(idOwner,idAccount);
        BigDecimal minBalance = foundChecking.getMinimumBalance();
        if(foundChecking.getBalance().getAmount().compareTo(minBalance) < 0){
            foundChecking.getBalance().decreaseAmount(foundChecking.getPenaltyFee());
            return new CheckingGetDTO(foundChecking.getBalance().getAmount(),foundChecking.getBalance().getCurrency());
        }
        else {
            return new CheckingGetDTO(foundChecking.getBalance().getAmount(),foundChecking.getBalance().getCurrency());
        }
    }
}
