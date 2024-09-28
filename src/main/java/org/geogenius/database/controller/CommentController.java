package org.geogenius.database.controller;

import org.checkerframework.checker.units.qual.C;
import org.geogenius.database.entities.Comment;
import org.geogenius.database.service.CommentServise;
import org.geogenius.utils.parser.ObjectParser;

public class CommentController {
    private static final CommentServise commentServise = new CommentServise();

    public void addComment(String commentJSON) {
        Comment comment = ObjectParser.parseFromJSON(commentJSON,Comment.class);
        commentServise.addComment(comment);
    }

}
