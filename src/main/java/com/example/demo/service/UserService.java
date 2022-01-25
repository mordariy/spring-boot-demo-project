package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final List<User> userList = new ArrayList<>(
            Arrays.asList(
                    new User(1, "Ivan", "Ivanov", "123456"),
                    new User(2, "Sergey", "Sergeev", "987654"),
                    new User(3, "Dmitry", "Dmitriev", "456123")
            )
    );

    public List<User> getUsers() {
        return userList;
    }

    public User getUserById(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public User createUer(User newUser) {
        User lastUser = userList.isEmpty() ? null : userList.get(userList.size() - 1);
        newUser.setId(lastUser.getId() + 1);
        userList.add(newUser);
        return newUser;
    }
}
