package ir.maktab.homeworks.hw15.arf.controllers;

import ir.maktab.homeworks.hw15.arf.entities.Medicine;
import ir.maktab.homeworks.hw15.arf.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;


    @RequestMapping("")
    public String medicineMain(){
        return "medicine-page";
    }

    @RequestMapping(value = "/defineMedicine" , method = RequestMethod.GET)
    public String defineMedicine(Model model){
        model.addAttribute("medicine",new Medicine());
        return "define-medicine-page";
    }

    @RequestMapping(value = "/defineMedicine" ,params = "ok", method = RequestMethod.POST)
    public String defineMedicineSubmit(@ModelAttribute Medicine medicine){
        if (medicine.getId() == null) {
            medicineService.save(medicine);
            return "medicine-page";
        }
        else {
            medicineService.update(medicine);
            return "redirect:/medicine/medicineList";
        }
    }
    @RequestMapping(value = "/defineMedicine" ,params = "cancel", method = RequestMethod.POST)
    public String cancelSubmit(@ModelAttribute Medicine medicine){
        if (medicine.getId() == null)
            return "medicine-page";
        else
            return "redirect:/medicine/medicineList";
    }

    @RequestMapping(value = "/medicineList")
    public String getMedicineList(Model model){
        model.addAttribute("medicineList", medicineService.medicineList());
        return "medicine-list-page";
    }

    @RequestMapping(value = "/deleteMedicine/{id}")
    public String deleteMedicineById(@PathVariable(value = "id") final Long id){
        medicineService.deleteById(id);
        return "redirect:/medicine/medicineList";
    }

    @RequestMapping(value = "/editMedicine/{id}" , method = RequestMethod.GET)
    public String editMedicineById(Model model, @PathVariable(value = "id") final Long id){
        model.addAttribute("medicine",medicineService.findById(id));
        return "define-medicine-page";
    }
//    @RequestMapping(value = "/editMedicine/{id}" , method = RequestMethod.POST)
//    public String editMedicineByIdSubmit(@ModelAttribute Medicine medicine){
//        medicineService.update(medicine);
//        return "main-page";
//    }
}
