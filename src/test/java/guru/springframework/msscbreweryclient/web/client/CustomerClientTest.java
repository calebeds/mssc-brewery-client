package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;
    @Test
    void getCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder()
                .name("New Beer")
                .build();

        URI uri = client.saveNewCustomer(customerDto);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        //given
        CustomerDto beerDto = CustomerDto.builder()
                .name("New Beer")
                .build();

        client.updateCustomer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}