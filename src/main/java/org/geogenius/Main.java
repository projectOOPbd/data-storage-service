package org.geogenius;

import org.geogenius.database.controller.CommentController;
import org.geogenius.database.controller.UserControler;
import org.geogenius.database.entities.Category;
import org.geogenius.database.entities.Comment;
import org.geogenius.database.entities.Image;
import org.geogenius.database.entities.Place;
import org.geogenius.database.repository.CommentRepository;
import org.geogenius.database.repository.PlaceRepository;
import org.geogenius.database.service.CategoryService;
import org.geogenius.database.service.CommentServise;
import org.geogenius.database.service.ImageService;
import org.geogenius.database.service.PlaceService;
import org.geogenius.utils.hibernate.SessionManager;
import org.geogenius.utils.parser.ObjectParser;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws IOException {
//        testUser();
//        Path inputJImageJSONPath = Path.of("src/main/resources/image.json");
//        String inputImageJSON = Files.readString(inputJImageJSONPath);
//
//        Path inputUserJSONPath = Path.of("src/main/resources/Oleksandr.json");
//        String inputUserJSON = Files.readString(inputUserJSONPath);
//
//        UserControler.addUser(inputUserJSON, inputImageJSON);

//        String commentJSON = Files.readString(Path.of("src/main/resources/Comment.json"));
//        Comment comment = ObjectParser.parseFromJSON(commentJSON,Comment.class);
//        System.out.println(comment.toString());
//        testComment();
        testPlace();

//        testCategory();
    }

    public static void testCategory() throws IOException {
        Path inputCategoryJSONPath = Path.of("src/main/resources/Category.json");
        String inputCommentJSON = Files.readString(inputCategoryJSONPath);

        Category category = ObjectParser.parseFromJSON(inputCommentJSON, Category.class);

        CategoryService categoryService = new CategoryService();
        categoryService.create(category);
    }

    public static void testPlace() throws IOException {
        Path inputPlaceJSONPath = Path.of("src/main/resources/Place.json");
        String inputPlaceJSON = Files.readString(inputPlaceJSONPath);

        Place place = ObjectParser.parseFromJSON(inputPlaceJSON, Place.class);
        Category category = CategoryService.getCategoryByID(place.getCategoryId());

        place.setCategory(category);

        PlaceRepository placeRepository  = new PlaceRepository();
        placeRepository.create(place);

    }
    public static void testComment() throws IOException {
        Path inputCommentJSONPath = Path.of("src/main/resources/Comment.json");
        String inputCommentJSON = Files.readString(inputCommentJSONPath);

        // Парсинг JSON
        Comment comment = ObjectParser.parseFromJSON(inputCommentJSON, Comment.class);
        System.out.println(comment.toString());

        CommentServise.addComment(comment);
    }


    public static void testUser() throws IOException {
        Path inputJImageJSONPath = Path.of("src/main/resources/image.json");
        String inputImageJSON = Files.readString(inputJImageJSONPath);
        Path inputUserJSONPath = Path.of("src/main/resources/Oleksandr.json");
        String inputUserJSON = Files.readString(inputUserJSONPath);

        UserControler.addUser(inputUserJSON, inputImageJSON);
    }

}
