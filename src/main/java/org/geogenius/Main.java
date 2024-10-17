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
//        testCategory();
//        testPlace();
//        testImagePlace();
        testComment();
//        testUser();
    }

    public static void testPlaceImageRepositoryDeleteByPlaceId(){

    }
    public static void testDeleteCategory() {
        Category category = CategoryService.getCategoryByID(1L);
        CategoryService.deleteCategory(category.getCategoryId());
    }
    public static void testUpdateCategory() throws IOException {
        Category category = CategoryService.getCategoryByID(1L);
        System.out.println(category.toString());
        category.setName("хуй");
        CategoryService.updateCategory(category);
    }
    public static void countPlaceWithCategory(){
        PlaceRepository placeRepository = new PlaceRepository();
        System.out.println(placeRepository.countPlaceWithCategory(2L));
    }
    public static void testCategory() throws IOException {
        Path inputCategoryJSONPath = Path.of("src/main/resources/Category.json");
        String inputCommentJSON = Files.readString(inputCategoryJSONPath);

        Category category = ObjectParser.parseFromJSON(inputCommentJSON, Category.class);
        CategoryService categoryService = new CategoryService();
        System.out.println(category.toString());
        categoryService.addCategory(category);
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

        PlaceImageService.addImagePlace(inputImageJSON, placeImage.getPlaceId());

    }
}
