package org.geogenius.database.controller;

import org.geogenius.database.entities.User;
import org.geogenius.database.service.ImageService;
import org.geogenius.database.service.UserService;
import org.geogenius.utils.parser.ObjectParser;

import java.io.IOException;

public class UserControler {
    private static final UserService userService = new UserService();

        public static void addUser(String userJSON,String imageJSON) throws IOException {

            String imageId = ImageService.addImage(imageJSON);
            User user = ObjectParser.parseFromJSON(userJSON,User.class);
            user.setImageId(imageId);

            userService.addUser(user);
        }
}
