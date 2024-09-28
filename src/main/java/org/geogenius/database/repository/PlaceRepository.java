package org.geogenius.database.repository;

import org.geogenius.database.entities.Place;

import java.util.List;

public class PlaceRepository extends CrudRepository<Place> {
    @Override
    Object create(Place entity) {
        return null;
    }

    @Override
    Place findById(Long id) {
        return null;
    }

    @Override
    List<Place> findAll() {
        return List.of();
    }

    @Override
    Place update(Long id, Place entity) {
        return null;
    }

    @Override
    void delete(Long id) {

    }
}
