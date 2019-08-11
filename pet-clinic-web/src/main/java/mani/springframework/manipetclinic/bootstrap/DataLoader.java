package mani.springframework.manipetclinic.bootstrap;

import mani.springframework.manipetclinic.model.Owner;
import mani.springframework.manipetclinic.model.PetType;
import mani.springframework.manipetclinic.model.Vet;
import mani.springframework.manipetclinic.service.OwnerService;
import mani.springframework.manipetclinic.service.PetTypeService;
import mani.springframework.manipetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }


    @Override
    public void run(String... args) throws Exception {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDog = petService.save(dog);

        PetType cat=new PetType();
        dog.setName("Cat");
        PetType savedCat = petService.save(cat);

        Owner owner1=new Owner();
        owner1.setFirstName("Lokendra");
        owner1.setLastName("Mani");

        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("Hari");
        owner2.setLastName("Mishra");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Same");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Rajesh");
        vet2.setLastName("Bharti");

        vetService.save(vet2);

        System.out.println("Loaded Pets...");

    }
}

