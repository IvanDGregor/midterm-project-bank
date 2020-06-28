package com.ironhack.midtermprojectbank.service;

import com.ironhack.midtermprojectbank.dto.AccountPostDTO;
import com.ironhack.midtermprojectbank.dto.CreditCardGetDTO;
import com.ironhack.midtermprojectbank.dto.TransferDTO;
import com.ironhack.midtermprojectbank.exception.AccountNotFoundException;
import com.ironhack.midtermprojectbank.exception.NotEnoughMoneyException;
import com.ironhack.midtermprojectbank.model.accounts.Checking;
import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import com.ironhack.midtermprojectbank.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.MONTHS;
import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class CreditCardService {
    @Autowired
    CreditCardRepository creditCardRepository;

    public CreditCardGetDTO findByIdAccountAndIdOwner(Long idOwner, Long idAccount){
        LOGGER.info("Init findByIdAccountAndIdOwner service");
        LOGGER.info("Search account");
        CreditCard foundCreditCard = creditCardRepository.findByIdAccountAndIdOwner(idOwner,idAccount);
        // Get the current time
        LocalDateTime now = LocalDateTime.now();
        //Calculate the number of Months
        Long monthsPrimaryOwner = MONTHS.between(foundCreditCard.getDateInterest(),now);
        //If the calculate Months are more than 1 add to balance the interest rate
        if(monthsPrimaryOwner >= 1){
            BigDecimal amountInterest = foundCreditCard.getInterestRate().divide(new BigDecimal("12")).multiply(BigDecimal.valueOf(monthsPrimaryOwner));
            foundCreditCard.getBalance().increaseAmount(amountInterest.multiply(foundCreditCard.getBalance().getAmount()));
            // Change the date for the next interest rate
            foundCreditCard.setDateInterest(foundCreditCard.getDateInterest().plusMonths(monthsPrimaryOwner));
            creditCardRepository.save(foundCreditCard);
        }
        LOGGER.info("Find account");
        return new CreditCardGetDTO(foundCreditCard.getBalance().getAmount(), foundCreditCard.getBalance().getCurrency());
    }

    @Transactional
    public TransferDTO transfer(Long idAccountSender, Long idOwnerSender, AccountPostDTO accountPostDTO){
        LOGGER.info("Init transfer service");
        LOGGER.info("Search account");
        CreditCard foundSenderCrecitCard = creditCardRepository.findByIdAccountAndIdOwner(idAccountSender, idOwnerSender);
        if(foundSenderCrecitCard == null){
            throw new AccountNotFoundException("Account not found with this ID");
        }
        if(accountPostDTO.getAmount().compareTo(foundSenderCrecitCard.getBalance().getAmount()) > 0){
            throw new NotEnoughMoneyException("This account does not have enough balance");
        }

        CreditCard foundReceiverCreditCard = creditCardRepository.findByIdAccountAndIdOwner(accountPostDTO.getIdAccountReceiver(), accountPostDTO.getIdOwnerReceiver());

        if(foundReceiverCreditCard == null){
            throw new AccountNotFoundException("It is not possible to make the transfer the indicated account cannot be found");
        }
        foundSenderCrecitCard.getBalance().decreaseAmount(accountPostDTO.getAmount());
        creditCardRepository.save(foundSenderCrecitCard);
        foundReceiverCreditCard.getBalance().increaseAmount(accountPostDTO.getAmount());
        creditCardRepository.save(foundReceiverCreditCard);

        LOGGER.info("Transfer Done");
        return new TransferDTO(foundSenderCrecitCard.getId(),accountPostDTO.getAmount(),foundSenderCrecitCard.getBalance().getAmount(),foundReceiverCreditCard.getId());
    }
}
