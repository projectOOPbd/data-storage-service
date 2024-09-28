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
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return List.of();
    }

    @Override
    public Comment update(Long id, Comment entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
