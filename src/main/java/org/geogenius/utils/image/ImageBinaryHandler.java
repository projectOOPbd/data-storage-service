package org.geogenius.utils.image;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ImageBinaryHandler {

    public static byte[] imageToBinary(File imageFile) throws IOException {
        return Files.readAllBytes(imageFile.toPath());
    }

    public static void binaryToImage(byte[] data, File outputFile) throws IOException {
        Files.write(outputFile.toPath(), data);
    }
}
