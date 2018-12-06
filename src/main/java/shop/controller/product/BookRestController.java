package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dtos.message.Message;
import shop.dtos.product.AddingBookDto;
import shop.dtos.product.BasicBookDto;
import shop.dtos.product.FullBookDto;
import shop.service.product.BookService;
import shop.service.security.RolesService;
import shop.system.CheckedException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BookRestController {

    private BookService bookService;
    private RolesService rolesService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setRolesService(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    /**
     * Retrieve one book
     *
     * @param id
     * @return book
     * @throws CheckedException if not found
     */
    @GetMapping("/{id}")
    public FullBookDto getById(@PathVariable Integer id) throws CheckedException {
        return bookService.getDtoById(id);
    }

    /**
     * Retrieve all books
     *
     * @return list of books
     */
    @GetMapping(value = {"api/books/bestsellers"})
    public List<BasicBookDto> getAll() {
        List<BasicBookDto> list = bookService.getAll();
        return list;
    }

    /**
     * Add a new book
     *
     * @param request       for authorization
     * @param addingBookDto - data
     * @return message with bookId
     * @throws CheckedException if an error occurs
     */
    @PostMapping(value = "admin/books/add")
    public Message addBook(HttpServletRequest request,
                           @Valid @RequestBody AddingBookDto addingBookDto) throws CheckedException {
        rolesService.mustHaveRole(request, "ADMIN");
        return new Message(bookService.addBook(addingBookDto));
    }
}
