package org.iitc.ams_demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Support")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupportDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long SupportId;
    private Date requestDate;
    private String requestDescription;
    private Date expectedRepairDate;
    @ManyToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "AssetId")
    private AssetDTO asset;
    @ManyToOne
    @JoinColumn(name = "maintenance_id", referencedColumnName = "MaintenanceId")
    private MaintenanceDTO maintenance;
}
