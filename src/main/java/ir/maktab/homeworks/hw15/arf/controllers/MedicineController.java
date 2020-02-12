package ir.maktab.homeworks.hw15.arf.controllers;

import ir.maktab.homeworks.hw15.arf.entities.Medicine;
import ir.maktab.homeworks.hw15.arf.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;


    @RequestMapping(value = "/addMedicine" , method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("medicine",new Medicine());
        return "add-medicine-page";
    }

    @RequestMapping(value = "/addMedicine" , method = RequestMethod.POST)
    public String addSubmit(@ModelAttribute Medicine medicine){
        medicineService.save(medicine);
        return "main-page";
    }
}
