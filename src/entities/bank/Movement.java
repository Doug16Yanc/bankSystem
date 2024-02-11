package entities.bank;

import enumerations.TypeMovement;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class Movement {
    private UUID idMovement;
    private TypeMovement typeMovement;
    private Date dateMovement;
    private Time timeMovement;
    private Double valueMovement;

    public Movement(UUID idMovement, TypeMovement typeMovement, Date dateMovement, Time timeMovement, Double valueMovement){
        this.idMovement = idMovement;
        this.typeMovement = typeMovement;
        this.dateMovement = dateMovement;
        this.timeMovement = timeMovement;
        this.valueMovement = valueMovement;
    }

    public UUID getIdMovement() {
        return idMovement;
    }
    public void setIdMovement(UUID idMovement) {
        this.idMovement = idMovement;
    }

    public TypeMovement getTypeMovement() {
        return typeMovement;
    }

    public void setTypeMovement(TypeMovement typeMovement) {
        this.typeMovement = typeMovement;
    }
    public Date getDateMovement() {
        return dateMovement;
    }
    public void setDateMovement(Date dateMovement) {
        this.dateMovement = dateMovement;
    }

    public Time getTimeMovement() {
        return timeMovement;
    }

    public void setTimeMovement(Time timeMovement) {
        this.timeMovement = timeMovement;
    }

    public Double getValueMovement() {
        return valueMovement;
    }

    public void setValueMovement(Double valueMovement) {
        this.valueMovement = valueMovement;
    }
}
