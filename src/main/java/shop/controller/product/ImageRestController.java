package shop.controller.product;


import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.dtos.customer.CreateUpdateCustomerDto;
import shop.dtos.product.BookDto;
import shop.service.image.ImageService;
import shop.service.product.BookService;
import shop.service.product.CategoryService;

import java.util.List;

@RestController
@RequestMapping("api/images")
public class ImageRestController {

    private ImageService imageService;

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(value = "")
    public Integer saveImage(@RequestBody MultipartFile data)
            throws Exception {
        return imageService.save(data);
    }

    @GetMapping("/{id}")
    public Resource get(@PathVariable Integer id)            throws  Exception {
        return imageService.get(id);
    }
}
