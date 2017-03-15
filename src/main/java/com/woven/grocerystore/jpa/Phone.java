package com.woven.grocerystore.jpa;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Phone implements Serializable {
    
     private static final long serialVersionUID = 1l;
     
     public Phone() {
         
     }
          
     @Id
     @Column(name="PHONE_ID")
     @GeneratedValue(strategy=GenerationType.AUTO)
     private Long phoneId;
     
     @Column(name="PHONE_TYPE")
     private String phoneType;
     
     @Column(name="PHONE_NUMBER")
	 private String phoneNumber;
	      
     public Long getPhoneId() {
        return phoneId;
     }
    
     public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
     }
    
     public String getPhoneNumber() {
        return phoneNumber;
     }  
     
     public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
     }
     
     public String getPhoneType() {
        return phoneType;
     }
     
     public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
     }
     
     public Phone(String phoneType,String phoneNumber) {
         this.phoneType = phoneType;
         this.phoneNumber = phoneNumber;
     }
     


     @Override
     public String toString() {
         return new StringBuilder().append(" phoneId : ").append(phoneId)
                                   .append(" phoneType: ").append(phoneType)
                                   .append(" phoneNumber: ").append(phoneNumber)
                                   .toString();
     }
}
