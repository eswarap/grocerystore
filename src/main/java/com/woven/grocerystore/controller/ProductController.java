package com.woven.grocerystore.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.woven.grocerystore.jpa.Pagination;
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
    private ProductService productService;
    
    @Autowired
    @Qualifier("categoryService")
    private  CategoryService categoryService;
    
    @Autowired
    @Qualifier("groceryMapper")
    private GroceryMapper groceryMapper;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView list(Model model,@RequestParam(value="page",required=false) Integer page) {
        
        int count = productService.count().intValue();
        int endpage =  (count+Pagination.SIZE-1)/Pagination.SIZE;
        int startpage = 1;
                
        int first = page == 1 ? 0 : ( page -1 )* Pagination.SIZE;
        int max = first + Pagination.SIZE;
        max = max > count ? count :max;
        Pagination pagination = new Pagination(first,max);
        List<ProductDto> productDtoList = productService.list(pagination); 
        model.addAttribute("startpage",startpage);
        model.addAttribute("endpage",endpage);
        model.addAttribute("products",productDtoList);
        return new ModelAndView("product/list");
    }

    @RequestMapping(value= {"add"}, method = RequestMethod.POST)
    public String add(@ModelAttribute("product") ProductDto productDto,BindingResult result,
                        ModelMap model){
                            
    	this.productService.save(productDto);
    	return "redirect:/products/list?page=1";
    	
    }
    
    @RequestMapping(value = "enter", method = RequestMethod.GET)
    public ModelAndView enter(Model model) {
        
        ProductDto productDto = new ProductDto();
        CategoryDto category = new CategoryDto();
        productDto.setCategory(category);
        model.addAttribute("product",productDto);
        List<CategoryDto> categoryList = categoryService.list(new Pagination());
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("category",category);
        
		return new ModelAndView("product/add");
    }
    
    @RequestMapping(value = "edit/{prodId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long prodId,Model model) {
        
        Product product = productService.find(prodId);
        ProductDto productDto = groceryMapper.map(product, ProductDto.class);
        Category category = categoryService.find(product.getCategory().getCategoryId());
        CategoryDto categoryDto = groceryMapper.map(category,CategoryDto.class);
        model.addAttribute("product",productDto);
        List<CategoryDto> categoryList = categoryService.list();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("category",categoryDto);
        model.addAttribute("productId",prodId);
		return new ModelAndView("product/edit");
    }
    
    @RequestMapping(value= "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("product") ProductDto productDto,BindingResult result,
                        ModelMap model){

    	this.productService.update(productDto);
    	return "redirect:/products/list?page=1";    	
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String remove(@RequestParam("productId") Long productId) {
        
        this.productService.delete(productId);
    	return "redirect:/products/list?page=1";
    
    }
}
