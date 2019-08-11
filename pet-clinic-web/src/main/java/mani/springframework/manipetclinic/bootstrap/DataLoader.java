package mani.springframework.manipetclinic.bootstrap;

import mani.springframework.manipetclinic.model.Owner;
import mani.springframework.manipetclinic.model.Pet;
import mani.springframework.manipetclinic.model.PetType;
import mani.springframework.manipetclinic.model.Vet;
import mani.springframework.manipetclinic.service.OwnerService;
import mani.springframework.manipetclinic.service.PetTypeService;
import mani.springframework.manipetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("202 II floor");
        owner1.setCity("Gurgaon");
        owner1.setTelephone("9818469891");
        ownerService.save(owner1);

        Pet lokendraPet=new Pet();
        lokendraPet.setPetType(savedDog);
        lokendraPet.setOwner(owner1);
        lokendraPet.setBirthDate(LocalDate.now());
        lokendraPet.setName("Rosco");
        owner1.getPets().add(lokendraPet);

        Owner owner2=new Owner();
        owner2.setFirstName("Hari");
        owner2.setLastName("Mishra");
        owner2.setAddress("202 II floor");
        owner2.setCity("Gurgaon");
        owner2.setTelephone("9818469892");
        ownerService.save(owner2);

        Pet hariPet=new Pet();
        hariPet.setPetType(savedCat);
        hariPet.setOwner(owner2);
        hariPet.setBirthDate(LocalDate.now());
        hariPet.setName("Meow");
        owner2.getPets().add(hariPet);

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

