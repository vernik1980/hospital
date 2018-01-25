package org.viarzilin.hospital.model.domain;

import org.viarzilin.hospital.model.domain.enumerated.TypePrescription;
import javax.persistence.*;


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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prescriptions", orphanRemoval = true)
     private List<Rprescription> receptionPrescriptions;
     */
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
/**
    public List<Rprescription> getReceptionPrescriptions() {
        return receptionPrescriptions;
    }

    public void setReceptionPrescriptions(List<Rprescription> receptionPrescriptions) {
        this.receptionPrescriptions = receptionPrescriptions;
    }
*/
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