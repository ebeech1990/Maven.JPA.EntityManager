package entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(length = 50)
    private String species;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private Integer age;
    @Column(length = 250)
    private String fav_napping_spot;
    @Column(length = 50)
    private String fav_food;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PetOwner> owners = new HashSet<PetOwner>();

    public Pet(){}


    public Pet(Integer age, String fav_food, String fav_napping_spot, String name, String species) {
        this.species = species;
        this.name = name;
        this.age = age;
        this.fav_napping_spot = fav_napping_spot;
        this.fav_food = fav_food;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFav_napping_spot() {
        return fav_napping_spot;
    }

    public void setFav_napping_spot(String favNappingSpot) {
        this.fav_napping_spot = favNappingSpot;
    }

    public String getFav_food() {
        return fav_food;
    }

    public void setFav_food(String favFood) {
        this.fav_food = favFood;
    }

    public Set<PetOwner> getOwners() {
        return owners;
    }

    public void setOwners(Set<PetOwner> owners) {
        this.owners = owners;
    }
}
