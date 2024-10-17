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

//        PlaceImage placeImage = PlaceImage.builder()
//                .imageId(imageID)
//                .place(PlaceService.getPlaceById(placeID))
//                .build();
        PlaceImage placeImage = PlaceImage.builder()
                .place(PlaceService.getPlaceById(placeID))
                .imageId(imageID)
                .build();
        System.err.println(placeImage.toString());

        placeImageRepository.create(placeImage);
    }

//    public static User getUserById(long id){
//        return userRepository.findById(id);
//    }

}
