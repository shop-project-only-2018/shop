package shop.repository.customer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.model.customer.Customer;
import shop.model.customer.Organization;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class OrganizationRepositoryTest {

    @Autowired
    public OrganizationRepository organizationRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Before
    public void setUp() {
        clear();
    }

    @Test
    public void saveSeveralItems() {

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Organization organization1 = new Organization();
        Organization organization2 = new Organization();

        organization1.setCustomer(customer1);
        organization1.setCustomerId(customer1.getCustomerId());
        organization1.setName("One");

        organization2.setCustomer(customer2);
        organization2.setCustomerId(customer2.getCustomerId());
        organization2.setName("Two");

        customer1.setOrganization(organization1);
        customer2.setOrganization(organization2);

        organizationRepository.save(organization1);
        organizationRepository.save(organization2);
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        assert customerRepository.count() == 2;
        assert organizationRepository.count() == 2;

        assert organization1.getCustomerId() == customer1.getCustomerId();
        assert organization2.getCustomerId() == customer2.getCustomerId();
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        organizationRepository.deleteAll();
        customerRepository.deleteAll();
    }
}
