package com.daniel.cmsportal.Repository;

import com.daniel.cmsportal.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    public List<Account> findAll();


}
