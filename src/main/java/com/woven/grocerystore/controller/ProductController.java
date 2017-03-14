package com.woven.grocerystore.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.jpa.Product;
import com.woven.grocerystore.service.ProductService;

@Controller
@RequestMapping(value="/products")
public class ProductController {
    
    @Autowired
    @Qualifier("productService")
    ProductService productService;
    
    @Autowired
    @Qualifier("productMapper")
    private ModelMapper modelMapper;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String getAllProducts(Model model)
    {
        Collection<Product> products =  productService.fetchAllProduct(); 
        List<ProductDto> productDtoList = products.stream().map(product -> convertToDto(product)).collect(Collectors.toList());
        model.addAttribute("products",productDtoList);
        return "productList";
    }
    
    private ProductDto convertToDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }
}
