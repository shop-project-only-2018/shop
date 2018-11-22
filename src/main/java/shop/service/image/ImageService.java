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
import shop.service.message.Messages;

import javax.validation.constraints.NotNull;

@Component
public class ImageService {

    private FileService fileService;
    private Messages messages;
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    private Image retrieve(Integer id) {
        return imageRepository.findById(id).orElse(null);
    }
    @Transactional
    public Integer save(@NotNull MultipartFile image) throws Exception {
        if (!image.getContentType().equals(MediaType.IMAGE_JPEG_VALUE)) {
            throw new Exception(messages.get("error.couldNotSave.image.isNotJpeg"));
        } else {
            Image imageEntity = new Image();
            imageRepository.saveAndFlush(imageEntity);
            fileService.saveImage(imageEntity.getId(), image);
            return imageEntity.getId();
        }
    }

    @Transactional(readOnly = true)
    public Resource get(@NotNull Integer id) throws Exception {
        Resource resource = new UrlResource((fileService.getImagePath(id)).toUri());
        if (resource.exists()) {
            return resource;
        } else {
            throw new Exception(messages.get("error.notFound"));
        }}}
