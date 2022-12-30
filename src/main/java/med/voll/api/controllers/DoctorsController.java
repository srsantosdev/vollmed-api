package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dtos.DoctorToHTTP;
import med.voll.api.dtos.RegisterDoctor;
import med.voll.api.dtos.UpdateDoctor;
import med.voll.api.entities.Doctor;
import med.voll.api.mappers.DoctorMapper;
import med.voll.api.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {
    @Autowired
    private DoctorsRepository doctorsRepository;

    @PostMapping
    @Transactional
    public DoctorToHTTP createDoctor(@RequestBody @Valid RegisterDoctor data) {
        Doctor doctor = new Doctor(data);
        this.doctorsRepository.save(doctor);

        return DoctorMapper.toHTTP(doctor);
    }

    @GetMapping
    public Page<DoctorToHTTP> listDoctors(Pageable pagination) {
        Page<Doctor> doctors = this.doctorsRepository.findAll(pagination);

        return doctors.map(DoctorMapper::toHTTP);
    }

    @PutMapping
    @Transactional
    public DoctorToHTTP updateDoctor(@RequestBody @Valid UpdateDoctor data) {
        var doctor = this.doctorsRepository.getReferenceById(data.id());

        doctor.update(data);

        return DoctorMapper.toHTTP(doctor);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id) {
        this.doctorsRepository.deleteById(id);
    }
}
