package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;


    @Override
    public void run(String... args) {

        petTypeService.save(PetType.builder().name("Dog").build());
        petTypeService.save(PetType.builder().name("Cat").build());
        petTypeService.save(PetType.builder().name("Hamster").build());

        ownerService.save(Owner.builder().address("Moskow").city("Moo").telephone("423432").build());
        ownerService.save(Owner.builder().address("Prof street").city("Moo").telephone("423432").build());
        ownerService.save(Owner.builder().address("but stret").city("Moo").telephone("423432").build());
        ownerService.save(Owner.builder().address("der").city("Moo").telephone("423432").build());
        ownerService.save(Owner.builder().address("vvcx").city("Moo").telephone("423432").build());
        ownerService.save(Owner.builder().address("Military").city("Moo").telephone("423432").build());
        ownerService.findAll().forEach(p -> System.out.println(p.getAddress()));
        Vet vet = new Vet();
        vet.setFirstName("First");
        vet.setLastName("Last");
        vetService.save(vet);
    }
}
