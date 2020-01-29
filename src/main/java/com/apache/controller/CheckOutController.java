package com.apache.controller;
 
import com.apache.model.Order;
import com.apache.model.UserAccount;
import com.apache.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins={"http://localhost:4200","http://localhost","http://localhost:4201"},allowedHeaders = "*")
@RequestMapping(value = "/eartwork/api/checkout",produces = MediaType.APPLICATION_JSON_VALUE)
public class CheckOutController {
    @Autowired
    private UserAccountService userAccountService;

    @PostMapping(value="/proceed/{userId}")
    public boolean checkout(@PathVariable Integer userId, @RequestBody Order ord){
        UserAccount userAccount = userAccountService.getUserAccountById(userId);
        if(userAccount!=null){
            userAccount.getOrder().add(ord);
            userAccountService.updateUserAccount(userAccount);
            return true;
        }

        return false;
    }
}
