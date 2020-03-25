package services;

import entities.Pet;
import entities.PetOwner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class PetServices {

    private EntityManager em = null;
    private EntityTransaction et = null;

    public PetServices(EntityManager em){
        this.em = em;
        this.et = em.getTransaction();
    }


    public Pet createPet(String species, String name, Integer age, String favNappingSpot, String favFood, Set<PetOwner> owner){
        Pet pet = new Pet();
        pet.setSpecies(species);
        pet.setName(name);
        pet.setAge(age);
        pet.setFav_napping_spot(favNappingSpot);
        pet.setFav_food(favFood);

        et.begin();
        em.persist(pet);
        et.commit();

        return pet;
    }

    public Pet createPet(Pet pet){
        et.begin();
        em.persist(pet);
        et.commit();

        return pet;
    }

    public  Pet findPet(Long id){
        return em.find(Pet.class, id);
    }

    public List<Long> findAll(){
        Query q = em.createNativeQuery("SELECT p.id FROM pet p");
        return q.getResultList();
    }

    public void removePet(Long id){
        Pet pet = em.find(Pet.class, id);
        if(pet!=null){
            et.begin();
            em.remove(pet);
            et.commit();
        }
    }

    public Pet changeFavNappingSpot(Long id, String newFavNappingSpot){
        Pet pet = em.find(Pet.class, id);
        if(pet!=null){
            et.begin();
            pet.setFav_napping_spot(newFavNappingSpot);
            et.commit();
        }
        return pet;
    }

    public Pet changeFavNappingSpot(Pet pet, String newFavNappingSpot){
        if(pet!=null){
            et.begin();
            pet.setFav_napping_spot(newFavNappingSpot);
            et.commit();
        }
        return pet;
    }

    public Pet happyBirthday(Pet pet){
        if(pet!=null){
            et.begin();
            pet.setAge(pet.getAge()+1);
            et.commit();
        }
        return pet;
    }
}
