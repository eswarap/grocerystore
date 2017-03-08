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
import javax.persistence.OneToMany;
import javax.persistence.Id;

import org.springframework.util.StringUtils;

@Entity(name = "ADDRESS")
@Access(AccessType.FIELD)
public class Address implements Serializable {

    private static final long serialVersionUID = 1l;

    public Address() {
        
    }
    
    public Address(String street,String city,String state,String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    @Id
    @Column(name="ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIPCODE")
    private String zipCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private Set<Customer> customer = new HashSet<Customer>(0);
 
    @Override
    public String toString() {
        return new StringBuilder().append("ADDRESS_ID:").append(addressId).
                append(" STREET:").append(street).
                append(" CITY:").append(city).
                append(" STATE:").append(state).
                append(" ZIPCODE:").append(zipCode).
                toString();
    }

}
