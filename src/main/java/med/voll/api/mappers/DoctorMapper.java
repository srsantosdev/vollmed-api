package med.voll.api.mappers;

import med.voll.api.dtos.DoctorToHTTP;
import med.voll.api.entities.Doctor;

public class DoctorMapper {
    public static DoctorToHTTP toHTTP(Doctor doctor) {
        return new DoctorToHTTP(
            doctor.getId(),
            doctor.getName(),
            doctor.getEmail(),
            doctor.getCrm(),
            doctor.getSpecialty()
        );
    }
}
