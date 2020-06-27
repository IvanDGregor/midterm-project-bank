package com.ironhack.midtermprojectbank.controller.impl;

import com.ironhack.midtermprojectbank.controller.interfaces.CheckingControllerInterface;
import com.ironhack.midtermprojectbank.dto.CheckingGetDTO;
import com.ironhack.midtermprojectbank.dto.CreditCardGetDTO;
import com.ironhack.midtermprojectbank.model.accounts.Checking;
import com.ironhack.midtermprojectbank.service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckingController implements CheckingControllerInterface {
    @Autowired
    CheckingService checkingService;

    @GetMapping("/checking/{idOwner}/{idAccount}")
    @ResponseStatus(HttpStatus.OK)
    public CheckingGetDTO findByIdAccountAndIdOwner(@PathVariable Long idOwner, @PathVariable Long idAccount) {
        return checkingService.findByIdAccountAndIdOwner(idOwner,idAccount);
    }

}
