package com.woven.grocerystore.mapper;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component(value="groceryMapper")
public class GroceryMapper extends ModelMapper {
    
    public GroceryMapper() {
        this.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }
    
    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        Object tmpSource = source;
        if(source == null){
            tmpSource = new Object();
        }

        return super.map(tmpSource, destinationType);
    }
    
}
