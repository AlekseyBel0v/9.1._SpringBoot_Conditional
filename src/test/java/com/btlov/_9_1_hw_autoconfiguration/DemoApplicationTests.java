package com.btlov._9_1_hw_autoconfiguration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

//@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    private static final GenericContainer<?> devAppContainer = new GenericContainer<>("devapp:latest")
            .withExposedPorts(8080);

    private static final GenericContainer<?> prodAppContainer = new GenericContainer<>("prodapp:latest")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        devAppContainer.start();
        prodAppContainer.start();
    }

    @Test
    void testGetDevProfile(){
        final String atualResponseBody = "Current profile is dev";

        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devAppContainer.getMappedPort(8080) + "/profile", String.class);

        Assertions.assertEquals(forEntity.getBody(), atualResponseBody);
    }

    @Test
    void testGetProdProfile(){
        final String atualResponseBody = "Current profile is production";

        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + prodAppContainer.getMappedPort(8081) + "/profile", String.class);

        Assertions.assertEquals(forEntity.getBody(), atualResponseBody);
    }

}