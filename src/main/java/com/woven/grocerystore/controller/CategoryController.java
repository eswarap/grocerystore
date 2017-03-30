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

import com.woven.grocerystore.jpa.Category;
import com.woven.grocerystore.jpa.Pagination;
import com.woven.grocerystore.mapper.GroceryMapper;
import com.woven.grocerystore.dto.CategoryDto;
import com.woven.grocerystore.service.CategoryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value="/categories")
public class CategoryController {
    
    protected final Logger LOG = LoggerFactory.getLogger(getClass());
    
    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;
    
    
    @Autowired
    @Qualifier("groceryMapper")
    private GroceryMapper groceryMapper;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView list(Model model,@RequestParam(value="page",required=false) Integer page)
    {
        int count = categoryService.count().intValue();
        int endpage =  (count+Pagination.SIZE-1)/Pagination.SIZE;
        int startpage = 1;
                
        int first = page == 1 ? 0 : ( page -1 )* Pagination.SIZE;
        int max = first + Pagination.SIZE;
        max = max > count ? count :max;
        Pagination pagination = new Pagination(first,max);
        List<CategoryDto> categoryDtoList = categoryService.list(pagination); 
        model.addAttribute("categories",categoryDtoList);
        model.addAttribute("startpage",startpage);
        model.addAttribute("endpage",endpage);
        
        return new ModelAndView("category/categoryList");
    }

    @RequestMapping(value= {"add"}, method = RequestMethod.POST)
    public String add(@ModelAttribute("category") CategoryDto categoryDto,BindingResult result,
                        ModelMap model){
        
    	this.categoryService.save(categoryDto);
    	
    	return "redirect:/categories/list?page=1";
    }
    
    @RequestMapping(value = "enter", method = RequestMethod.GET)
    public ModelAndView enter(Model model) {
        
        CategoryDto categoryDto = new CategoryDto();
        model.addAttribute("category",categoryDto);
        
		return new ModelAndView("category/addCategory");
    }
    
    @RequestMapping(value = "edit/{catId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long catId,Model model) {
        
        Category category = categoryService.find(catId);
        CategoryDto categoryDto = groceryMapper.map(category, CategoryDto.class);
        List<CategoryDto> categoryList = categoryService.list();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("category",categoryDto);
        model.addAttribute("categoryId",catId);
        
		return new ModelAndView("category/editCategory");
    }
    
    @RequestMapping(value= "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("category") CategoryDto categoryDto,BindingResult result,
                        ModelMap model){
        
    	this.categoryService.update(categoryDto);
    	return "redirect:/categories/list?page=1";
    	
    }
    
   @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String remove(@RequestParam("categoryId") Long categoryId) {
        
        this.categoryService.delete(categoryId);
    	return "redirect:/categories/list?page=1";
    
    }    
}
