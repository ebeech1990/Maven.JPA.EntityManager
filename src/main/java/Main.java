import entities.Pet;
import entities.PetOwner;
import services.PetServices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Testing");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        PetServices petServices = new PetServices(em);

        Set<PetOwner> ownerSet = new HashSet<PetOwner>();
        ownerSet.add(new PetOwner("Sam", "Smith", 2));
        ownerSet.add(new PetOwner("Jill", "James", 1));
        ownerSet.add(new PetOwner("Randy", "Reynolds", 2));

        Pet rusty = petServices.createPet(new Pet(3, "pork chops", "foot of bed", "Rusty", "dog"));
        Pet pet = petServices.findPet(rusty.getId());

        petServices.changeFavNappingSpot(pet.getId(), "love seat");
        petServices.changeFavNappingSpot(pet, "office couch");

        petServices.findAll();
        petServices.happyBirthday(rusty);
        petServices.removePet(pet.getId());

    }


}
