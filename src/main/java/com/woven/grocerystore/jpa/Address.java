package com.woven.grocerystore.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1l;

    //Empty constructor required for hibernate entities
    public Address() {
        
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

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST, mappedBy = "address")
    private Set<Customer> customers = new HashSet<Customer>(0);
    
    public Long getAddressId() {
        return addressId;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }
    
    public String getStreet() {
        return street;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
    
    public void getCity(String city) {
        this.city = city;
    }
    
    public void getState(String state) {
        this.state = state;
    }
    
    public void getStreet(String street) {
        this.street = street;
    }
    
    public void getZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
   
    public Address(String street,String city,String state,String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    
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
