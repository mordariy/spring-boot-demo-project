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
                    new User(0, "Ivan", "Ivanov", "123456"),
                    new User(1, "Sergey", "Sergeev", "987654"),
                    new User(2, "Dmitry", "Dmitriev", "456123")
            )
    );

    public List<User> getUsers() {
        return userList;
    }

    public User getUserById(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    /*
    "2. Переписать создание пользователя таким образом, чтобы ID всегда был ID последнего + 1"
    Здесь ведь уже такая логика была прописана, разве нет? Я только чуть-чуть поправил, чтобы можно было создать
    кого-нибудь и в пустом списке
     */
    public User createUser(User newUser) {
        User lastUser = userList.isEmpty() ? null : userList.get(userList.size() - 1); //достаётся последний пользователь
        newUser.setId((lastUser == null) ? 0 : lastUser.getId() + 1); //новосозданному присваивается ID последнего+1
        userList.add(newUser); //пользователь создан и помещён в список
        return newUser;
    }

    public User updateUserById(int id, User user) {
        user.setId(id);
        userList.remove(id);
        userList.add(id, user);
        return user;
    }

    public User deleteUserById(int id) {
        User deletedUser = userList.get(id);
        userList.remove(id);

        //*3
        User lastUser = userList.isEmpty() ? null : userList.get(userList.size() - 1);
        lastUser.setId(id);
        userList.add(id, lastUser);
        userList.remove(userList.size() - 1);

        return deletedUser;
    }
}
