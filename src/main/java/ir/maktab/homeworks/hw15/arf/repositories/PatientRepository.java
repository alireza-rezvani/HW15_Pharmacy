package ir.maktab.homeworks.hw15.arf.repositories;

import ir.maktab.homeworks.hw15.arf.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {



    @Transactional
    @Modifying
    @Query("update Patient p set p.name = ?1, p.family = ?2, p.gender = ?3 where p.id = ?4")
    void updateById(String name, String family, String gender, Long id);

}
