package med.voll.api.dtos;

import jakarta.validation.Valid;
import med.voll.api.enums.Specialty;

public record UpdateDoctor(
        Long id,

        String name,

        Specialty specialty,

        @Valid
        UpdateAddress address
) {}
