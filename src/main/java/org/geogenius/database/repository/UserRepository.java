package org.geogenius.database.repository;

import org.geogenius.database.entities.User;

import java.util.List;

public class UserRepository extends CrudRepository<User> {
    @Override
    Object create(User user) {
        return executeInTransaction(session -> session.save(user));
    }

    @Override
    User findById(Long id) {
        return null;
    }

    @Override
    List<User> findAll() {
        return List.of();
    }

    @Override
    User update(Long id, User entity) {
        return null;
    }

    @Override
    void delete(Long id) {

    }
}
