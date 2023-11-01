package org.iitc.ams_demo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Works")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorksDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long WorksId;
    private String userRole;
    private String project;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "UserId")
    private UserDTO user;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "DepartmentId")
    private DepartmentDTO department;
}
