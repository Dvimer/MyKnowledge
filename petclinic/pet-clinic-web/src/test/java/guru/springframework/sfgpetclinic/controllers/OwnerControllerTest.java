package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class OwnerControllerTest {
    @Mock
    private OwnerService ownerService;
    private OwnerController ownerController;
@Autowired
    private PetTypeRepository petTypeRepository;


    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(ownerService);
    }

    @Test
    void listOwners() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk()
                ).andExpect(view().name("owners/index"));
    }

    @Test
    void petTypeRepositoriesTest() {
        PetType dog = petTypeRepository.findByName("Dog");
        assertNotNull(dog);
    }

    @Test
    void testListOwners() {
    }
}