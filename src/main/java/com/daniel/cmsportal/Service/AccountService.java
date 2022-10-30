package com.daniel.cmsportal.Service;


import com.daniel.cmsportal.Repository.AccountRepository;
import com.daniel.cmsportal.Repository.StudentRepository;
import com.daniel.cmsportal.Repository.UserRepository;
import com.daniel.cmsportal.model.Account;
import com.daniel.cmsportal.model.AccountDTO;
import com.daniel.cmsportal.model.Student;
import com.daniel.cmsportal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;


    public Account save(Account account)
    {

        account.getStudents().add(account.getAddStudent());

        //User user = userRepository.findByid(user_id);
        account.getUsers().add(account.getAddUser());


        return accountRepository.save(account);

    }


    public Account save(AccountDTO accountdto){
        Account account = accountRepository.findById(accountdto.getId()).orElse(null);

        if(accountdto.getStudentappend() != null) {
            account.getStudents().add(accountdto.getStudentappend());
        }
        if(accountdto.getUserappend() != null) {
            account.getUsers().add(accountdto.getUserappend());
        }
        accountRepository.save(account);
        return account;
    }


}
