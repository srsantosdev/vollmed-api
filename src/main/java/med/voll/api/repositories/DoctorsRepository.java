package med.voll.api.repositories;

import med.voll.api.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends JpaRepository<Doctor, Long> {
}
