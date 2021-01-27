package ir.maktab.busTerminal.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ticket.class)
public abstract class Ticket_ {

	public static volatile SingularAttribute<Ticket, String> gender;
	public static volatile SingularAttribute<Ticket, String> name;
	public static volatile SingularAttribute<Ticket, Integer> id;
	public static volatile SingularAttribute<Ticket, Travel> travel;
	public static volatile SingularAttribute<Ticket, User> user;

	public static final String GENDER = "gender";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TRAVEL = "travel";
	public static final String USER = "user";

}

