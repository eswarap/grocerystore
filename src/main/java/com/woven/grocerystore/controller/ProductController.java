package com.woven.grocerystore.controller;

import java.util.List;
import java.util.Collection;

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

import com.woven.grocerystore.jpa.Category;
import com.woven.grocerystore.jpa.Product;
import com.woven.grocerystore.mapper.GroceryMapper;
import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.dto.CategoryDto;
import com.woven.grocerystore.service.ProductService;
import com.woven.grocerystore.service.CategoryService;

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
    @Qualifier("categoryService")
    CategoryService categoryService;
    
    @Autowired
    @Qualifier("groceryMapper")
    private GroceryMapper groceryMapper;

    @RequestMapping(value = "getall", method = RequestMethod.GET)
    public String list(Model model)
    {
        List<ProductDto> productDtoList = productService.list(); 
        model.addAttribute("products",productDtoList);
        return "productList";
    }

    @RequestMapping(value= {"add"}, method = RequestMethod.POST)
    public String add(@ModelAttribute("product") ProductDto productDto,BindingResult result,
                        ModelMap model){
        System.out.println("####product Id = "+productDto.getProductName());
        System.out.println("####category Id = "+productDto.getCategory().getCategoryId());
    	this.productService.save(productDto);
    	return "redirect:/products/getall";
    	
    }
    
    @RequestMapping(value = "enter", method = RequestMethod.GET)
    public String enter(Model model) {
        ProductDto productDto = new ProductDto();
        CategoryDto category = new CategoryDto();
        productDto.setCategory(category);
        model.addAttribute("product",productDto);
        Collection<Category> categoryList = categoryService.list();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("category",category);
        
		return "addProduct";
    }
    
    @RequestMapping(value = "edit/{prodId}", method = RequestMethod.GET)
    public String edit(@PathVariable Long prodId,Model model) {
        Product product = productService.find(prodId);
        ProductDto productDto = groceryMapper.map(product, ProductDto.class);
        Category category = categoryService.find(product.getCategory().getCategoryId());
        CategoryDto categoryDto = groceryMapper.map(category,CategoryDto.class);
        model.addAttribute("product",productDto);
        Collection<Category> categoryList = categoryService.list();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("category",categoryDto);
        
		return "editProduct";
    }
    
    @RequestMapping(value= "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("product") ProductDto productDto,BindingResult result,
                        ModelMap model){
        System.out.println("####product Id = "+productDto.getProductName());
        System.out.println("####category Id = "+productDto.getCategory().getCategoryId());
    	this.productService.save(productDto);
    	return "redirect:/products/getall";
    	
    }
}
