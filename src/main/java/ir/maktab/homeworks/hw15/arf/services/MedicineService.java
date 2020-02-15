package ir.maktab.homeworks.hw15.arf.services;

import ir.maktab.homeworks.hw15.arf.entities.Medicine;
import ir.maktab.homeworks.hw15.arf.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;


    public Medicine save(Medicine medicine){
        return medicineRepository.save(medicine);
    }

    public List<Medicine> medicineList(){
        return medicineRepository.findAll();
    }
}
