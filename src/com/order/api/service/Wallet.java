package com.order.api.service;

import com.order.api.repository.AccountRepository;
import com.order.model.Meal;

import java.util.List;
import java.util.UUID;

public interface Wallet {
    double enrollmentMoney(UUID id, double enrollmentMoney);
    double writeOffMoneyOnCard(UUID id, double writeOffMoney);
}
