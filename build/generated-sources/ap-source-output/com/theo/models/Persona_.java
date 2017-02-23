package com.theo.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Persona.class)
public abstract class Persona_ {

	public static volatile SingularAttribute<Persona, String> apellidos;
	public static volatile SingularAttribute<Persona, String> direccion;
	public static volatile SingularAttribute<Persona, Integer> id;
	public static volatile SingularAttribute<Persona, Integer> edad;
	public static volatile SingularAttribute<Persona, Distrito> idDistrito;
	public static volatile SingularAttribute<Persona, String> dni;
	public static volatile SingularAttribute<Persona, String> nombres;

}

