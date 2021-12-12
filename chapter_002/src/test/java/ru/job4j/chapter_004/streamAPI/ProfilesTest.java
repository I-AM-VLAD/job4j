package ru.job4j.chapter_004.streamAPI;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.List;

public class ProfilesTest {
    @Test
    public void whenListOfProfileThenListOfAddress() {
        Address address = new Address("Днепр", "Гагарина", 57, 417);
        List<Profile> profiles = List.of(
                new Profile(address)
        );
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = List.of(
                address
        );
        assertThat(result, is(expected));
    }
}
