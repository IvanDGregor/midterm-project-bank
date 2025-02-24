package com.ironhack.midtermprojectbank.service;

import com.ironhack.midtermprojectbank.dto.CheckingPostDTO;
import com.ironhack.midtermprojectbank.dto.CreditCardPostDTO;
import com.ironhack.midtermprojectbank.dto.SavingPostDTO;
import com.ironhack.midtermprojectbank.exception.IllegalCreditLimit;
import com.ironhack.midtermprojectbank.exception.IllegalInterestRateException;
import com.ironhack.midtermprojectbank.exception.IllegalMinimumBalance;
import com.ironhack.midtermprojectbank.exception.UserNotFoundException;
import com.ironhack.midtermprojectbank.model.accounts.Checking;
import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import com.ironhack.midtermprojectbank.model.accounts.Savings;
import com.ironhack.midtermprojectbank.model.accounts.StudentChecking;
import com.ironhack.midtermprojectbank.model.currency.Money;
import com.ironhack.midtermprojectbank.model.users.AccountHolder;
import com.ironhack.midtermprojectbank.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;
    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    public Savings createSaving(SavingPostDTO newAccount) throws IllegalInterestRateException{
        LOGGER.info("Init createSaving service");
        LOGGER.info("Search owner");
        AccountHolder foundPrimaryOwner = accountHolderRepository.findById(newAccount.getIdPrimaryOwner()).orElseThrow(() -> new UserNotFoundException("Not User found with this ID"));
        AccountHolder foundSecondaryOwner = null;
        LOGGER.info(foundPrimaryOwner);
        if(newAccount.getIdSecondaryOwner() != null){
            LOGGER.info("Found Account with secondary owner");
            foundSecondaryOwner = accountHolderRepository.findById(newAccount.getIdSecondaryOwner()).orElse(null);
        }
        Savings newSaving = new Savings(new Money(newAccount.getBalance()),foundPrimaryOwner,foundSecondaryOwner,newAccount.getSecretKey(), newAccount.getMinimumBalance(),newAccount.getInterestRate());
        BigDecimal maxInterestRate = new BigDecimal("0.5");
        BigDecimal maxMinimumBalance = new BigDecimal("1000");
        BigDecimal minMinimumBalance = new BigDecimal("100");

        if(newSaving.getInterestRate() == null){
            newSaving.setInterestRate(new BigDecimal("0.0025"));
        }
        else if(newSaving.getInterestRate().compareTo(maxInterestRate) > 0){
            throw new IllegalInterestRateException("Invalid Interest Rate the max Interest Rate is 0.5");
        }
        else if(newSaving.getInterestRate().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalInterestRateException("Invalid Interest Rate must be positive");
        }

        if(newSaving.getMinimumBalance() == null){
            newSaving.setMinimumBalance(new BigDecimal("1000"));
        }
        else if(newSaving.getMinimumBalance().compareTo(maxMinimumBalance) > 0 || newSaving.getMinimumBalance().compareTo(minMinimumBalance) < 0){
            throw new IllegalMinimumBalance("Invalid Minimum Balance");
        }
        LOGGER.info("Save Account " + newSaving);
        return savingsRepository.save(newSaving);
    }

    public CreditCard createCreditCard(CreditCardPostDTO newAccount) {
        LOGGER.info("Init createCreditCard service");
        LOGGER.info("Search owner");
        AccountHolder foundPrimaryOwner = accountHolderRepository.findById(newAccount.getIdPrimaryOwner()).orElseThrow(() -> new UserNotFoundException("Not User found with this ID"));
        AccountHolder foundSecondaryOwner = null;
        if(newAccount.getIdSecondaryOwner() != null){
            foundSecondaryOwner = accountHolderRepository.findById(newAccount.getIdSecondaryOwner()).orElse(null);
        }
        CreditCard newCreditCard = new CreditCard(new Money(newAccount.getBalance()), foundPrimaryOwner, foundSecondaryOwner,newAccount.getCreditLimit(), newAccount.getInterestRate());
        BigDecimal maxCreditLimit = new BigDecimal("100000");
        BigDecimal minCreditLimit = new BigDecimal("100");
        BigDecimal minInterestRate = new BigDecimal("0.1");
        BigDecimal maxInterestRate = new BigDecimal("0.2");

        if (newCreditCard.getCreditLimit() == null) {
            newCreditCard.setCreditLimit(new BigDecimal("100"));
        } else if (newCreditCard.getCreditLimit().compareTo(maxCreditLimit) > 0 || newCreditCard.getCreditLimit().compareTo(minCreditLimit) < 0) {
            throw new IllegalCreditLimit("Invalid Credit Limit must be beetween 100 and 100000");
        }

        if (newCreditCard.getInterestRate() == null) {
            newCreditCard.setInterestRate(new BigDecimal("0.2"));
        } else if (newCreditCard.getInterestRate().compareTo(maxInterestRate) > 0 || newCreditCard.getInterestRate().compareTo(minInterestRate) < 0) {
            throw new IllegalInterestRateException("Interest Rate must be lower than 0.2 and higher than 0.1");
        }
        LOGGER.info("Save new account " + newCreditCard);
        return creditCardRepository.save(newCreditCard);
    }

    public String createChecking(CheckingPostDTO newAccount){
        LOGGER.info("Init createChecking service");
        LOGGER.info("Search Owner");
        AccountHolder foundPrimaryOwner = accountHolderRepository.findById(newAccount.getIdPrimaryOwner()).orElseThrow(() -> new UserNotFoundException("Not User found with this ID"));
        AccountHolder foundSecondaryOwner = null;
        if(newAccount.getIdSecondaryOwner() != null){
            foundSecondaryOwner = accountHolderRepository.findById(newAccount.getIdSecondaryOwner()).orElse(null);
        }
        Checking newChecking = new Checking(new Money(newAccount.getBalance()), foundPrimaryOwner, foundSecondaryOwner,newAccount.getSecretKey(), newAccount.getMinimumBalance(),newAccount.getMonthlyMaintenanceFee());
        BigDecimal min = new BigDecimal("100");


        if(newChecking.getMonthlyMaintenanceFee() == null){
            newChecking.setMonthlyMaintenanceFee(new BigDecimal("12"));
        }
        if (newChecking.getMinimumBalance() == null) {
            newChecking.setMinimumBalance(new BigDecimal("250"));
        }
        else if (newChecking.getMinimumBalance().compareTo(BigDecimal.ZERO) < 0 || newChecking.getMonthlyMaintenanceFee().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid Minimum Balance or Monthly Maintenance Fee");
        }
        // Get the current time
        LocalDateTime now = LocalDateTime.now();
        // Calculate the days between current time and the date of Birth of the Primary Owner
        Long daysPrimaryOwner = DAYS.between(foundPrimaryOwner.getDateOfBirth(),now);
        // 24 years == 8760 days if the primary Owner have less 8760 days then created
        // a StudentChecking otherwise created a Checking Account
        if(daysPrimaryOwner < 8760){
            StudentChecking newStudentChecking = new StudentChecking(new Money(newAccount.getBalance()),foundPrimaryOwner,foundSecondaryOwner,newAccount.getSecretKey());
            studentCheckingRepository.save(newStudentChecking);
            LOGGER.info("Save new Account " + newChecking);
            return "StudentChecking account created";
        }
        else {
            LOGGER.info("Save new Account " + newChecking);
            checkingRepository.save(newChecking);
            return "Checking account created";
        }
    }
}
