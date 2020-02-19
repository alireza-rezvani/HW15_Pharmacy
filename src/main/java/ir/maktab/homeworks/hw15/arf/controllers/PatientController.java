package ir.maktab.homeworks.hw15.arf.controllers;

import ir.maktab.homeworks.hw15.arf.entities.Medicine;
import ir.maktab.homeworks.hw15.arf.entities.Patient;
import ir.maktab.homeworks.hw15.arf.entities.Prescription;
import ir.maktab.homeworks.hw15.arf.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @RequestMapping("")
    public String patientMain(){
        return "patient-page";
    }

    @RequestMapping(value = "/definePatient" , method = RequestMethod.GET)
    public String definePatient(Model model){
        model.addAttribute("patient",new Patient());
        return "define-patient-page";
    }

    @RequestMapping(value = "/definePatient" ,params = "ok", method = RequestMethod.POST)
    public String definePatientSubmit(@ModelAttribute Patient patient){
        if (patient.getId() == null) {
            Patient savedPatient = patientService.save(patient);
            return "redirect:/patient/editPatient/" + savedPatient.getId();
        }
        else {
            patientService.update(patient);
            return "redirect:/patient/patientList";
        }

    }



    @RequestMapping(value = "/patientList")
    public String getPatientList(Model model){
        model.addAttribute("patientList", patientService.patientList());
        return "patient-list-page";
    }


    @RequestMapping(value = "/editPatient/{id}" , method = RequestMethod.GET)
    public String editPatientById(Model model, @PathVariable(value = "id") final Long id){

        model.addAttribute("patient",patientService.findById(id));
        return "define-patient-page";
    }


    @RequestMapping(value = "/deletePatient/{id}")
    public String deletePatientById(@PathVariable(value = "id") final Long id){
        patientService.deleteById(id);
        return "redirect:/patient/patientList";
    }


    @RequestMapping(value = "/viewPatient/{id}" , method = RequestMethod.GET)
    public String viewPatientById(Model model, @PathVariable(value = "id") final Long id){
        model.addAttribute("patient",patientService.findById(id));
        return "view-patient-page";
    }


//    @RequestMapping(value = "/submitPatientPage")
//    public String submitPatientPage(){
//
//        return "redirect:/patient";
//    }
}
