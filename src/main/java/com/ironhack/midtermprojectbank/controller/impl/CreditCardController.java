package com.ironhack.midtermprojectbank.controller.impl;

import com.ironhack.midtermprojectbank.dto.CreditCardGetDTO;
import com.ironhack.midtermprojectbank.dto.SavingGetDTO;
import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import com.ironhack.midtermprojectbank.service.CreditCardService;
import com.ironhack.midtermprojectbank.service.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;

    @GetMapping("/credit-card/{idOwner}/{idAccount}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCardGetDTO findByIdAccountAndIdOwner(@PathVariable Long idOwner, @PathVariable Long idAccount) {
        return creditCardService.findByIdAccountAndIdOwner(idOwner,idAccount);
    }
}
