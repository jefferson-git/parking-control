package br.com.api.parkingcontrol.config.security;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.com.api.parkingcontrol.repository.UserRepository;
import br.com.api.parkingcontrol.service.exception.ObjectNotFoundException;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username){
        var userModel = repository.findByUsername(username).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado com nome: " + username));
        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true,true, userModel.getAuthorities());
    }
}