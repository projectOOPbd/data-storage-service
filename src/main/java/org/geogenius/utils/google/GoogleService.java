package org.geogenius.utils.google;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import org.geogenius.utils.PropertiesUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class GoogleService {

    static {
        PropertiesUtil.setPropertiesFile("google-service.properties");
    }

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    private static final String SERVICE_ACCOUNT_KEY_PATH = PropertiesUtil.getProperty("service.account.key.path");

    private static final String DESTINATION_PATH = PropertiesUtil.getProperty("service.account.destination.path");

    private static final String FOLDER_ID = PropertiesUtil.getProperty("service.account.folder.id");

    private static final Drive drive = createDriveService();

    public static void uploadImageToDrive(java.io.File imageFile) throws IOException {

        // Створення метаданих для файлу
        File fileMetadata = new File();
        fileMetadata.setName(imageFile.getName());
        fileMetadata.setParents(Collections.singletonList(FOLDER_ID));

        // Створення вмісту файлу
        FileContent mediaContent = new FileContent("image/jpeg", imageFile);

        // Завантаження файлу на Google Диск
        File uploadedFile = drive.files().create(fileMetadata, mediaContent).setFields("id,parents").execute();

        System.out.println("Файл завантажено. ID: " + uploadedFile.getId());
    }


    public static void downloadImageToDrive(String imageID) throws IOException {
        if (imageID == null || imageID.isEmpty()) {
            System.out.println("Неправильний ID файлу: " + imageID);
            return;
        }
        File file = drive.files().get(imageID).execute();

        OutputStream outputStream = new FileOutputStream(DESTINATION_PATH + "/" + file.getName());

        drive.files().get(imageID).executeMediaAndDownloadTo(outputStream);
    }

    public static void deleteImageFromDrive(String imageID) throws IOException {
        if (imageID == null || imageID.isEmpty()) {
            System.out.println("Неправильний ID файлу: " + imageID);
            return;
        }

        drive.files().delete(imageID).execute();
        System.out.println("Файл з ID " + imageID + " успішно видалено.");
    }

    private static Drive createDriveService() {
        try {
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(SERVICE_ACCOUNT_KEY_PATH)).createScoped(Collections.singleton(DriveScopes.DRIVE));

            return new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, new HttpCredentialsAdapter(credentials)).setApplicationName("data-storage-service").build();
        } catch (IOException | GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }


}
