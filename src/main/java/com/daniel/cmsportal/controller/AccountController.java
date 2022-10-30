package com.daniel.cmsportal.controller;


import com.daniel.cmsportal.Repository.StudentRepository;
import com.daniel.cmsportal.Repository.UserRepository;
import com.daniel.cmsportal.Service.AccountService;
import com.daniel.cmsportal.model.Account;
import com.daniel.cmsportal.model.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private com.daniel.cmsportal.Repository.AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/list")
    public String getAll(Model model)
    {
            List<Account> accounts = accountRepository.findAll();
            model.addAttribute("accounts", accounts);

        return "/account/list";
    }


    @GetMapping("/detail")
    public String detail(Model model, @RequestParam(required = false) Long id)
    {

        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("students", studentRepository.findAll());

        if(id == null)
        {
            model.addAttribute("accountdto", new AccountDTO());
        }
        else
        {
            Account account = accountRepository.findById(id).orElse(null);
            AccountDTO accountdto = new AccountDTO(account);
            accountdto.setStudents(account.getStudents());
            accountdto.setUsers(account.getUsers());
            model.addAttribute("accountdto", accountdto);


        }
        return "/account/detail";
    }

    @PostMapping("/detail")
    public String newAccount(AccountDTO accountdto)
    {
        accountService.save(accountdto);

        return "redirect:/account/list ";
    }
}
