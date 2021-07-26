package efinal;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CitizenTest {

    @Test
    public void applyDoses() {
        var dni = "7414";
        var group = "80-70";
        var citizen = new Citizen(dni,group);
        citizen.applyDoses();
        assertEquals(2, citizen.getAppliedDoses());
        assertEquals(citizen.getDni(),dni);
        citizen.setDateOfVaccination(LocalDate.now());
        assertEquals(LocalDate.now(),citizen.getDateOfVaccination());
    }
}