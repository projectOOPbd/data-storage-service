package org.geogenius.database.service;

import org.geogenius.database.entities.Image;
import org.geogenius.utils.google.GoogleService;
import org.geogenius.utils.parser.ObjectParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class ImageService {

    public static String addImage(String imageJSON) throws IOException {

        Image image = ObjectParser.parseFromJSON(imageJSON,Image.class);
        byte[] imageDecode= Base64.getDecoder().decode(image.getImage());
        Path imagePath = Path.of("src/main/resources" + File.separator + image.getImageName());
        Files.write(imagePath, imageDecode);

        return GoogleService.uploadImageToDrive(imagePath.toFile());
    }
}
