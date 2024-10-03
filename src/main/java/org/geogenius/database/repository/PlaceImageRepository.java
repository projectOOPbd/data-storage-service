package org.geogenius.database.repository;

import org.geogenius.database.entities.PlaceImage;

import java.util.List;

public class PlaceImageRepository extends CrudRepository<PlaceImage> {
    @Override
    public Object create(PlaceImage placeImage) {
        return executeInTransaction(session -> session.save(placeImage));
    }

    @Override
    public PlaceImage findById(Long id) {
        return executeInTransaction(session -> session.get(PlaceImage.class, id));
    }

    @Override
    public List<PlaceImage> findAll() {
        return List.of();
    }

    @Override
    public PlaceImage update(Long id, PlaceImage entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
