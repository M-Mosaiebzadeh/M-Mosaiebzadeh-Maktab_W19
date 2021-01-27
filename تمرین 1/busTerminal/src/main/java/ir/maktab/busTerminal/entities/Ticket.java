package ir.maktab.busTerminal.entities;

import ir.maktab.busTerminal.entities.enums.Gender;
import ir.maktab.busTerminal.entities.enums.Location;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer id;


    @Column(name = "name")
    private String name;


    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_travel")
    private Travel travel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
