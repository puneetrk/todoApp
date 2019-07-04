package com.pumakuki.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "puneet",
        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
    inMemoryUserList.add(new JwtUserDetails(1L, "pragati",
            "$2a$10$J7Puo3sshM9YYe7.DsCvn.yFYG6G8DgUA35uAQEVEYq2uP1CjL8iq", "ROLE_USER_2"));
    

  }
//
//  {
//	  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwdW5lZXQiLCJleHAiOjE1NTc5NzM0MzcsImlhdCI6MTU1NzM2ODYzN30.Ht8iHc_I1YkGSBEXUIlNrzenJ5vsh2p4tUNkBAmDGK86PV5xYwHdH52rsY1zZKrkAsAe9AeHRE_yoMpqfG3TzA"
//	  }
//  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


