package com.tugasakhirminggu.busakap.service;

import com.tugasakhirminggu.busakap.model.PenumpangModel;
import com.tugasakhirminggu.busakap.repository.PenumpangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtPenumpangDetailService implements UserDetailsService {
    @Autowired
    PenumpangRepository penumpangRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PenumpangModel penumpangModel = penumpangRepository.findByUsername(username);
        return new User(penumpangModel.getUsername(), penumpangModel.getPassword(),
                new ArrayList<>());
    }
}
