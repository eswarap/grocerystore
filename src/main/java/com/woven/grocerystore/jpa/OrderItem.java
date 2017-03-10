package com.woven.grocerystore.jpa;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.FIELD)
public class OrderItem implements Serializable {
    
     private static final long serialVersionUID = 1l;
     
}
