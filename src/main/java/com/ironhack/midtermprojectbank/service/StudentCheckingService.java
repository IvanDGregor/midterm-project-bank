package com.ironhack.midtermprojectbank.service;

import com.ironhack.midtermprojectbank.dto.AccountPostDTO;
import com.ironhack.midtermprojectbank.dto.SavingGetDTO;
import com.ironhack.midtermprojectbank.dto.StudentGetDTO;
import com.ironhack.midtermprojectbank.dto.TransferDTO;
import com.ironhack.midtermprojectbank.exception.AccountNotFoundException;
import com.ironhack.midtermprojectbank.exception.NotEnoughMoneyException;
import com.ironhack.midtermprojectbank.model.accounts.Savings;
import com.ironhack.midtermprojectbank.model.accounts.StudentChecking;
import com.ironhack.midtermprojectbank.repository.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class StudentCheckingService {

    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    public StudentGetDTO findByIdAccountAndIdOwner(Long idOwner, Long idAccount){
        LOGGER.info("Init findByIdAccountAndIdOwner service");
        LOGGER.info("Search account");
        StudentChecking foundStudent = studentCheckingRepository.findByIdAccountAndIdOwner(idOwner,idAccount);
        if(foundStudent == null){
            throw new AccountNotFoundException("No found Account with this ID");
        }
        LOGGER.info("Found Account");
        return new StudentGetDTO(foundStudent.getBalance().getAmount(), foundStudent.getBalance().getCurrency());
    }

    @Transactional
    public TransferDTO transfer(Long idAccountSender, Long idOwnerSender, AccountPostDTO accountPostDTO){
        LOGGER.info("Init transfer service");
        LOGGER.info("Search account");
        Savings foundSenderStudent = studentCheckingRepository.findByIdAccountAndIdOwner(idAccountSender, idOwnerSender);
        if(foundSenderStudent == null){
            throw new AccountNotFoundException("Account not found with this ID");
        }
        if(accountPostDTO.getAmount().compareTo(foundSenderStudent.getBalance().getAmount()) > 0){
            throw new NotEnoughMoneyException("This account does not have enough balance");
        }

        Savings foundReceiverStudent = studentCheckingRepository.findByIdAccountAndIdOwner(accountPostDTO.getIdAccountReceiver(), accountPostDTO.getIdOwnerReceiver());

        if(foundReceiverStudent == null){
            throw new AccountNotFoundException("It is not possible to make the transfer the indicated account cannot be found");
        }
        foundSenderStudent.getBalance().decreaseAmount(accountPostDTO.getAmount());
        studentCheckingRepository.save(foundSenderStudent);
        foundReceiverStudent.getBalance().increaseAmount(accountPostDTO.getAmount());
        studentCheckingRepository.save(foundReceiverStudent);
        LOGGER.info("Transfer Done");
        return new TransferDTO(foundSenderStudent.getId(),accountPostDTO.getAmount(),foundSenderStudent.getBalance().getAmount(),foundReceiverStudent.getId());
    }
}
