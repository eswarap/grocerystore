package com.woven.grocerystore.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woven.grocerystore.dto.CategoryDto;
import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.jpa.Product;
import com.woven.grocerystore.mapper.GroceryMapper;
import com.woven.grocerystore.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value="/products")
public class ProductController {
    
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    
    @Autowired
    @Qualifier("productService")
    ProductService productService;
    
    @Autowired
    @Qualifier("groceryMapper")
    private GroceryMapper groceryMapper;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String getAllProducts(Model model)
    {
        Collection<Product> products =  productService.fetchAllProduct(); 
        List<ProductDto> productDtoList = products.stream().filter(product ->product!=null).map(product -> convertToDto(product)).collect(Collectors.toList());
        model.addAttribute("products",productDtoList);
        return "productList";
    }
    
    private ProductDto convertToDto(Product product) {
        ProductDto productDto = groceryMapper.map(product, ProductDto.class);
        productDto.setCategoryDto(groceryMapper.map(product.getCategory(),CategoryDto.class));
        LOG.info(String.format("category name is %s",productDto.getCategory().getCategoryName()));
        return productDto;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product")ProductDto product, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", product.getProductName());
        model.addAttribute("description", product.getDescription());

        return "productList";
    }

    
    @RequestMapping(value = "/edit/{prodId}/{catId}", method = RequestMethod.POST)
    public String updateProduct(@PathVariable Long prodId, @PathVariable Long catId,@ModelAttribute("product") ProductDto productDto) {
        productService.update(productDto,prodId,catId);
        return "productList";
    }
}
