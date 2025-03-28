package com.example.library.userdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    private final UserDataRepository userDataRepository;

    @Autowired
    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public List<UserData> findAll() {
        return userDataRepository.findAll();
    }

    public Optional<UserData> findById(Long id) {
        return userDataRepository.findById(id);
    }

    public UserData save(UserData userData) {
        return userDataRepository.save(userData);
    }

    public void deleteById(Long id) {
        userDataRepository.deleteById(id);
    }

}
