package org.viarzilin.hospital.model.domain;

import org.viarzilin.hospital.model.domain.enumerated.TypePrescription;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @Column(name = "ID_PRESCRIPTION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME_PRESCRIPTION", nullable = false, length = 20)
    private String namePrescription;

    @Column(name = "TYPE_PRESCRIPTION", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private TypePrescription typePrescription;

    @Column(name = "DESCRIPTION", length = 100)
    private String description;


    /**
    * One_to_many relationship Prescription to Rprescription
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prescription", orphanRemoval = true)
    private List<Rprescription> receptionPrescription;


    /**
     * Getters and Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePrescription() {
        return namePrescription;
    }

    public void setNamePrescription(String namePrescription) {
        this.namePrescription = namePrescription;
    }

    public TypePrescription getTypePrescription() {
        return typePrescription;
    }

    public void setTypePrescription(TypePrescription typePrescription) {
        this.typePrescription = typePrescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Rprescription> getReceptionPrescription() {
        return receptionPrescription;
    }

    public void setReceptionPrescription(List<Rprescription> receptionPrescription) {
        this.receptionPrescription = receptionPrescription;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", namePrescription='" + namePrescription + '\'' +
                ", typePrescription=" + typePrescription +
                ", description='" + description + '\'' +
                '}';
    }
}
