package bookstore.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    void constructor_should_setAllFieldsCorrectly() {
        Client c1 = new Client("Hannah", "Porter","hannahporter@gmail.com");
        assertEquals("Hannah", c1.getFirstName());
        assertEquals("Porter", c1.getLastName());
        assertEquals("hannahporter@gmail.com", c1.getEmailAddress());

        Address a1 = new Address("Abbey Road", 123,"London","London","England","85673");
        Address a2 = new Address("Piccadilly", 12,"London","London","England","83920");
        List<Address> addressList = new ArrayList<Address>();
        addressList.add(a1);
        addressList.add(a2);
        System.out.println("Address List : " + addressList.toString());
        Client c2 = new Client("Hannah", "Porter","hannahporter@gmail.com", addressList);
        assertEquals("Hannah", c2.getFirstName());
        assertEquals("Porter", c2.getLastName());
        assertEquals("hannahporter@gmail.com", c2.getEmailAddress());
        assertEquals(true, c2.getClientAddresses().equals(addressList));
    }
}
