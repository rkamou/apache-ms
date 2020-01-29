package com.apache.service.impl;

import java.util.ArrayList;
 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service; 

import com.apache.model.RoleUser;
import com.apache.model.ShoppingCart;
import com.apache.model.UserAccount;
import com.apache.repository.UserAccountRepository; 

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private  UserAccountRepository userAccountRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount user = userAccountRepository.findByEmail(username).orElse(null);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new ArrayList<>());
	}
	
	public UserAccount save(UserAccount user) {
		UserAccount newUser = new UserAccount();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		System.out.println("=====================");

        newUser.setRoleUser(RoleUser.CUSTOMER);
        newUser.setActive(true);
        newUser.setShoppingCart(new ShoppingCart());
        System.out.println("User About to be save : "+newUser.toString());
	    
        return userAccountRepository.save(newUser);
	}
}