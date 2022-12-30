package med.voll.api.dtos;

import med.voll.api.enums.Specialty;

public record DoctorToHTTP(Long id, String name, String email, String crm, Specialty specialty) {
}
