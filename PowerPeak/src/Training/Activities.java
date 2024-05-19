package Training;

import Entities.Exercise;
import Entities.User;
import Help.Serialization;
import Help.Utils;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Activities {

    @SuppressWarnings("unchecked")
    public Exercise activitiesExercises(User user) throws IOException, ClassNotFoundException {

        //IR BUSCAR AS FUNÇÕES
        Scanner scanner = new Scanner(System.in);
        Utils utils = new Utils();
        Serialization serialize = new Serialization();
        serialize.setFile("exercises.ser");
        Exercise chosenex;
        utils.type_cardio();

        int option = 0;
        while(option<1 || option>3) {
            option = scanner.nextInt();
            scanner.nextLine();
            if (option < 1 || option>3) utils.choose_valid();
        }

        //help.clean();
        Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) serialize.getObject();

        if(option == 1){//DISTANCE & ALTIMETRY/////////////////////////////////////////////////////////////////////////
            utils.distance_and_altimetry(exercisesMap);
            int optionn = 0;
            while(exercisesMap.get(optionn) == null) {
                optionn = scanner.nextInt();
                scanner.nextLine();
                if (exercisesMap.get(optionn) == null) utils.choose_valid();
            }

            chosenex = exercisesMap.get(optionn);
        }
        else if(option == 2){//Distance////////////////////////////////////////////////////////////////
            utils.distance(exercisesMap);
            int optios = 0;
            while(exercisesMap.get(optios) == null) {
                optios = scanner.nextInt();
                scanner.nextLine();
                if (exercisesMap.get(optios) == null) utils.choose_valid();
            }

            chosenex = exercisesMap.get(optios);
        }
        else {//Cardio////////////////////////////////////////////////////////////////////
            utils.cardio(exercisesMap);
            int options = 0;
            while(exercisesMap.get(options) == null) {
                options = scanner.nextInt();
                scanner.nextLine();
                if (exercisesMap.get(options) == null) utils.choose_valid();
            }

            chosenex = exercisesMap.get(options);
        }

        //GO BACK///////////////////////////////////////////////////////////////////////////////////////
        System.out.println("1 - Continue");
        int goback = 0;
        while(goback != 1) {
            goback = scanner.nextInt();
            if (goback != 1) utils.choose_valid();
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////
        return chosenex;
    }
}
