package com.woven.grocerystore.mapper;


import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

@Component(value="groceryMapper")
public class GroceryMapper extends ModelMapper {
    
    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        Object tmpSource = source;
        if(source == null){
            tmpSource = new Object();
        }

        return super.map(tmpSource, destinationType);
    }
    
}
