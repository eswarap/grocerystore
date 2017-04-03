package com.woven.grocerystore.jpa;

public class Pagination {
    
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

