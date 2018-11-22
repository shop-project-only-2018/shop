package shop.service.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import shop.service.message.Messages;

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

    private Messages messages;

    @Autowired
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    @PostConstruct
    public void configureFileStorageLocation() {
        this.fileStorageLocation = Paths.get(directory).toAbsolutePath().normalize();
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

    public void saveImage(Integer id, MultipartFile image) throws Exception {
        try {
            Files.copy(image.getInputStream(),
                    this.fileStorageLocation.resolve(getFilename(id)), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new Exception(messages.get("reksoft.demo.Picture.couldNotStore.message"));
        }
    }

    public Path getImagePath(Integer id){
        return this.fileStorageLocation.resolve(getFilename(id));
    }
}
