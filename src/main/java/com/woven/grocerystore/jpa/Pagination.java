package com.woven.grocerystore.jpa;

import java.io.Serializable;

public class Pagination implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    private Integer first;
    private Integer max;
    public final static Integer SIZE = 10; 
    
    public Pagination() {
        this.first = 0;
        this.max = SIZE;
    }
    public Pagination(Integer first,Integer max) {
        this.first = first;
        this.max = max;
    }
    public Integer getFirst() {
        return first;
    }
    
    public Integer getMax() {
        return max;
    }
}

