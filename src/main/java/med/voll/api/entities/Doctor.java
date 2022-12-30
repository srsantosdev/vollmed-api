package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dtos.RegisterDoctor;
import med.voll.api.dtos.UpdateDoctor;
import med.voll.api.enums.Specialty;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter()
@NoArgsConstructor()
@AllArgsConstructor()
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(RegisterDoctor registerDoctorDTO) {
        this.name = registerDoctorDTO.name();
        this.email = registerDoctorDTO.email();
        this.crm = registerDoctorDTO.crm();
        this.address = new Address(registerDoctorDTO.address());
        this.specialty = registerDoctorDTO.specialty();
    }

    public void update(UpdateDoctor updateDoctor) {
        if(updateDoctor.name() != null) {
            this.name = updateDoctor.name();
        }

        if(updateDoctor.specialty() !=  null) {
            this.specialty = updateDoctor.specialty();
        }

        if(updateDoctor.address() != null) {
            this.address.update(updateDoctor.address());
        }
    }
}
