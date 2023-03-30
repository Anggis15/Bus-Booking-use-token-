package com.tugasakhirminggu.busakap.controller;

import com.tugasakhirminggu.busakap.config.JwtTokenUtil;
import com.tugasakhirminggu.busakap.model.PenumpangModel;
import com.tugasakhirminggu.busakap.repository.PenumpangRepository;
import com.tugasakhirminggu.busakap.service.JwtPenumpangDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PenumpangController {
    @Autowired
    AuthenticationManager authManager;

    @Autowired
    PenumpangRepository penumpangRepository;

    @Autowired
    JwtPenumpangDetailService jwtPenumpangDetailService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/registrasi")
    private ResponseEntity<String> saveCustomer(
            @RequestBody PenumpangModel penumpang) {
        penumpang.setPassword(passwordEncoder.encode(penumpang.getPassword()));
        penumpangRepository.save(penumpang);

        return ResponseEntity.status(HttpStatus.CREATED).body("Berhasil dibuat");
    }

    @PostMapping("/login")
    private ResponseEntity<?> login(@RequestBody PenumpangModel penumpangModel) throws Exception {
        authenticate(penumpangModel.getUsername(),penumpangModel.getPassword());

        final UserDetails userDetails = jwtPenumpangDetailService
                .loadUserByUsername(penumpangModel.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            // user disable
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            // invalid credentials
            throw new Exception("INVALID_CREDENTIALS", e);
        }

    }
}
