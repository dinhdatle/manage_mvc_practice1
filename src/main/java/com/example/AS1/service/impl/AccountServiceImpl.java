package com.example.AS1.service.impl;

import com.example.AS1.entity.Account;
import com.example.AS1.repository.AccountRepository;
import com.example.AS1.service.AccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);

    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void updateAccount(Account account) {
        accountRepository.save(account);
    }
}
