package com.kenyi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ChurchController {

    private ChurchService service;

    @Autowired
    public ChurchController(ChurchService service){
        this.service = service;
    }

    @RequestMapping(value = "/home")
    public String home(){
        return "index";
    }
    @RequestMapping(value = "/about")
    public String about() {
        return "about";
    }
    @RequestMapping(value = "/event")
    public String event() {
        return "events";
    }
    @RequestMapping(value = "/sermon")
    public String sermon() {
        return "sermons";
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String contact(ChurchModel churchModel, Model model) {
        ChurchModel insert = service.save(churchModel);
        model.addAttribute("insert", insert);
        return "redirect:/home";
    }
    @GetMapping(value = "/contact")
    public String requestContact(ChurchModel churchModel, Model model){
        model.addAttribute("churchModel", churchModel);
        return "contact";

    }
    @GetMapping("/list")
    public String findAll(Model model){
        List<ChurchModel> visitors = service.findAll();
        model.addAttribute("visitors",visitors);
        return "visitors_list";

    }
    @PutMapping(value = "/update/{id}")
    public String update(@PathVariable("id") ChurchModel churchModel, Model model){
       ChurchModel update = service.updateModel(churchModel);
       model.addAttribute("update", update);
       return "update_visitors";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        service.deleteById(id);
       // ModelAndView modelAndView = new ModelAndView("visitors_list");
        return "redirect:/list";


    }

}
