package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        String michail = "Michail";
        Owner missha = Owner.builder().telephone("23423234").lastName(michail).firstName("Missha").build();
        when(ownerSDJpaService.findByLastName(anyString())).thenReturn(missha);
        Owner byLastName = ownerSDJpaService.findByLastName(michail);
        assertEquals(michail, byLastName.getLastName());
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }


}