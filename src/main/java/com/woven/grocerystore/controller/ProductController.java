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
    

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String list(Model model)
    {
        List<ProductDto> productDtoList = productService.list(); 
        model.addAttribute("products",productDtoList);
        return "productList";
    }

	@RequestMapping(value= {"/add","edit"}, method = RequestMethod.POST)
	public String add(@ModelAttribute("product") ProductDto productDto){
		this.productService.update(productDto);
		return "redirect:/productList";
		
	}
    
  /*  @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(@ModelAttribute("product") ProductDto productDto) {
        productService.update(productDto);
		return "redirect:/productList";
    }*/
}
