package org.geogenius.database.repository;

import org.geogenius.database.entities.PlaceImage;

import java.util.List;

public class PlaceImageRepository extends CrudRepository<PlaceImage> {
    @Override
    Object create(PlaceImage placeImage) {
        return executeInTransaction(session -> session.save(placeImage));
    }

    @Override
    PlaceImage findById(Long id) {
        return null;
    }

    @Override
    List<PlaceImage> findAll() {
        return List.of();
    }

    @Override
    PlaceImage update(Long id, PlaceImage entity) {
        return null;
    }

    @Override
    void delete(Long id) {

    }
}
