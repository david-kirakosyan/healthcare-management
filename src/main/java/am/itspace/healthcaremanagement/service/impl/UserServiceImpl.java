package am.itspace.healthcaremanagement.service.impl;

import am.itspace.healthcaremanagement.entity.User;
import am.itspace.healthcaremanagement.entity.type.UserType;
import am.itspace.healthcaremanagement.repository.UserRepository;
import am.itspace.healthcaremanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void userRegister(User user){
        Optional<User> userFromDB = userRepository.findByEmail(user.getEmail());
        if (userFromDB.isEmpty()) {
            String password = user.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            userRepository.save(user);
        }
    }
}
