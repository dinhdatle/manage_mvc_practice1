package com.example.AS1.service;

import com.example.AS1.entity.Account;

import java.util.List;

public interface AccountService {
    void saveAccount(Account account);
    void deleteAccountById(Long id);
    Account getAccountById(Long id);
    List<Account> getAllAccount();
    void updateAccount(Account account);

}
