package org.geogenius.database.repository;

import org.geogenius.database.entities.Comment;

import java.util.List;

public class CommentRepository extends CrudRepository<Comment> {
    @Override
    public Object create(Comment comment) {
        return executeInTransaction(session -> session.save(comment));
    }

    @Override
    public Comment findById(Long id) {
        return executeInTransaction(session -> session.get(Comment.class, id));
    }

    @Override
    public List<Comment> findAll() {
        return executeInTransaction(session -> session.createQuery("from Comment").list());
    }

    @Override
    public Comment update(Comment entity) {

        return executeInTransaction(session -> session.merge(entity));
    }

    @Override
    public void delete(Long id) {
        executeInTransaction(session -> session.createQuery("delete from Comment where id = :id")
                .setParameter("id", id)
                .executeUpdate());
    }
}
