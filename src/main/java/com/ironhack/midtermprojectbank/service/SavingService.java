package com.ironhack.midtermprojectbank.service;

import com.ironhack.midtermprojectbank.dto.AccountPostDTO;
import com.ironhack.midtermprojectbank.dto.SavingGetDTO;
import com.ironhack.midtermprojectbank.dto.TransferDTO;
import com.ironhack.midtermprojectbank.exception.AccountNotFoundException;
import com.ironhack.midtermprojectbank.exception.NotEnoughMoneyException;
import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import com.ironhack.midtermprojectbank.model.accounts.Savings;
import com.ironhack.midtermprojectbank.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.YEARS;
import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class SavingService {
    @Autowired
    SavingsRepository savingsRepository;

    public SavingGetDTO findByIdAccountAndIdOwner(Long idOwner, Long idAccount){
        LOGGER.info("Init findByIdAccountAndIdOwner service");
        LOGGER.info("Search account");
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
        LOGGER.info("Found Account");
        return new SavingGetDTO(foundSaving.getBalance().getAmount(), foundSaving.getBalance().getCurrency());
    }

    @Transactional
    public TransferDTO transfer(Long idAccountSender, Long idOwnerSender, AccountPostDTO accountPostDTO){
        LOGGER.info("Init transfer service");
        LOGGER.info("Search account");
        Savings foundSenderSaving = savingsRepository.findByIdAccountAndIdOwner(idAccountSender, idOwnerSender);
        if(foundSenderSaving == null){
            throw new AccountNotFoundException("Account not found with this ID");
        }
        if(accountPostDTO.getAmount().compareTo(foundSenderSaving.getBalance().getAmount()) > 0){
            throw new NotEnoughMoneyException("This account does not have enough balance");
        }

        Savings foundReceiverSaving = savingsRepository.findByIdAccountAndIdOwner(accountPostDTO.getIdAccountReceiver(), accountPostDTO.getIdOwnerReceiver());

        if(foundReceiverSaving == null){
            throw new AccountNotFoundException("It is not possible to make the transfer the indicated account cannot be found");
        }
        foundSenderSaving.getBalance().decreaseAmount(accountPostDTO.getAmount());
        savingsRepository.save(foundSenderSaving);
        foundReceiverSaving.getBalance().increaseAmount(accountPostDTO.getAmount());
        savingsRepository.save(foundReceiverSaving);
        LOGGER.info("Transfer Done");
        return new TransferDTO(foundSenderSaving.getId(),accountPostDTO.getAmount(),foundSenderSaving.getBalance().getAmount(),foundReceiverSaving.getId());
    }
}
