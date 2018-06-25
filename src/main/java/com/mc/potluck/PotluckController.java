package com.mc.potluck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PotluckController {
    @Autowired
    PotluckRepository potluckRepository;

    @RequestMapping("/")
    public String showHomepage(Model model){
        model.addAttribute("potluck", new Potluck());
        return "addchef";
    }
    @PostMapping("/process")
    public String savePotluck(@ModelAttribute Potluck potluck){
        potluckRepository.save(potluck);
        return "redirect:/listpotluck";
    }
    @GetMapping("/listpotluck")
    public String listPotluck(Model model){
        model.addAttribute("potlucks", potluckRepository.findAll());
        return "listchefs";
    }
    @RequestMapping("/update/{id}")
    public String updatePotluck(@PathVariable("id") long id, Model model){
        model.addAttribute("potluck", potluckRepository.findById(id).get());
        return "addchef";
    }
    @RequestMapping("/delete/{id}")
    public String deletePotluck(@PathVariable("id") long id){
        potluckRepository.deleteById(id);
        return "redirect:/listpotluck";
    }
}
