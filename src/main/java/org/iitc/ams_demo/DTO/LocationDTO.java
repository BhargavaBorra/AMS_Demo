package org.iitc.ams_demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationID;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
}
