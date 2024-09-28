package org.geogenius.database.service;

import lombok.AllArgsConstructor;
import org.geogenius.database.entities.Comment;
import org.geogenius.database.entities.User;
import org.geogenius.database.repository.CommentRepository;

@AllArgsConstructor
public class CommentServise {
    private static final CommentRepository commentRepository = new CommentRepository();


    public void addComment(Comment comment) {
        commentRepository.create(comment);
    }
}
