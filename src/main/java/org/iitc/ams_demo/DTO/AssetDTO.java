package org.iitc.ams_demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Asset")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AssetId;
    @Column(name = "asset_name")
    private String AssetName;
    private String serialNumber;
    private int warranty;
    private Date warrantyExpiryDate;
    private Date shippedDate;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locationid")
    private LocationDTO location;

}
