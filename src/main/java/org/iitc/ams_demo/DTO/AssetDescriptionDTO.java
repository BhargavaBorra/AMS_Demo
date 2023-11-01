package org.iitc.ams_demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AssetDescription")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetDescriptionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AssetDescriptionId;
    private String specifications;
    private String condition;
    @ManyToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "AssetId")
    private AssetDTO asset;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private CategoryDTO category;
}
