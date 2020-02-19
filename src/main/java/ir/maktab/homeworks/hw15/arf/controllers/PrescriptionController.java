package ir.maktab.homeworks.hw15.arf.controllers;

import ir.maktab.homeworks.hw15.arf.entities.Medicine;
import ir.maktab.homeworks.hw15.arf.entities.Prescription;
import ir.maktab.homeworks.hw15.arf.services.MedicineService;
import ir.maktab.homeworks.hw15.arf.services.PatientService;
import ir.maktab.homeworks.hw15.arf.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;


    @Autowired
    PatientService patientService;


    @RequestMapping(value = "/definePrescription")
    public String definePrescription(Model model, @RequestParam("patientId") Long patientId){
        Prescription prescription = new Prescription();
        prescription.setPatient(patientService.findById(patientId));
        model.addAttribute("prescription", prescription);
        return "define-prescription-page";
    }

    @RequestMapping(value = "/definePrescription" ,params = "ok", method = RequestMethod.POST)
    public String definePrescriptionSubmit(@ModelAttribute Prescription prescription){
        if (prescription.getId() == null) {
            prescriptionService.save(prescription);

            return "redirect:/patient/editPatient/" + prescription.getPatient().getId();
        }
        else {
            prescriptionService.update(prescription);
            return "redirect:/patient/editPatient/" + prescription.getPatient().getId();
        }

    }

    @RequestMapping(value = "/definePrescription" ,params = "cancel", method = RequestMethod.POST)
    public String definePrescriptionSubmitCancel(@ModelAttribute Prescription prescription){
//        if (prescription.getId() == null) {
//            prescriptionService.save(prescription);

            return "redirect:/patient/editPatient/" + prescription.getPatient().getId();
//        }
//        else {
//            prescriptionService.update(prescription);
//            return "redirect:/patient/editPatient/" + prescription.getPatient().getId();
//        }

    }


    @RequestMapping(value = "/deletePrescription/{id}")
    public String deletePrescriptionById(@PathVariable(value = "id") final Long id){
        Long patientId = prescriptionService.findById(id).getPatient().getId();
        prescriptionService.deleteById(id);
        return "redirect:/patient/editPatient/" + patientId;
    }

    @RequestMapping(value = "/editPrescription/{id}" , method = RequestMethod.GET)
    public String editPrescriptionById(Model model, @PathVariable(value = "id") final Long id){
        model.addAttribute("prescription",prescriptionService.findById(id));
        return "define-prescription-page";
    }
}
