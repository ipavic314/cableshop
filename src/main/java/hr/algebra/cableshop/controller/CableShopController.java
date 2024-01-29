package hr.algebra.cableshop.controller;

import hr.algebra.cableshop.domain.Cable;
import hr.algebra.cableshop.domain.CableTag;
import hr.algebra.cableshop.repository.CableRepository;
import hr.algebra.cableshop.repository.CableTagRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CableShopController {

    private final CableRepository cableRepository;
    private final CableTagRepository cableTagRepository;

    public CableShopController(CableRepository cableRepository, CableTagRepository cableTagRepository) {
        this.cableRepository = cableRepository;
        this.cableTagRepository = cableTagRepository;
    }



    @GetMapping("/home")
    public String homePage(Model model) {


        return "home";}

    @ModelAttribute
    public void addAttributesToModel(Model model){
        Iterable<Cable> all = cableRepository.findAll();
        model.addAttribute("cables", all);
        model.addAttribute("createCable", new Cable());
        model.addAttribute("cableTags", cableTagRepository.findAll());
        model.addAttribute("createCableTag", new CableTag());
    }

    @PostMapping("/saveCable")
    public String saveCable(@Valid @ModelAttribute("createCable") Cable cable, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "home";
        }else {
            cableRepository.save(cable);
            return "home";
        }
    }

    @PostMapping("/saveCableTag")
    public String saveCable(@Valid @ModelAttribute("createCableTag") CableTag cableTag, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "home";
        }else {
            cableTagRepository.save(cableTag);
            return "home";
        }
    }



}
