package ir.maktab.homeworks.hw15.arf.repositories;

import ir.maktab.homeworks.hw15.arf.entities.Medicine;
import ir.maktab.homeworks.hw15.arf.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    @Transactional
    @Modifying
    @Query("update Prescription p set p.code = ?1, p.creationDate = ?2, p.registrationDate = ?3 where p.id = ?4")
    void updateById(Integer code, String creationDate, String registrationDate, Long id);
}
