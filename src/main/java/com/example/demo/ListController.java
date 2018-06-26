package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class ListController {

    @Autowired
    ListRepository listRepo;

    @RequestMapping("/")
    public String homePage(Model model){
        return "homepage";
    }
    @RequestMapping("/addlist")
    public String addList(Model model){
        model.addAttribute("listt",new LinkList());
        return "listform";
    }

    @RequestMapping("/sitelist")
    public String listSites(Model model){
        model.addAttribute("lists", listRepo.findAll());
        return "listsites";
    }
    @PostMapping("/process")
    public String recordList(@Valid LinkList linkList, BindingResult result){
        listRepo.save(linkList);
        return "redirect:/sitelist";
    }

    @RequestMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("lists",listRepo.findById(id).get());
        return "jobform";
    }
    @RequestMapping("/detail/{id}")
    public String showJob(@PathVariable("id") long id, Model model){

        model.addAttribute("lists", listRepo.findById(id).get());
        return "displaydetail";


    }

    @RequestMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") long id, Model model)
    {
        listRepo.deleteById(id);
        return "redirect:/showalljob";
    }
    @RequestMapping("/search")
    public String searchPromises(Model model, HttpServletRequest request)
    {
        String searchedFor = request.getParameter("searchfor");

        model.addAttribute("searchResults",true);
        model.addAttribute("lists",listRepo.findAllByUrlContainingIgnoreCase(searchedFor));
        return "joblist";
    }
    @RequestMapping("/redirect/{id}")
    public String redirectExternal(Model model, HttpServletRequest request)
    {
        String redirectUrl = request.getParameter("redirectto");

        return "redirect:" + redirectUrl;
    }

}
