package com.javatpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatpoint.beans.article;
//import com.javatpoint.dao.ArticleDao;
import com.javatpoint.mapper.ArticleMapper;

@Controller  
public class ArticleController {  
	
	private ArticleMapper mapper;
//    @Autowired  
//    ArticleDao dao;//will inject dao from xml file  
    
    public ArticleController(ArticleMapper mapper) {
    	this.mapper = mapper;
    }
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/articleform")  
    public String showform(Model m){  
    	m.addAttribute("command", new article());
    	return "articleform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("article") article article){  
        mapper.save(article);  
        return "redirect:/viewarticle";//will redirect to viewarticle request mapping  
    }  
    /* It provides list of articles in model object */  
    @RequestMapping("/viewarticle")  
    public String viewarticle(Model m){  
        List<article> list=mapper.getArticles();  
        m.addAttribute("list",list);
        return "viewarticle";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editarticle/{id}")  
    public String edit(@PathVariable int id, Model m){  
        article article=mapper.getArticleById(id);  
        m.addAttribute("command",article);
        return "articleeditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("article") article article){  
        mapper.update(article);  
        return "redirect:/viewarticle";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewarticle */  
    @RequestMapping(value="/deletearticle/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        mapper.delete(id);  
        return "redirect:/viewarticle";  
    }   
}  