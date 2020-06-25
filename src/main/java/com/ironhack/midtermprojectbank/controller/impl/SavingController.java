package com.ironhack.midtermprojectbank.controller.impl;

import com.ironhack.midtermprojectbank.controller.interfaces.SavingControllerInterface;
import com.ironhack.midtermprojectbank.dto.SavingGetDTO;
import com.ironhack.midtermprojectbank.service.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SavingController implements SavingControllerInterface {
    @Autowired
    SavingService savingService;

    @GetMapping("/saving/{idOwner}/{idAccount}")
    @ResponseStatus(HttpStatus.OK)
    public SavingGetDTO findByIdAccountAndIdOwner(@PathVariable Long idOwner, @PathVariable Long idAccount) {
        return savingService.findByIdAccountAndIdOwner(idOwner,idAccount);
    }
}
