package com.ironhack.midtermprojectbank.controller.impl;

import com.ironhack.midtermprojectbank.controller.interfaces.AdminControllerInterface;
import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import com.ironhack.midtermprojectbank.model.accounts.Savings;
import com.ironhack.midtermprojectbank.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController implements AdminControllerInterface {
    @Autowired
    AdminService adminService;

    @PostMapping("/admin/create/saving")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings createAccount(@RequestBody Savings savings) {
        return adminService.createSaving(savings);
    }

    @PostMapping("/admin/create/credit-card")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard createAccount(@RequestBody CreditCard creditCard) {
        return adminService.createCreditCard(creditCard);
    }





}
