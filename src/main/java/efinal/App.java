package efinal;

import java.util.*;
import java.util.logging.Logger;

public class App {

    private static App instance;
    private Map<String,VaccinationCenter> vaccinationCenters = new HashMap<>();
    private Logger logger = Logger.getLogger("logger");
    private static int TOTAL_PERSONAS = 22935533;


    public static App getInstance() {
        if(instance==null){
            instance=new App();
        }
        return instance;
    }
    App(){}

    public void Login(){
        logger.info("Ingresa tu username");
        var username = new Scanner(System.in);

        logger.info("Ingresa tu password");
        var password = new Scanner(System.in);

        var user = new User(username.next(),password.next());
        if(user.isUser()){
            logger.info("Bienvenido\nSelecciona una opcion:\n\t1.Avance de la Vacunación\n\t2.Cobertura de la Vacunación\n\t3.Número de Centros de Vacunación\n\t4.Número de personas vacunadas parcialmente\n\t5.Número de personas vacunadas completamente\n\t6.Dar de baja Centro\n\t7.Dar de alta Centro\n\t8.Cerrar Sesion");
            var option = new Scanner(System.in);
            switch (option.nextInt()){
                case 1:{
                    vaccinationAdvance();
                    break;
                }
                case 2: {
                    vaccinationCoverage();
                    break;
                }
                case 3: {
                    numVaccinationCenters();
                    break;
                }
                case 4: {
                    getPartialVaccinationCitizens();
                    break;
                }
                case 5: {
                    getCompleteVaccinationCitizens();
                    break;
                }
                case 6: {
                    var centro = new Scanner(System.in);
                    deleteCenter(centro.next());
                    break;
                }
                case 7: {
                    var centro = new Scanner(System.in);
                    addCenter(centro.next());
                    break;
                }
                case 8: {
                    break;
                }
                default:{
                    Login();
                }
            }
        }
    }

    public void addCenter(String vaccinationCenter){
        vaccinationCenters.put(vaccinationCenter,new VaccinationCenter(vaccinationCenter));
    }

    public void deleteCenter(String vaccinationCenter){
        vaccinationCenters.remove(vaccinationCenter);
    }

    public void vaccinationAdvance(){
        int doses=0;
        for(Map.Entry<String, VaccinationCenter> center : vaccinationCenters.entrySet()){
            doses += center.getValue().getCompleteVaccinationCitizen() + center.getValue().getPartialVaccinationCitizen();
        }
        var msg = "Porcentaje de personas vacunadas: "+ (doses/TOTAL_PERSONAS)*100;
        logger.info(msg);
    }

    public void vaccinationCoverage(){
        int person=0;
        for(Map.Entry<String, VaccinationCenter> center : vaccinationCenters.entrySet()){
            person += center.getValue().getCompleteVaccinationCitizen();
        }
        var msg = "Porcentaje de personas completamente vacunadas: "+ (person/TOTAL_PERSONAS)*100;
        logger.info(msg);
    }

    public void numVaccinationCenters(){
        var centers= vaccinationCenters.size();
        var msg = "Centros de Vacunacion: "+ centers;
        logger.info(msg);
    }

    public void getCompleteVaccinationCitizens(){
        var person=0;
        for(Map.Entry<String, VaccinationCenter> center : vaccinationCenters.entrySet()){
            person += center.getValue().getCompleteVaccinationCitizen();
        }
        var msg = "Personas completamente vacunadas: "+ person;
        logger.info(msg);
    }

    public void getPartialVaccinationCitizens(){
        var person=0;
        for(Map.Entry<String, VaccinationCenter> center : vaccinationCenters.entrySet()){
            person += center.getValue().getPartialVaccinationCitizen();
        }
        var msg = "Personas parcialmente vacunadas: "+ person;
        logger.info(msg);
    }

}
