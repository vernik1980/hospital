package org.viarzilin.hospital.controller.doctor;

import org.viarzilin.hospital.model.domain.Rprescription;
import org.viarzilin.hospital.model.service.PrescriptionService;
import org.viarzilin.hospital.model.service.ReceptionService;
import org.viarzilin.hospital.model.service.RprescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.service.UserService;


@Controller
public class RprescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired(required = true)
    private ReceptionService receptionService;

    @Autowired
    private UserService userService;

    @Autowired(required = true)
    private RprescriptionService rprescriptionService;

    @RequestMapping(value = "doctor/rprescriptions", method = RequestMethod.GET)
    public String listRprescriptions(Model model){
        model.addAttribute("rprescription", new Rprescription());
        model.addAttribute("listRprescriptions", rprescriptionService.listRprescriptions());
        model.addAttribute("listHospitalizedReceptions", receptionService.listHospitalizedReceptions());
        model.addAttribute("listUsersByRoleDoctor", userService.listUsersByRoleDoctor());
        model.addAttribute("listPrescriptions", prescriptionService.listPrescriptions());

        return "doctor/rprescriptions";
    }

    @RequestMapping(value = "/doctor/rprescriptions/add", method = RequestMethod.POST)
    public String addRprescription(@ModelAttribute("rprescription") Rprescription rprescription){
      if(rprescription.getId() == 0){
//        this.rprescriptionService.addRprescription(rprescription);
      }else {
        this.rprescriptionService.updateRprescription(rprescription);
      }

      return "redirect:/doctor/rprescriptions";
    }

    @RequestMapping("/doctor/rprescriptions/edit/{id}")
    public String editRprescription(@PathVariable("id") int id, Model model){
      model.addAttribute("rprescription", rprescriptionService.getRprescriptionById(id));
      model.addAttribute("listPrescriptions", prescriptionService.listPrescriptions());
      model.addAttribute("listHospitalizedReceptions", receptionService.listHospitalizedReceptions());
      model.addAttribute("listRprescriptions", rprescriptionService.listRprescriptions());
      return "doctor/rprescriptions";
    }


    @RequestMapping("/doctor/rprescriptions/remove/{id}")
    public String removeRprescription(@PathVariable("id") int id){
        rprescriptionService.removeRprescription(id);

        return "redirect:/doctor/rprescriptions";
    }
}
