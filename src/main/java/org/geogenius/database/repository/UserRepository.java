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
        return executeInTransaction(session -> session.get(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return executeInTransaction(session -> session.createQuery("from User").list());
    }

    @Override
    public User update(User entity) {
        return executeInTransaction(session -> session.merge(entity));
    }

    @Override
    public void delete(Long id) {
        executeInTransaction(session -> session.createQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate());
    }
}
