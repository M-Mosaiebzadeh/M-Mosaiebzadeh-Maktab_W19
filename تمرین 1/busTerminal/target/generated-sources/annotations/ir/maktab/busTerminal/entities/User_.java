package ir.maktab.busTerminal.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> firstname;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> phoneNumber;
	public static volatile SetAttribute<User, Ticket> tickets;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> lastname;
	public static volatile SingularAttribute<User, String> username;

	public static final String FIRSTNAME = "firstname";
	public static final String PASSWORD = "password";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String TICKETS = "tickets";
	public static final String ID = "id";
	public static final String LASTNAME = "lastname";
	public static final String USERNAME = "username";

}

