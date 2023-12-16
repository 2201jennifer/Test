package io.javabrains.springsecurityjpa;

import io.javabrains.springsecurityjpa.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        // Create a User instance
        User user = new User();
        user.setUserName("testUser");
        user.setPassword("testPassword");
        user.setActive(true);
        user.setRoles("ROLE_USER");

        // Save the User to the database
        User savedUser = userRepository.save(user);

        // Retrieve the User from the database
        User existUser = userRepository.findById(savedUser.getId()).orElse(null);

        // Assertions
        assertThat(existUser).isNotNull();
        assertThat(existUser.getUserName()).isEqualTo("testUser");
        assertThat(existUser.getPassword()).isEqualTo("testPassword");
        assertThat(existUser.isActive()).isTrue();
    }
}
