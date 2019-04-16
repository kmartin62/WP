package com.example.demo.service.serviceimpl;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserAccountRepository userAccountRepository;

    public UserServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return (List<UserAccount>) userAccountRepository.findAll();
    }
}
