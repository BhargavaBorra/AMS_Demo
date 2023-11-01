package org.iitc.ams_demo.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.iitc.ams_demo.DTO.AssetDTO;
import org.iitc.ams_demo.DTO.VendorDTO;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SupplyID implements Serializable {
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "asset_id", referencedColumnName = "AssetId")
    private AssetDTO asset;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendor_id", referencedColumnName = "VendorId")
    private VendorDTO vendor;
}
