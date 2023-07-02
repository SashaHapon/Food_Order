package com.order.api.service;

import java.util.UUID;

public interface WalletService {
    double enrollmentMoney(UUID id, double enrollmentMoney);
    double writeOffMoneyOnCard(UUID id, double writeOffMoney);
}
