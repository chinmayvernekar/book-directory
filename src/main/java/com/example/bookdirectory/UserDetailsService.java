package com.example.bookdirectory;

import com.example.bookdirectory.Register;
import com.example.bookdirectory.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Register user = userRepo.findByUserName(username).orElseThrow(() -> new RuntimeException("Error: User Not Found."));

        if(user == null){
            throw new UsernameNotFoundException("User Is Not Register With Us.Please Register To Uses Our Service");
        }

        Set<SimpleGrantedAuthority> authorities =  new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add( new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return new User(user.getUserName(), user.getPassword(), authorities);


    }
}
