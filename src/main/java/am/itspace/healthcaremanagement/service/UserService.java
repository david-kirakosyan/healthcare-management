package am.itspace.healthcaremanagement.service;

import am.itspace.healthcaremanagement.entity.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    void userSave(User user);

    void deleteUserById(int id);
}
