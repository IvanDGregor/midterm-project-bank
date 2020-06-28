package com.ironhack.midtermprojectbank.controller.impl;

import com.ironhack.midtermprojectbank.controller.interfaces.CheckingControllerInterface;
import com.ironhack.midtermprojectbank.dto.AccountPostDTO;
import com.ironhack.midtermprojectbank.dto.CheckingGetDTO;
import com.ironhack.midtermprojectbank.dto.CreditCardGetDTO;
import com.ironhack.midtermprojectbank.dto.TransferDTO;
import com.ironhack.midtermprojectbank.model.accounts.Checking;
import com.ironhack.midtermprojectbank.service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@RestController
public class CheckingController implements CheckingControllerInterface {
    @Autowired
    CheckingService checkingService;

    @GetMapping("/checking/{idAccount}/{idOwner}")
    @ResponseStatus(HttpStatus.OK)
    public CheckingGetDTO findByIdAccountAndIdOwner(@PathVariable Long idAccount, @PathVariable Long idOwner) {
        LOGGER.info("Calling Find by IdAccount and IdOwner service");
        return checkingService.findByIdAccountAndIdOwner(idAccount,idOwner);
    }

    @PostMapping("/checking/{idAccountSender}/{idOwnerSender}")
    @ResponseStatus(HttpStatus.OK)
    public TransferDTO transfer(@PathVariable Long idOwnerSender, @PathVariable Long idAccountSender, @RequestBody AccountPostDTO accountPostDTO) {
        LOGGER.info("Calling transfer Service");
        return checkingService.transfer(idAccountSender,idOwnerSender, accountPostDTO);
    }

}
