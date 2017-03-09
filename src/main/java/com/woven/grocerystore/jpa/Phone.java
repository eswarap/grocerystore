package com.woven.grocerystore.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
public class Phone implements Serializable {
    
     private static final long serialVersionUID = 1l;
     
     public Phone() {
         
     }
     
     public Phone(String phoneType,String phoneNumber) {
         this.phoneType = phoneType;
         this.phoneNumber = phoneNumber;
     }
     
     
     @Id
     @Column(name="PHONE_ID")
     @GeneratedValue(strategy=GenerationType.AUTO)
     private Long phoneId;
     
     @Column(name="PHONE_TYPE")
     private String phoneType;
     
     @Column(name="PHONE_NUMBER")
	 private String phoneNumber;
	 
	 @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST,mappedBy = "phone")
     private Set<Customer> customers = new HashSet<Customer>(0);
     
     @Override
     public String toString() {
         return new StringBuilder().append(" phoneId : ").append(phoneId)
                                   .append(" phoneType: ").append(phoneType)
                                   .append(" phoneNumber: ").append(phoneNumber)
                                   .toString();
     }
}
