package shop.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.pagination.PageDTO;
import shop.dtos.product.AddingBookDto;
import shop.dtos.product.BasicBookDto;
import shop.dtos.product.FullBookDto;
import shop.mappers.product.BookMapper;
import shop.model.product.Author;
import shop.model.product.Book;
import shop.model.product.Image;
import shop.repository.product.AuthorRepository;
import shop.repository.product.BookRepository;
import shop.repository.product.CategoryRepository;
import shop.repository.product.ImageRepository;
import shop.system.CheckedException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static final int BOOK_PAGE_SIZE = 6;

    private ImageRepository imageRepository;
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
    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
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

        List<BasicBookDto> dtoList = new ArrayList<>();
        bookRepository.findAll().forEach(book -> {
            BasicBookDto dto = mapper.getBasicDto(book);
            dtoList.add(dto);
        });
        return dtoList;
    }

    @Transactional(readOnly = true)
    public PageDTO<BasicBookDto> getPage(Integer pageNumber) {
        if(pageNumber < 1) pageNumber = 1;

        PageDTO<BasicBookDto> page = new PageDTO<>();
        bookRepository.findAll(PageRequest.of(pageNumber - 1, BOOK_PAGE_SIZE)).forEach(book -> {
            page.add(mapper.getBasicDto(book));
        });
        long count = bookRepository.count();
        long additional = (count % BOOK_PAGE_SIZE == 0) ? 0 : 1;
        page.setNumberOfPages(count / BOOK_PAGE_SIZE + additional);
        page.setPageNumber(pageNumber);

        return page;
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
        // TODO: Find existing authors
        Author author = new Author(addingBookDto.getAuthorFN(), addingBookDto.getAuthorLN());
        if(addingBookDto.getCoverId() != null) {
            Image image = imageRepository.getOne(addingBookDto.getCoverId());
            book.setCover(image);
        }
        authorRepository.saveAndFlush(author);
        book.setAuthor(author);
        bookRepository.save(book);
        return book.getBookId();
    }
}
