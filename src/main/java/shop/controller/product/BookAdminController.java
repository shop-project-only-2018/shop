package shop.controller.product;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookAdminController {
    @GetMapping(value = {"/books/add"})
    public String index(Model model) {
        model.addAttribute("title", "addBook.title");
        return "admin/addBookForm";
    }
}
