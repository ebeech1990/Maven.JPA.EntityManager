package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PetOwner {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 20)
    private String fname;
    @Column(length = 20)
    private String lname;
    @Column(length = 20)
    private Integer num_of_pets;

    public PetOwner(){}

    public PetOwner(String fname, String lname, Integer num_of_pets){
        this.fname = fname;
        this.lname = lname;
        this.num_of_pets = num_of_pets;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getNum_of_pets() {
        return num_of_pets;
    }

    public void setNum_of_pets(Integer numOfPets) {
        this.num_of_pets = numOfPets;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
