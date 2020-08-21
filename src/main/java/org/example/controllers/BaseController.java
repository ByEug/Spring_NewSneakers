package org.example.controllers;

import org.example.models.Sneakers;
import org.example.service.SneakersService;
import org.example.service.SneakersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BaseController {

    private SneakersService sneakersService;

    @Autowired
    public void setSneakersService(SneakersService sneakersService) {
        this.sneakersService = sneakersService;
    }

    @GetMapping("")
    public String BasePage(Model model) {
        List<Sneakers> allSneakers = sneakersService.allSneakers();
        model.addAttribute("allSneakers", allSneakers);
        return "BasePage";
    }

    @PostMapping("")
    public String Search(@RequestParam("filter") String filter, Model model) {
        if (filter != null) {
            model.addAttribute("allSneakers", sneakersService.searchByBrand(filter));
        }
        else {
            model.addAttribute("allSneakers", sneakersService.allSneakers());
        }
        return "BasePage";
    }

    @GetMapping("/edit/{id}")
    public String EditPage(Model model, @PathVariable("id") int id) {
        Sneakers pair = sneakersService.getById(id);
        model.addAttribute("pair", pair);
        return "EditPage";
    }

    @PostMapping("/edit")
    public String EditPair(@ModelAttribute("pair") Sneakers pair, Model model) {
        sneakersService.edit(pair);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String AddPage(Model model) {
        return "AddPage";
    }

    @PostMapping("/add")
    public String AddPair(@ModelAttribute("pair") Sneakers pair, Model model) {
        sneakersService.add(pair);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String DeletePair(Model model, @PathVariable("id") int id) {
        sneakersService.delete(sneakersService.getById(id));
        return "redirect:/";
    }

}
