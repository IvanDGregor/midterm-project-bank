package com.ironhack.midtermprojectbank.service;

import com.ironhack.midtermprojectbank.dto.CreditCardGetDTO;
import com.ironhack.midtermprojectbank.model.accounts.CreditCard;
import com.ironhack.midtermprojectbank.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.MONTHS;

@Service
public class CreditCardService {
    @Autowired
    CreditCardRepository creditCardRepository;

    public CreditCardGetDTO findByIdAccountAndIdOwner(Long idOwner, Long idAccount){
        CreditCard foundCreditCard = creditCardRepository.findByIdAccountAndIdOwner(idOwner,idAccount);
        // Get the current time
        LocalDateTime now = LocalDateTime.now();
        //Calculate the number of Months
        Long monthsPrimaryOwner = MONTHS.between(foundCreditCard.getDateInterest(),now);
        //If the calculate Months are more than 1 add to balance the interest rate
        if(monthsPrimaryOwner >= 1){
            BigDecimal amountInterest = foundCreditCard.getInterestRate().divide(new BigDecimal("12")).multiply(BigDecimal.valueOf(monthsPrimaryOwner));
            foundCreditCard.getBalance().increaseAmount(amountInterest.multiply(foundCreditCard.getBalance().getAmount()));
            // Change the date for the next interest rate
            foundCreditCard.setDateInterest(foundCreditCard.getDateInterest().plusMonths(monthsPrimaryOwner));
            creditCardRepository.save(foundCreditCard);
        }
        return new CreditCardGetDTO(foundCreditCard.getBalance().getAmount(), foundCreditCard.getBalance().getCurrency());

    }
}
