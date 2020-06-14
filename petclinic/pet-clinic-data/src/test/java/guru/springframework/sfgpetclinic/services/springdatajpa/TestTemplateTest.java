package guru.springframework.sfgpetclinic.services.springdatajpa;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(LoggingExtension.class)
class TestTemplateTest {
    private Logger logger;
    final List<String> fruits = Arrays.asList("apple", "banana", "lemon");

    @TestTemplate
    @ExtendWith(MyTestTemplateInvocationContextProvider.class)
    void testTemplate(String fruit) {
        assertTrue(fruits.contains(fruit));
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}