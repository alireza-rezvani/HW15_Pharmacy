package ir.maktab.homeworks.hw15.arf.repositories;

import ir.maktab.homeworks.hw15.arf.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
