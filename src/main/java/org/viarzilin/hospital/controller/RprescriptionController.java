package org.viarzilin.hospital.controller;

import org.viarzilin.hospital.model.domain.Rprescription;
import org.viarzilin.hospital.model.service.RprescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RprescriptionController {

    @Autowired(required = true)
    private RprescriptionService rprescriptionService;

    public void setRprescriptionService(RprescriptionService rprescriptionService) {
        this.rprescriptionService = rprescriptionService;
    }

    @RequestMapping(value = "rprescriptions", method = RequestMethod.GET)
    public String listRprescriptions(Model model){
        model.addAttribute("rprescription", new Rprescription());
        model.addAttribute("listRprescriptions", this.rprescriptionService.listRprescriptions());

        return "rprescriptions";
    }

    @RequestMapping(value = "/rprescriptions/add", method = RequestMethod.POST)
    public String addRprescription(@ModelAttribute("rprescription") Rprescription rprescription){
        if(rprescription.getId() == 0){
            this.rprescriptionService.addRprescription(rprescription);
        }else {
            this.rprescriptionService.updateRprescription(rprescription);
        }

        return "redirect:/rprescriptions";
    }

    @RequestMapping("/rprescriptions/remove/{id}")
    public String removeRprescription(@PathVariable("id") int id){
        this.rprescriptionService.removeRprescription(id);

        return "redirect:/rprescriptions";
    }

    @RequestMapping("/rprescriptions/edit/{id}")
    public String editRprescription(@PathVariable("id") int id, Model model){
        model.addAttribute("rprescription", this.rprescriptionService.getRprescriptionById(id));
        model.addAttribute("listRprescriptions", this.rprescriptionService.listRprescriptions());

        return "rprescriptions";
    }

    @RequestMapping("rprescriptiondata/{id}")
    public String rprescriptionData(@PathVariable("id") int id, Model model){
        model.addAttribute("rprescription", this.rprescriptionService.getRprescriptionById(id));

        return "rprescriptiondata";
    }
}