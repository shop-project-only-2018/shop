package shop.model.product;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import shop.model.EntityWithIntegerId;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Indexed
public class Book implements EntityWithIntegerId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column
    @Field
    private String name;

    @Column
    @Field
    private String description;

    @Column
    private BigDecimal price;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "cover_id")
    private Image cover;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book() {
    }

    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public Integer getId() {
        return bookId;
    }

    @Override
    public void setId(Integer id) {
        this.bookId = id;
    }
}
