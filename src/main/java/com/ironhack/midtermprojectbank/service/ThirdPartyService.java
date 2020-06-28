package com.ironhack.midtermprojectbank.service;

import com.ironhack.midtermprojectbank.dto.ThirdPartyPostDTO;
import com.ironhack.midtermprojectbank.exception.AccountNotFoundException;
import com.ironhack.midtermprojectbank.model.accounts.Checking;
import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import com.ironhack.midtermprojectbank.model.accounts.Savings;
import com.ironhack.midtermprojectbank.model.accounts.StudentChecking;
import com.ironhack.midtermprojectbank.model.users.ThirdParty;
import com.ironhack.midtermprojectbank.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class ThirdPartyService {

    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;
    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    CreditCardRepository creditCardRepository;

    public String debit(String hashKey, ThirdPartyPostDTO thirdPartyPostDTO){
        LOGGER.info("Init debit Third Party service");
        LOGGER.info("Search Third Party");
        ThirdParty foundThirdParty = thirdPartyRepository.findByHashKey(hashKey);

        if(foundThirdParty != null){
            StudentChecking foundStudent = studentCheckingRepository.findById(thirdPartyPostDTO.getIdAccount()).orElse(null);
            if(foundStudent != null){
                foundStudent.getBalance().decreaseAmount(thirdPartyPostDTO.getAmount());
                studentCheckingRepository.save(foundStudent);
                return "Subtract " + thirdPartyPostDTO.getAmount() + " to Account: " + foundStudent.getId();
            }
            Checking foundChecking = checkingRepository.findById(thirdPartyPostDTO.getIdAccount()).orElse(null);
            if(foundChecking != null){
                foundChecking.getBalance().decreaseAmount(thirdPartyPostDTO.getAmount());
                checkingRepository.save(foundChecking);
                return "Subtract " + thirdPartyPostDTO.getAmount() + " to Account: " + foundChecking.getId();
            }
            Savings foundSaving = savingsRepository.findById(thirdPartyPostDTO.getIdAccount()).orElse(null);
            if(foundSaving != null){
                foundSaving.getBalance().decreaseAmount(thirdPartyPostDTO.getAmount());
                savingsRepository.save(foundSaving);
                return "Subtract " + thirdPartyPostDTO.getAmount() + " to Account: " + foundSaving.getId();
            }
            CreditCard foundCreditCard = creditCardRepository.findById(thirdPartyPostDTO.getIdAccount()).orElse(null);
            if (foundCreditCard != null) {
                foundCreditCard.getBalance().decreaseAmount(thirdPartyPostDTO.getAmount());
                creditCardRepository.save(foundCreditCard);
                return "Subtract " + thirdPartyPostDTO.getAmount() + " to Account: " + foundCreditCard.getId();
            }
            throw new AccountNotFoundException("Not found any account");
        }
        else {
            throw new AccountNotFoundException("Not Third Party found with this HashKey");
        }
    }

    public String credit(String hashKey, ThirdPartyPostDTO thirdPartyPostDTO){
        LOGGER.info("Init debit Third Party service");
        LOGGER.info("Search Third Party");
        ThirdParty foundThirdParty = thirdPartyRepository.findByHashKey(hashKey);

        if(foundThirdParty != null){
            StudentChecking foundStudent = studentCheckingRepository.findById(thirdPartyPostDTO.getIdAccount()).orElse(null);
            if(foundStudent != null){
                foundStudent.getBalance().increaseAmount(thirdPartyPostDTO.getAmount());
                studentCheckingRepository.save(foundStudent);
                return "Add " + thirdPartyPostDTO.getAmount() + " to Account: " + foundStudent.getId();
            }
            Checking foundChecking = checkingRepository.findById(thirdPartyPostDTO.getIdAccount()).orElse(null);
            if(foundChecking != null){
                foundChecking.getBalance().increaseAmount(thirdPartyPostDTO.getAmount());
                checkingRepository.save(foundChecking);
                return "Add " + thirdPartyPostDTO.getAmount() + " to Account: " + foundChecking.getId();
            }
            Savings foundSaving = savingsRepository.findById(thirdPartyPostDTO.getIdAccount()).orElse(null);
            if(foundSaving != null){
                foundSaving.getBalance().increaseAmount(thirdPartyPostDTO.getAmount());
                savingsRepository.save(foundSaving);
                return "Add " + thirdPartyPostDTO.getAmount() + " to Account: " + foundSaving.getId();
            }
            CreditCard foundCreditCard = creditCardRepository.findById(thirdPartyPostDTO.getIdAccount()).orElse(null);
            if (foundCreditCard != null) {
                foundCreditCard.getBalance().increaseAmount(thirdPartyPostDTO.getAmount());
                creditCardRepository.save(foundCreditCard);
                return "Add " + thirdPartyPostDTO.getAmount() + " to Account: " + foundCreditCard.getId();
            }
            throw new AccountNotFoundException("Not found any account");
        }
        else {
            throw new AccountNotFoundException("Not Third Party found with this HashKey");
        }
    }
}
