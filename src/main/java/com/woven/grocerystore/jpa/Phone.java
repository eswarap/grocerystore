package com.woven.grocerystore.jpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="PHONE")
@Access(AccessType.FIELD)
public class Phone implements Serializable {
    
     private static final long serialVersionUID = 1l;
     
     @Id
     @Column(name="PHONE_ID")
     @GeneratedValue(strategy=GenerationType.AUTO)
     private Long phoneId;
     
     @Column(name="PHONE_TYPE")
     private String phoneType;
     
     @Column(name="PHONE_NUMBER")
	 private String phoneNumber;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "phone")
     private Set<Customer> customer = new HashSet<Customer>(0);
}
