package med.voll.api.dtos;

import jakarta.validation.constraints.Pattern;

public record UpdateAddress(
        String street,

        String neighborhood,

        @Pattern(regexp = "\\d{8}")
        String zipcode,

        String city,

        String state,

        String number,

        String complement
) {}
