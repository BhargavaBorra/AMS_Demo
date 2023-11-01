package org.iitc.ams_demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Allocate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllocateDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AllocateId;
    private Date allocationDate;
    private Date deAllocationDate;
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "AssetId")
    private AssetDTO asset;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "UserId")
    private UserDTO user;
}
