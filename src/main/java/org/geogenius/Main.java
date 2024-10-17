package org.geogenius;

import org.checkerframework.checker.units.qual.C;
import org.geogenius.database.controller.UserControler;
import org.geogenius.database.entities.*;
import org.geogenius.database.repository.CategoryRepository;
import org.geogenius.database.repository.PlaceRepository;
import org.geogenius.database.service.*;
import org.geogenius.utils.hibernate.SessionManager;
import org.geogenius.utils.parser.ObjectParser;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        CategoryRepository categoryRepository = new CategoryRepository();
        categoryRepository.delete(18L);
    }

    public static void testCategory() throws IOException {
        Path inputCategoryJSONPath = Path.of("src/main/resources/Category.json");
        String inputCommentJSON = Files.readString(inputCategoryJSONPath);

        Category category = ObjectParser.parseFromJSON(inputCommentJSON, Category.class);
        CategoryService categoryService = new CategoryService();
        System.out.println(category.toString());
        categoryService.create(category);
        //Session session = SessionManager.getSession();
//        Category category1 = session.createQuery("from Category ",Category.class).list().get(0);
//        System.out.println(category1);
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

    public static void testImagePlace() throws IOException {
        String inputImageJSON = Files.readString(Path.of("src/main/resources/image.json"));

        String inputImagePlaceJSON = Files.readString(Path.of("src/main/resources/ImagePlace.json"));
        PlaceImage placeImage = ObjectParser.parseFromJSON(inputImagePlaceJSON, PlaceImage.class);
        System.out.println();

        PlaceImageService.addImagePlace(inputImageJSON,placeImage.getPlaceId());

    }
}
