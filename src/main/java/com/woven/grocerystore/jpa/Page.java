package com.woven.grocerystore.jpa;

public class Page {
    
    private int first;
    private int max;
    
    public Page() {
        this.first = 1;
        this.max = 50;
    }
    public Page(int first,int max) {
        this.first = first;
        this.max = max;
    }
    public int getFirst() {
        return first;
    }
    
    public int getMax() {
        return max;
    }
}

