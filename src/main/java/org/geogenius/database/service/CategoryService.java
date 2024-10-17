package org.geogenius.database.service;

import org.geogenius.database.entities.Category;
import org.geogenius.database.repository.CategoryRepository;
import org.geogenius.database.repository.PlaceRepository;
import org.geogenius.utils.parser.ObjectParser;

public class CategoryService {
    private static final CategoryRepository categoryRepository = new CategoryRepository();

    public static void addCategory(Category category) {
        categoryRepository.create(category);
    }

    public static Category getCategoryByID(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public static void deleteCategory(Long categoryId) {
         if(PlaceService.countPlaceWithCategory(categoryId) != 0){
             System.out.println("Sorry you can`t delete this category");
             return;
         }
         categoryRepository.delete(categoryId);

    }

    public static void updateCategory(Category category) {
        categoryRepository.update(category);
    }
}
