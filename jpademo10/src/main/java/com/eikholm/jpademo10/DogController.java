package com.eikholm.jpademo10;

import com.eikholm.jpademo10.model.Dog;
import com.eikholm.jpademo10.model.Owner;
import com.eikholm.jpademo10.service.DogService;
import com.eikholm.jpademo10.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DogController {

    private DogService dogService;
    private OwnerService ownerService;

    public DogController(DogService dogService, OwnerService ownerService) {
        this.dogService = dogService;
        this.ownerService = ownerService;
    }

    @GetMapping("/dogs")
    public String dogs(Model model){
        model.addAttribute("dogs", dogService.findAll());
        model.addAttribute("owners", ownerService.findAll());
        return "dogs/index";
    }

    @RequestMapping(value = "/dogs/addDog", method = RequestMethod.POST)
    public String addDog(Dog dog, @RequestParam("owner") String ownerId){
        Optional<Owner> owner = ownerService.findById(Long.parseLong(ownerId));
        if(owner.isPresent()){
            dog.setOwner(owner.get());
            owner.get().getDogs().add(dog);
        }
        dogService.save(dog);
        return "redirect:/dogs";
    }
}
