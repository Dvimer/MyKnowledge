package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class OwnerMControllerTest {
    @Mock
    private OwnerService ownerService;
    @InjectMocks
    private OwnerController ownerController;


    @BeforeEach
    void init() {

    }

    @Test
    void listOwners() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk()
                ).andExpect(view().name("owners/index"));
    }


}