package com.ironhack.midtermprojectbank.controller.impl;

import com.ironhack.midtermprojectbank.controller.interfaces.AdminControllerInterface;
import com.ironhack.midtermprojectbank.dto.CheckingPostDTO;
import com.ironhack.midtermprojectbank.dto.CreditCardPostDTO;
import com.ironhack.midtermprojectbank.dto.SavingPostDTO;
import com.ironhack.midtermprojectbank.model.accounts.Checking;
import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import com.ironhack.midtermprojectbank.model.accounts.Savings;
import com.ironhack.midtermprojectbank.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController implements AdminControllerInterface {
    @Autowired
    AdminService adminService;

    @PostMapping("/admin/create/saving")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings createAccount(@RequestBody SavingPostDTO savingPostDTO) {
        return adminService.createSaving(savingPostDTO);
    }

    @PostMapping("/admin/create/credit-card")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard createAccount(@RequestBody CreditCardPostDTO creditCard) {
        return adminService.createCreditCard(creditCard);
    }

    @PostMapping("/admin/create/checking")
    @ResponseStatus(HttpStatus.CREATED)
    public String createAccount(@RequestBody CheckingPostDTO checking) {
        return adminService.createChecking(checking);
    }
}
