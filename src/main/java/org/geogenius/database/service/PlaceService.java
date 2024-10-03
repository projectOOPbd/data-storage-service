package org.geogenius.database.service;

import org.geogenius.database.entities.Category;
import org.geogenius.database.entities.Comment;
import org.geogenius.database.entities.Place;
import org.geogenius.database.entities.User;
import org.geogenius.database.repository.PlaceRepository;

public class PlaceService {

    private static final PlaceRepository placeRepository = new PlaceRepository();

    public static void addPlace(Place place) {
        Category category = CategoryService.getCategoryByID(place.getCategoryId());
        place.setCategory(category);

        placeRepository.create(place);
    }

    public static Place getPlaceById(long id){
        return placeRepository.findById(id);
    }
}
