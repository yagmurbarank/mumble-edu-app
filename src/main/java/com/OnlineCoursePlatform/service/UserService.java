package com.OnlineCoursePlatform.service;

import com.OnlineCoursePlatform.exception.ValidationException;
import com.OnlineCoursePlatform.model.User;
import com.OnlineCoursePlatform.repository.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository){

    this.userRepository=userRepository;

    }
    public List<User> getAllUsers(){
         return userRepository.findAll();
    }

public User addUser(User user) {
    if (userRepository.existsByEmail(user.getEmail())){
        throw new ValidationException("This user already exists.");
    }
    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    User savedUser = userRepository.save(user);
    return savedUser;
}
    public void deleteUser(Long userId){

        userRepository.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return List.of(new SimpleGrantedAuthority(user.getRole()));
    }
}


