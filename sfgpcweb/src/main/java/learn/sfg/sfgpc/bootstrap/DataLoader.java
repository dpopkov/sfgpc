package learn.sfg.sfgpc.bootstrap;

import learn.sfg.sfgpc.model.Owner;
import learn.sfg.sfgpc.model.PetType;
import learn.sfg.sfgpc.model.Vet;
import learn.sfg.sfgpc.services.OwnerService;
import learn.sfg.sfgpc.services.PetTypeService;
import learn.sfg.sfgpc.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PetTypeService petTypeService;
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(PetTypeService petTypeService, OwnerService ownerService, VetService vetService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) {
        PetType dogType = new PetType("Dog");
        PetType catType = new PetType("Cat");
        petTypeService.save(dogType);
        petTypeService.save(catType);
        System.out.println("Loaded PetTypes....");

        Owner owner1 = new Owner("Michael", "Weston");
        ownerService.save(owner1);
        Owner owner2 = new Owner("Fiona", "Glenanne");
        ownerService.save(owner2);
        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet("Sam", "Axe");
        vetService.save(vet1);
        Vet vet2 = new Vet("Jane", "Arrow");
        vetService.save(vet2);
        System.out.println("Loaded Vets....");
    }
}
