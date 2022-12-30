package med.voll.api.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dtos.RegisterAddress;
import med.voll.api.dtos.UpdateAddress;

@Embeddable
@Getter()
@NoArgsConstructor()
@AllArgsConstructor()
public class Address {
    private String street;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String complement;
    private String number;

    public Address(RegisterAddress addressDto) {
        this.street = addressDto.street();
        this.neighborhood = addressDto.neighborhood();
        this.city = addressDto.city();
        this.state = addressDto.state();
        this.complement = addressDto.complement();
        this.number = addressDto.number();
        this.zipcode = addressDto.zipcode();
    }

    public void update(UpdateAddress address) {
        if(address.zipcode() != null) {
            this.zipcode = address.zipcode();
        }
        if(address.neighborhood() != null) {
            this.neighborhood = address.neighborhood();
        }
        if(address.city() != null) {
            this.city = address.city();
        }
        if(address.state() != null) {
            this.state = address.state();
        }
        if(address.complement() != null) {
            this.complement = address.complement();
        }
        if(address.number() != null) {
            this.number = address.number();
        }
        if(address.street() != null) {
            this.street = address.street();
        }
    }
}
