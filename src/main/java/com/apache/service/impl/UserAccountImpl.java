package com.apache.service.impl;

import com.apache.model.UserAccount;
import com.apache.repository.UserAccountRepository;
import com.apache.service.UserAccountService;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountImpl implements UserAccountService {
    private UserAccountRepository userAccountRepository;

    public UserAccountImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount createNewUserAccount(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userAccountRepository.findAll(Sort.by("email"));
    }

    @Override
    public Optional<UserAccount> getUserAccountByEmail(String email) {
        return userAccountRepository.findByEmail(email);
    }

    @Override
    public UserAccount updateUserAccountById(UserAccount editedUserAccnt, Long userAccountId) {
        return userAccountRepository.findById(userAccountId)
                .map(userAcctToBeUpdated -> {
                    userAcctToBeUpdated.setFirstName(editedUserAccnt.getFirstName());
                    userAcctToBeUpdated.setLastName(editedUserAccnt.getLastName());
                    userAcctToBeUpdated.setEmail(editedUserAccnt.getEmail());
                    userAcctToBeUpdated.setLoginStatus(editedUserAccnt.getLoginStatus());
                    userAcctToBeUpdated.setPassword(editedUserAccnt.getPassword());
                    return userAccountRepository.save(userAcctToBeUpdated);
                }).orElseGet(() -> {
                    return userAccountRepository.save(editedUserAccnt);
                });
    }

    @Override
    public void deleteUserAccountById(Long userAccountId) {
      userAccountRepository.deleteById(userAccountId);
    }

    @Override
    public UserAccount getUserAccountById(long id) {
        return userAccountRepository.findById(id).orElse(null);
    }

    public UserAccount updateUserAccount(UserAccount userAccount){
        return userAccountRepository.save(userAccount);
    }

}

