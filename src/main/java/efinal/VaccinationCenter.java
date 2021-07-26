package efinal;

import java.util.HashMap;
import java.util.Map;

public class VaccinationCenter {
    private Map<String,Citizen> citizens = new HashMap<>();
    private String centerName;

    public VaccinationCenter(String name){
        this.centerName=name;
    }

    public int getVaccinationAdvance(){
        int vaccinatedCitizens = 0;
        for(Map.Entry<String, Citizen> person : citizens.entrySet()){
            vaccinatedCitizens += person.getValue().getAppliedDoses();
        }
        return vaccinatedCitizens;
    }

    public int getCompleteVaccinationCitizen(){
        int vaccinatedCitizens = 0;
        for(Map.Entry<String, Citizen> person : citizens.entrySet()){
            vaccinatedCitizens += (person.getValue().getAppliedDoses()>1)?1:0;
        }
        return vaccinatedCitizens;
    }

    public int getPartialVaccinationCitizen(){
        int vaccinatedCitizens = 0;
        for(Map.Entry<String, Citizen> person : citizens.entrySet()){
            vaccinatedCitizens +=(person.getValue().getAppliedDoses()<2)?1:0;
        }
        return vaccinatedCitizens;
    }

    public void setSecondDose(String citizen){
        citizens.get(citizen).applyDoses();
    }

    public void setFirstDose(Citizen citizen){
        citizens.put(citizen.getDni(),citizen);
    }

}
