package shop.mappers.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.dtos.product.CategoryDto;
import shop.model.product.Category;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class CategoryMapperTest {

    private CategoryMapper mapper;

    @Autowired
    public void setMapper(CategoryMapper mapper) {
        this.mapper = mapper;
    }


    @Test
    public void testParentId() {
        Category child = new Category("Abc abc");
        child.setId(321);

        Category parent = new Category("Parent");
        parent.setId(123);

        child.setParent(parent);

        CategoryDto dto = mapper.getDto(child);
        assert dto.getParentCategoryId().equals(123);


        Category orphan = new Category("Abc abc");
        dto = mapper.getDto(orphan);
        assert dto.getParentCategoryId() == null;
    }

    @Test
    public void merge() {
        String abc = "Abc abc";
        Category recipient = new Category("");
        Category source = new Category(abc);
        recipient = mapper.merge(recipient, source);
        assert recipient.getName().equals(abc);
    }
}