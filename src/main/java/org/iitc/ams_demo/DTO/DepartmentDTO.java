package org.iitc.ams_demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long DepartmentId;
    private String Name;
    private String Email;
    private Long phoneNumber;
}
