package org.geogenius.database.repository;

import org.geogenius.database.entities.Comment;

import java.util.List;

public class CommentRepository extends CrudRepository<Comment> {
    @Override
    Object create(Comment comment) {
        return executeInTransaction(session -> session.save(comment));
    }

    @Override
    Comment findById(Long id) {
        return null;
    }

    @Override
    List<Comment> findAll() {
        return List.of();
    }

    @Override
    Comment update(Long id, Comment entity) {
        return null;
    }

    @Override
    void delete(Long id) {

    }
}
