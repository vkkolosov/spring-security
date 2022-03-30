package com.hblack.controller;

import com.hblack.securityconfig.AuthModelDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

@RestController
public class AuthController {

    @Autowired
    private UserDetailsService authModelDetailServiceImpl;

    @GetMapping("/hello")
    public ResponseEntity hello() {

        return ResponseEntity.ok("Hello, test-auth");
    }

    @GetMapping("/helloagain")
    public ResponseEntity helloagain() {
        System.out.println(((AuthModelDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        return ResponseEntity.ok("Hello!!!");
    }

    @GetMapping("/login") //ТО ЧТО НУЖНО!!!
    public ResponseEntity login(@RequestParam String data) {

        String userName = checkUserAuth(data);
        if(userName == null){
            return ResponseEntity.badRequest().body("---");
        } else {
            String username = data;
            Authentication authentication = new UsernamePasswordAuthenticationToken(authModelDetailServiceImpl.loadUserByUsername(username), "", authModelDetailServiceImpl.loadUserByUsername(username).getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("GET запрос прошел");
            return ResponseEntity.ok("Авторизован");
        }

        //return new ModelAndView ("redirect:/helloagain");
    }

    public static String checkUserAuth(String data){
        return data;
    }

    @PostMapping("/login2")
    public ResponseEntity postlogin(@RequestParam String username, @RequestParam String password) throws ServletException {
        Authentication authentication = new UsernamePasswordAuthenticationToken(authModelDetailServiceImpl.loadUserByUsername(username), "", authModelDetailServiceImpl.loadUserByUsername(username).getAuthorities());
        System.out.println("POST запрос прошел");
        return ResponseEntity.ok("POST");
    }

}
