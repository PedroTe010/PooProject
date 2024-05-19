package Training;

import Entities.Exercise;
import Entities.Plan;
import Entities.PlanofDay;
import Entities.User;
import Help.HelpProgram;
import Help.Serialization;
import Help.Utils;

import java.io.IOException;
import java.util.Scanner;

public class MyTrainingPlan {

    MyTrainingPlan(User user) throws IOException, ClassNotFoundException, InterruptedException {

        //IR BUSCAR AS FUNÇÕES
        Scanner scanner = new Scanner(System.in);

        Plan plan = user.getTrainingPlan();
        Utils utils = new Utils();
        Serialization se = new Serialization();
        HelpProgram help = new HelpProgram();

        help.clean();

        if (plan != null) {
            for (int i=1; i < 8; i++) {
                PlanofDay planofDay = plan.getPlanofDay(i);
                String day;
                if (i == 1) day = "Monday";
                else if (i==2) day = "Tuesday";
                else if (i==3) day = "Wednesday";
                else if (i==4) day = "Thursday";
                else if (i==5) day = "Friday";
                else if (i==6) day = "Saturday";
                else day = "Sunday";

                if (planofDay != null) {
                    System.out.println("==============================================================");
                    System.out.println("Day: " + day);
                    int index = 1;
                    for(Exercise exercise: planofDay.getExercises()) {
                        if (exercise.isHard())System.out.println(index + " | " + exercise.getName() + " ->HARD<-");
                        else System.out.println(index + " | " + exercise.getName());
                        System.out.println("Material: " + exercise.getMaterial());
                        System.out.println("How: " + exercise.getDescription());
                        System.out.println("----------------------------------------------------------");
                        index++;
                    }
                    System.out.println("Let's train");
                    System.out.println("==============================================================");
                } else {
                    System.out.println("==============================================================");
                    System.out.println("Day: " + day);
                    System.out.println("Rest day");
                    System.out.println("==============================================================");
                }
            }
        } else{
            System.out.println("====================================================================");
            System.out.println("There is no training plan.Please try creating one or ask us for one!");
            System.out.println("====================================================================");
        }

        //GO BACK///////////////////////////////////////////////////////////////////////////////////////
        utils.go_back();
        int goback = 0;
        while (goback != 1) {
            goback = scanner.nextInt();
            scanner.nextLine();
            if (goback != 1) utils.choose_valid();
        }
        new TrainingPlanInterface(user);
    }
    }