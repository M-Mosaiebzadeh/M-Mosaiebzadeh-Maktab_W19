package ir.maktab.busTerminal.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Travel.class)
public abstract class Travel_ {

	public static volatile SingularAttribute<Travel, Date> date;
	public static volatile SetAttribute<Travel, Ticket> tickets;
	public static volatile SingularAttribute<Travel, String> origin;
	public static volatile SingularAttribute<Travel, String> destination;
	public static volatile SingularAttribute<Travel, Integer> id;
	public static volatile SingularAttribute<Travel, Date> time;

	public static final String DATE = "date";
	public static final String TICKETS = "tickets";
	public static final String ORIGIN = "origin";
	public static final String DESTINATION = "destination";
	public static final String ID = "id";
	public static final String TIME = "time";

}

