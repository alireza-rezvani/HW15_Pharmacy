package ir.maktab.homeworks.hw15.arf.services;

import ir.maktab.homeworks.hw15.arf.entities.Medicine;
import ir.maktab.homeworks.hw15.arf.entities.Patient;
import ir.maktab.homeworks.hw15.arf.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }


    public Patient findById(Long id){
        return patientRepository.findById(id).get();
    }

    public List<Patient> patientList(){
        return patientRepository.findAll();
    }

    public void update(Patient patient){

        patientRepository.updateById(patient.getName(), patient.getFamily(),patient.getGender(), patient.getId());
    }

    public void deleteById(Long id){
        patientRepository.deleteById(id);
    }



}
