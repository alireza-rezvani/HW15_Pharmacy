package ir.maktab.homeworks.hw15.arf.services;

import ir.maktab.homeworks.hw15.arf.entities.Medicine;
import ir.maktab.homeworks.hw15.arf.entities.Prescription;
import ir.maktab.homeworks.hw15.arf.repositories.MedicineRepository;
import ir.maktab.homeworks.hw15.arf.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;


    public Prescription save(Prescription prescription){
        return prescriptionRepository.save(prescription);
    }


//    public List<Medicine> medicineList(){
//        return medicineRepository.findAll();
//    }
//
    public void deleteById(Long id){
        prescriptionRepository.deleteById(id);
    }
//
    public Prescription findById(Long id){
        return prescriptionRepository.findById(id).get();
    }
//
    public void update(Prescription prescription){

        prescriptionRepository.updateById(prescription.getCode(), prescription.getCreationDate(),prescription.getRegistrationDate(), prescription.getId());
    }
}
