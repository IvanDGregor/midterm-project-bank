package com.ironhack.midtermprojectbank.controller.impl;

import com.ironhack.midtermprojectbank.dto.AccountPostDTO;
import com.ironhack.midtermprojectbank.dto.CreditCardGetDTO;
import com.ironhack.midtermprojectbank.dto.TransferDTO;
import com.ironhack.midtermprojectbank.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;

    @GetMapping("/credit-card/{idOwner}/{idAccount}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCardGetDTO findByIdAccountAndIdOwner(@PathVariable Long idOwner, @PathVariable Long idAccount) {
        return creditCardService.findByIdAccountAndIdOwner(idOwner,idAccount);
    }
    @PostMapping("/credit-card/{idAccountSender}/{idOwnerSender}")
    @ResponseStatus(HttpStatus.OK)
    public TransferDTO transfer(@PathVariable Long idOwnerSender, @PathVariable Long idAccountSender, @RequestBody AccountPostDTO accountPostDTO) {
        return creditCardService.transfer(idAccountSender,idOwnerSender, accountPostDTO);
    }
}
