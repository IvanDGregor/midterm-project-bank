package com.ironhack.midtermprojectbank.service;

import com.ironhack.midtermprojectbank.dto.AccountPostDTO;
import com.ironhack.midtermprojectbank.dto.CheckingGetDTO;
import com.ironhack.midtermprojectbank.dto.TransferDTO;
import com.ironhack.midtermprojectbank.exception.AccountNotFoundException;
import com.ironhack.midtermprojectbank.exception.NotEnoughMoneyException;
import com.ironhack.midtermprojectbank.model.accounts.Checking;
import com.ironhack.midtermprojectbank.repository.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class CheckingService {
    @Autowired
    CheckingRepository checkingRepository;

    public CheckingGetDTO findByIdAccountAndIdOwner(Long idAccount, Long idOwner){
        LOGGER.info("Init findByIdAccountAndIdOwner service");
        LOGGER.info("Search account");
        Checking foundChecking = checkingRepository.findByIdAccountAndIdOwner(idAccount, idOwner);
        BigDecimal minBalance = foundChecking.getMinimumBalance();
        if(foundChecking.getBalance().getAmount().compareTo(minBalance) < 0){
            foundChecking.getBalance().decreaseAmount(foundChecking.getPenaltyFee());
            LOGGER.info("Found account " + foundChecking);
            return new CheckingGetDTO(foundChecking.getBalance().getAmount(),foundChecking.getBalance().getCurrency());
        }
        else {
            LOGGER.info("Found account " + foundChecking);
            return new CheckingGetDTO(foundChecking.getBalance().getAmount(),foundChecking.getBalance().getCurrency());
        }
    }

    public Checking findById(Long id) {
        LOGGER.info("Init findById service");
        return checkingRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

    @Transactional
    public TransferDTO transfer(Long idAccountSender, Long idOwnerSender, AccountPostDTO accountPostDTO){
        LOGGER.info("Init Transfer service");
        LOGGER.info("Search account");
        Checking foundSenderChecking = checkingRepository.findByIdAccountAndIdOwner(idAccountSender, idOwnerSender);
        if(foundSenderChecking == null){
            throw new AccountNotFoundException("Account not found with this ID");
        }
        if(accountPostDTO.getAmount().compareTo(foundSenderChecking.getBalance().getAmount()) > 0){
            throw new NotEnoughMoneyException("This account does not have enough balance");
        }

        Checking foundReceiverChecking = checkingRepository.findByIdAccountAndIdOwner(accountPostDTO.getIdAccountReceiver(), accountPostDTO.getIdOwnerReceiver());

        if(foundReceiverChecking == null){
            throw new AccountNotFoundException("It is not possible to make the transfer the indicated account cannot be found");
        }
        foundSenderChecking.getBalance().decreaseAmount(accountPostDTO.getAmount());
        checkingRepository.save(foundSenderChecking);
        foundReceiverChecking.getBalance().increaseAmount(accountPostDTO.getAmount());
        checkingRepository.save(foundReceiverChecking);
        LOGGER.info("Transfer done ");
        return new TransferDTO(foundSenderChecking.getId(),accountPostDTO.getAmount(),foundSenderChecking.getBalance().getAmount(),foundReceiverChecking.getId());
    }
}
