package org.geogenius.database.service;

import org.geogenius.database.entities.Category;
import org.geogenius.database.repository.CategoryRepository;
import org.geogenius.database.repository.PlaceRepository;
import org.geogenius.utils.parser.ObjectParser;

public class CategoryService {
    private static final CategoryRepository categoryRepository = new CategoryRepository();
    private static final PlaceRepository placeRepository = new PlaceRepository();

    public static void create(Category category) {
        categoryRepository.create(category);
    }

    public static Category getCategoryByID(Long id) {
        return categoryRepository.findById(id);
    }

    public static void delete(Category category) {

         if(placeRepository.countPlaceWithCategory(category.getCategoryId()) != 0){
             System.out.println("Sorry you can`t delete this category");
             return;
         }
         categoryRepository.delete(category.getCategoryId());

    }
    public static void update(Category category) {
        categoryRepository.update(category);
    }
}
