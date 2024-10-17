package org.geogenius.database.service;

import lombok.AllArgsConstructor;
import org.geogenius.database.entities.Comment;
import org.geogenius.database.entities.Place;
import org.geogenius.database.entities.User;
import org.geogenius.database.repository.CommentRepository;

@AllArgsConstructor
public class CommentServise {
    private static final CommentRepository commentRepository = new CommentRepository();

    public static void addComment(Comment comment) {
        User user = UserService.getUserById(comment.getUserId());
        Place place = PlaceService.getPlaceById(comment.getPlaceId());

        comment.setUser(user);
        comment.setPlace(place);

        commentRepository.create(comment);

    }

}
