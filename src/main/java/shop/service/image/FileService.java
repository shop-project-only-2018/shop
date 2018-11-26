package shop.service.image;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import shop.system.CheckedException;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileService {

    @Value("${files.pattern}")
    private String pattern;

    @Value("${files.directory}")
    private String directory;

    private Path fileStorageLocation;

    @PostConstruct
    public void configureFileStorageLocation() {
        this.fileStorageLocation = Paths.get(directory).normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String getFilename(Integer identifier) {
        return String.format(pattern, identifier);
    }

    public void saveImage(Integer id, MultipartFile image) throws CheckedException {
        try {
            Files.copy(image.getInputStream(),
                    this.fileStorageLocation.resolve(getFilename(id)), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new CheckedException("error.couldNotSave.image");
        }
    }

    public Path getImagePath(Integer id) {
        return this.fileStorageLocation.resolve(getFilename(id));
    }
}
