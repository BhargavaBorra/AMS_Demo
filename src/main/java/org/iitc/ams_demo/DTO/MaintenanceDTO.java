package org.iitc.ams_demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Maintenance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long MaintenanceId;
    private String errorCode;
    private String errorDescription;
    private String status;
}
