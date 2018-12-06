package shop.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.product.AddingBookDto;
import shop.dtos.product.BasicBookDto;
import shop.dtos.product.FullBookDto;
import shop.mappers.product.BookMapper;
import shop.model.product.Author;
import shop.model.product.Book;
import shop.repository.product.AuthorRepository;
import shop.repository.product.BookRepository;
import shop.repository.product.CategoryRepository;
import shop.service.security.SecurityService;
import shop.system.CheckedException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private CategoryRepository categoryRepository;
    private BookRepository bookRepository;
    private BookMapper mapper;
    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Autowired
    public void setMapper(BookMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public boolean exists(Integer id) {
        Book product = bookRepository.findById(id).orElse(null);
        return product != null;
    }

    public Book getById(Integer id) throws CheckedException {
        Book product = bookRepository.findById(id).orElse(null);
        if (product == null) {
            throw new CheckedException("error.notFound.book");
        }
        return product;
    }

    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<BasicBookDto> getAll() {

        // TODO: IMPLEMENT PAGES
        List<BasicBookDto> dtoList = new ArrayList<>();
        bookRepository.findAll().forEach(book -> {
            BasicBookDto dto = mapper.getBasicDto(book);
            dtoList.add(dto);
        });

        return dtoList;
    }

    @Transactional(readOnly = true)
    public FullBookDto getDtoById(Integer id) throws CheckedException {
        Book book = getById(id);
        FullBookDto dto = mapper.getFullDto(book);
        return dto;
    }

    @Transactional
    @Modifying
    public Integer addBook(AddingBookDto addingBookDto) throws CheckedException {
        Book book = mapper.getEntity(addingBookDto);
        // TODO: Find existing writers
        Author author = new Author(addingBookDto.getAuthorFN(), addingBookDto.getAuthorLN());
        authorRepository.saveAndFlush(author);
        book.setAuthor(author);
        bookRepository.save(book);
        return book.getBookId();
    }
}
