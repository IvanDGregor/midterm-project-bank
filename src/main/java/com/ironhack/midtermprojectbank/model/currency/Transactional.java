package com.ironhack.midtermprojectbank.model.currency;

import java.math.BigDecimal;
interface Transactional {
    BigDecimal increaseAmount(BigDecimal addAmount);
    BigDecimal decreaseAmount(BigDecimal addAmount);
    String toString();
}