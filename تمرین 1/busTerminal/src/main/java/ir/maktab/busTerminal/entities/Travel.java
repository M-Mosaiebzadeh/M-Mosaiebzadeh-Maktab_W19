package ir.maktab.busTerminal.entities;

import ir.maktab.busTerminal.entities.enums.Location;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "travel")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_id")
    private Integer id;


    @Column(name = "origin")
    private String origin;


    @Column(name = "destination")
    private String destination;


    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;


    @Temporal(TemporalType.TIME)
    @Column(name = "time")
    private Date time;

//    @OneToMany
//    @JoinColumn(name = "fk_travel")
//    private Set<Ticket> tickets;

    @OneToMany(mappedBy = "travel")
    private Set<Ticket> tickets;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

}
