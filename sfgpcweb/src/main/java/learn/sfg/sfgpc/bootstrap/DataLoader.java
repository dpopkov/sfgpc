package learn.sfg.sfgpc.bootstrap;

import learn.sfg.sfgpc.model.Owner;
import learn.sfg.sfgpc.model.Pet;
import learn.sfg.sfgpc.model.PetType;
import learn.sfg.sfgpc.model.Vet;
import learn.sfg.sfgpc.services.OwnerService;
import learn.sfg.sfgpc.services.PetTypeService;
import learn.sfg.sfgpc.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");
        Pet mikesDog = new Pet("Rosco", dogType, LocalDate.of(2015, 10, 10));
        owner1.addPet(mikesDog);
        ownerService.save(owner1);
        Owner owner2 = new Owner("Fiona", "Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("3213214321");
        Pet fionasCat = new Pet("", catType, LocalDate.of(2019, 7, 3));
        owner2.addPet(fionasCat);
        ownerService.save(owner2);
        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet("Sam", "Axe");
        vetService.save(vet1);
        Vet vet2 = new Vet("Jane", "Arrow");
        vetService.save(vet2);
        System.out.println("Loaded Vets....");
    }
}
