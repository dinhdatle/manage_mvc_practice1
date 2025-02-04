package com.example.AS1.controller;

import com.example.AS1.entity.Account;
import com.example.AS1.service.AccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;

    public AccountController(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getAllAccount(Model model) {
        model.addAttribute("accounts",accountService.getAllAccount());
        return "accounts/list";

    }

    @GetMapping("/add")
    public String addAccount(Model model) {
        model.addAttribute("account", new Account());
        return "accounts/add";
    }

    @PostMapping("/add")
    public String addAccount(@ModelAttribute Account account) {
        accountService.saveAccount(account);
        return "redirect:/accounts";
    }

    @GetMapping("/edit/{id}")
    public String editAccount(@PathVariable("id") Long id, Model model) {
        model.addAttribute("account", accountService.getAccountById(id));
        return "accounts/edit";
    }

    @PostMapping("edit/{id}")
    public String editAccount(@PathVariable("id") Long id, @ModelAttribute Account account, @RequestParam(required = false) String password) {
        account.setId(id);
        if (password != null && !password.isEmpty()) {
            account.setPassword(passwordEncoder.encode(password));
        }
        accountService.saveAccount(account);
        return "redirect:/accounts";
    }
}
