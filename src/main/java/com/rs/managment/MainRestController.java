package com.rs.managment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/internal")
public class MainRestController {

    @Autowired
    AccountRepository accountRepository;

//    ResponseEntity<Account> upgradeAccount()
//    {
//
//    }

    // Restrict Origin of this Endpoint Invocation Strictly to be one of the Auth-Services Instances Only
    @PostMapping("create/account")
    ResponseEntity<String> createAccount(@RequestParam("cust_id") String cust_id)
    {
        Account account = new Account();
        account.setCust_id(cust_id); // declare this as a mongodb index as it will be queried frequently
        account.setAccount_type("BASIC");

        Account savedAccount =  accountRepository.save(account);

        return ResponseEntity.ok(savedAccount.getAccount_id());
    }


}
