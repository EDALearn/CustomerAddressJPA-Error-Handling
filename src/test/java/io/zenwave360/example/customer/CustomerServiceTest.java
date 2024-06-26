package io.zenwave360.example.customer;

import io.zenwave360.example.customer.config.ServicesInMemoryConfig;
import io.zenwave360.example.customer.inmemory.CustomerRepositoryInMemory;
import io.zenwave360.example.customer.model.Address;
import io.zenwave360.example.customer.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Acceptance Test for CustomerService.
 */
public class CustomerServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ServicesInMemoryConfig context = new ServicesInMemoryConfig();

    CustomerServiceImpl customerService = context.customerService();

    CustomerRepositoryInMemory customerRepository = context.customerRepository();

    @BeforeEach
    void setUp() {
        context.reloadTestData();
    }

    @Test
    void createCustomerTest() {
        var input = new Customer();
        input.setUsername("");
        input.setEmail("");
        input.setAddress(new Address().setCity("One").setStreet("13, Rue del Percebe"));

        var customer = customerService.createCustomer(input);
        assertNotNull(customer.getId());
        assertTrue(customerRepository.containsEntity(customer));
    }

    @Test
    void updateCustomerTest() {
        var id = 1L; // TODO fill id

        var input = new Customer();
        input.setUsername("");
        input.setEmail("");
        input.setAddress(new Address().setCity("One").setStreet("13, Rue del Percebe"));

        assertTrue(customerRepository.containsKey(id));
        var customer = customerService.updateCustomer(id, input);
        assertTrue(customer.isPresent());
        assertTrue(customerRepository.containsEntity(customer.get()));
    }

    @Test
    void updateCustomerAddressTest() { // TODO: implement this test
    }

    @Test
    void deleteCustomerTest() {
        var id = 1L; // TODO fill id
        assertTrue(customerRepository.containsKey(id));
        customerService.deleteCustomer(id);
        assertFalse(customerRepository.containsKey(id));
    }

    @Test
    void getCustomerTest() {
        var id = 1L; // TODO fill id
        var customer = customerService.getCustomer(id);
        assertTrue(customer.isPresent());
    }

    @Test
    void listCustomersTest() {
        // var results = customerService.listCustomers(PageRequest.of(0, 10));
        // assertNotNull(results);
    }

}
