package org.geogenius.database.service;

import org.geogenius.database.entities.Place;
import org.geogenius.database.entities.User;
import org.geogenius.database.repository.PlaceRepository;

public class PlaceService {
    private final PlaceRepository placeRepository = new PlaceRepository();

    public void addPlace(Place place) {
        placeRepository.create(place);
    }

    public Place getUserById(long id){
        return placeRepository.findById(id);
    }
}
