package org.iitc.ams_demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Vendor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendorDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long VendorId;
    private String Name;
    private String Email;
    private Long phoneNumber;
    private Long contractDuration;
    private boolean contractStatus;
}
