package org.geogenius.database.service;

import lombok.AllArgsConstructor;
import org.geogenius.database.entities.User;
import org.geogenius.database.repository.UserRepository;

@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public void addUser(User user) {
        userRepository.create(user);
    }

    public User getUserById(long id){
        return userRepository.findById(id);
    }

}
