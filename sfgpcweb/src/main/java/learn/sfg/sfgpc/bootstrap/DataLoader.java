package learn.sfg.sfgpc.bootstrap;

import learn.sfg.sfgpc.model.*;
import learn.sfg.sfgpc.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final PetTypeService petTypeService;
    private final OwnerService ownerService;
    private final VetSpecialtyService vetSpecialtyService;
    private final VetService vetService;
    private final VisitService visitService;

    public DataLoader(PetTypeService petTypeService, OwnerService ownerService, VetSpecialtyService vetSpecialtyService, VetService vetService, VisitService visitService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
        this.vetSpecialtyService = vetSpecialtyService;
        this.vetService = vetService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        final int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
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
        Visit catVisit1 = new Visit(LocalDate.of(2022, 3, 20), "First visit");
        Visit catVisit2 = new Visit(LocalDate.of(2022, 3, 23), "Second visit");
        fionasCat.addVisit(catVisit1);
        fionasCat.addVisit(catVisit2);
        owner2.addPet(fionasCat);
        ownerService.save(owner2);
        visitService.save(catVisit1);   // Have to save Visits after Owner because of that check in Visit's save operation
        visitService.save(catVisit2);
        System.out.println("Loaded Owners....");

        VetSpecialty radiology = new VetSpecialty("Radiology");
        vetSpecialtyService.save(radiology);
        VetSpecialty surgery = new VetSpecialty("Surgery");
        vetSpecialtyService.save(surgery);
        VetSpecialty dentistry = new VetSpecialty("Dentistry");
        vetSpecialtyService.save(dentistry);
        System.out.println("Loaded Vet Specialties....");

        Vet vet1 = new Vet("Sam", "Axe");
        vet1.getSpecialties().add(radiology);
        vetService.save(vet1);
        Vet vet2 = new Vet("Jane", "Arrow");
        vet1.getSpecialties().add(surgery);
        vetService.save(vet2);
        System.out.println("Loaded Vets....");
    }
}
