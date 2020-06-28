package com.ironhack.midtermprojectbank.controller.impl;

import com.ironhack.midtermprojectbank.controller.interfaces.SavingControllerInterface;
import com.ironhack.midtermprojectbank.dto.AccountPostDTO;
import com.ironhack.midtermprojectbank.dto.SavingGetDTO;
import com.ironhack.midtermprojectbank.dto.TransferDTO;
import com.ironhack.midtermprojectbank.service.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@RestController
public class SavingController implements SavingControllerInterface {
    @Autowired
    SavingService savingService;

    @GetMapping("/saving/{idOwner}/{idAccount}")
    @ResponseStatus(HttpStatus.OK)
    public SavingGetDTO findByIdAccountAndIdOwner(@PathVariable Long idOwner, @PathVariable Long idAccount) {
        LOGGER.info("Calling Saving find by IdAccount and IdOwner service");
        return savingService.findByIdAccountAndIdOwner(idOwner,idAccount);
    }
    @PostMapping("/saving/{idAccountSender}/{idOwnerSender}")
    @ResponseStatus(HttpStatus.OK)
    public TransferDTO transfer(@PathVariable Long idOwnerSender, @PathVariable Long idAccountSender, @RequestBody AccountPostDTO accountPostDTO) {
        LOGGER.info("Calling Saving transfer");
        return savingService.transfer(idAccountSender,idOwnerSender, accountPostDTO);
    }
}
