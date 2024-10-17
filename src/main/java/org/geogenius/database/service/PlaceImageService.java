package org.geogenius.database.service;

import org.geogenius.database.entities.Image;
import org.geogenius.database.entities.Place;
import org.geogenius.database.entities.PlaceImage;
import org.geogenius.database.entities.User;
import org.geogenius.database.repository.PlaceImageRepository;
import org.geogenius.database.repository.PlaceRepository;

import java.io.IOException;

public class PlaceImageService {
    private static final PlaceImageRepository placeImageRepository = new PlaceImageRepository();

    public static void addImagePlace(String imageJSON,long placeID) {

        String imageID;
        try {
            imageID = ImageService.addImage(imageJSON);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        PlaceImage placeImage = PlaceImage.builder()
                .place(PlaceService.getPlaceById(placeID))
                .imageId(imageID)
                .build();

        placeImageRepository.create(placeImage);
    }

    public static void deleteAllPlaceImages(Long placeID) {

        placeImageRepository.findPlaceImageIds(placeID).forEach(ImageService::deleteImageById);

        placeImageRepository.deleteAllPlaceImages(placeID);
    }

    public static void main(String[] args) {
        deleteAllPlaceImages(1L);
    }
}
