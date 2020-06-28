package com.ironhack.midtermprojectbank.controller.impl;

import com.ironhack.midtermprojectbank.controller.interfaces.StudentCheckingControllerInterface;
import com.ironhack.midtermprojectbank.dto.AccountPostDTO;
import com.ironhack.midtermprojectbank.dto.SavingGetDTO;
import com.ironhack.midtermprojectbank.dto.StudentGetDTO;
import com.ironhack.midtermprojectbank.dto.TransferDTO;
import com.ironhack.midtermprojectbank.model.accounts.StudentChecking;
import com.ironhack.midtermprojectbank.service.SavingService;
import com.ironhack.midtermprojectbank.service.StudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@RestController
public class StudentCheckingController implements StudentCheckingControllerInterface {
    @Autowired
    StudentCheckingService studentCheckingService;

    @GetMapping("/student/{idOwner}/{idAccount}")
    @ResponseStatus(HttpStatus.OK)
    public StudentGetDTO findByIdAccountAndIdOwner(@PathVariable Long idOwner, @PathVariable Long idAccount) {
        LOGGER.info("Calling Student find by IdAccount and IdOwner");
        return studentCheckingService.findByIdAccountAndIdOwner(idOwner,idAccount);
    }
    @PostMapping("/student/{idAccountSender}/{idOwnerSender}")
    @ResponseStatus(HttpStatus.OK)
    public TransferDTO transfer(@PathVariable Long idOwnerSender, @PathVariable Long idAccountSender, @RequestBody AccountPostDTO accountPostDTO) {
        LOGGER.info("Calling Student transfer service");
        return studentCheckingService.transfer(idAccountSender,idOwnerSender, accountPostDTO);
    }
}
