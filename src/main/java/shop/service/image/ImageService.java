package shop.service.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import shop.model.product.Image;
import shop.repository.product.ImageRepository;
import shop.system.CheckedException;

import javax.validation.constraints.NotNull;
import java.net.MalformedURLException;

@Component
public class ImageService {

    private FileService fileService;
    private ImageRepository imageRepository;

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    private Image retrieve(Integer id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Transactional
    public Integer save(MultipartFile image) throws CheckedException {
        // TODO @NotNull
        if(image == null)
            throw new CheckedException("error.couldNotSave.image");
        if (!image.getContentType().equals(MediaType.IMAGE_JPEG_VALUE)) {
            throw new CheckedException("error.couldNotSave.image.isNotJpeg");
        } else {
            Image imageEntity = new Image();
            imageRepository.saveAndFlush(imageEntity);
            fileService.saveImage(imageEntity.getId(), image);
            return imageEntity.getId();
        }
    }

    @Transactional(readOnly = true)
    public Resource get(@NotNull Integer id) throws CheckedException, MalformedURLException {
        Resource resource = new UrlResource((fileService.getImagePath(id)).toUri());
        if (resource.exists()) {
            return resource;
        } else {
            throw new CheckedException("error.notFound");
        }
    }
}
