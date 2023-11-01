package org.iitc.ams_demo.DTO;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.iitc.ams_demo.model.SupplyID;

import java.util.Date;


@Entity
@Table(name = "Supply")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SupplyDTO {
    @EmbeddedId
    private SupplyID supplyID;
    private String invoiceNumber;
    private Date purchaseDate;
    private Date supplyDate;
    private String manufactureYear;
}