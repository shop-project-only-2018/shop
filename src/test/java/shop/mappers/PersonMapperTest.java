package shop.mappers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.dtos.customer.PersonDto;
import shop.model.customer.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class PersonMapperTest {
    @Test
    public void personDtoToPerson() {
        PersonDto personDto = new PersonDto("Abc", "Def");
        Person person = PersonMapper.INSTANCE.getEntity(personDto);
        assert person.getFirstName().equals("Abc");
    }
}