package efinal;

import java.time.LocalDate;

public class Citizen {
    private String dni;
    private int appliedDoses;
    private LocalDate dateOfVaccination;

    private String group;


    public Citizen(String dni,String group){
        this.dni = dni;
        this.group=group;
        appliedDoses=1;
        dateOfVaccination = null;
    }

    public void applyDoses(){
        appliedDoses++;
    }

    public int getAppliedDoses() {
        return appliedDoses;
    }

    public String getDni() {
        return dni;
    }

    public void setDateOfVaccination(LocalDate dateOfVaccination) {
        this.dateOfVaccination = dateOfVaccination;
    }

    public LocalDate getDateOfVaccination() {
        return dateOfVaccination;
    }
}
