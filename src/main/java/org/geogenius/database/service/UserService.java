package org.geogenius.database.service;

import lombok.AllArgsConstructor;
import org.geogenius.database.entities.User;
import org.geogenius.database.repository.UserRepository;

@AllArgsConstructor
public class UserService {
    private static final UserRepository userRepository = new UserRepository();
    public static void addUser(User user) {
        userRepository.create(user);
    }

    public static User getUserById(long id){
        return userRepository.findById(id);
    }

}
