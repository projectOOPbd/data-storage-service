package org.geogenius.database.repository;

import lombok.AllArgsConstructor;
import org.geogenius.database.entities.User;

import java.util.List;

@AllArgsConstructor
public class UserRepository extends CrudRepository<User> {

    @Override
    public Object create(User user) {
        return executeInTransaction(session -> session.save(user));
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User update(Long id, User entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
