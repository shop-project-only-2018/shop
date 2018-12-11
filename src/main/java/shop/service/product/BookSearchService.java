package shop.service.product;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.pagination.PageDTO;
import shop.dtos.product.BasicBookDto;
import shop.mappers.product.BookMapper;
import shop.model.product.Book;
import shop.repository.product.BookRepository;
import shop.system.CheckedException;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class BookSearchService {

    private EntityManager entityManager;
    private FullTextEntityManager fullTextEntityManager = null;
    private BookRepository bookRepository;
    private BookMapper mapper;

    @Autowired
    public void setMapper(BookMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void configureFullTextEntityManager() throws InterruptedException {
        // TODO: OPTIMIZE
        fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.createIndexer().startAndWait();
    }

    @Transactional(readOnly = true)
    public PageDTO<BasicBookDto> search(String word) throws CheckedException {
        try {
            configureFullTextEntityManager();
        } catch (InterruptedException e) {
            throw new CheckedException("error.unknown");
        }
        PageDTO<BasicBookDto> page = new PageDTO<>();

        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Book.class).get();
        Query luceneQuery = qb.bool()
                .must(qb.keyword().onFields("name", "description").matching(word).createQuery()).createQuery();
        javax.persistence.Query fullTextQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Book.class);
        List<Book> result = (List<Book>) fullTextQuery.getResultList();
        result.forEach(book -> {
            page.add(mapper.getBasicDto(book));
        });

        page.setPageNumber(1);
        return page;
    }

}
