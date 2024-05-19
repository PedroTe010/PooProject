package Training;

import Entities.Exercise;
import Entities.Plan;
import Entities.PlanofDay;
import Entities.User;
import Help.HelpProgram;
import Help.Serialization;
import Help.Utils;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class CreateTrainingPlan {

    HelpProgram help = new HelpProgram();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Utils utils = new Utils();
    TrainingPlanSpecific plans = new TrainingPlanSpecific();

    @SuppressWarnings("unchecked")
    void createPlan(User user) throws IOException, ClassNotFoundException, InterruptedException {

        //IR BUSCAR AS FUNÇÕES
        help.clean();
        Plan userplan = new Plan();
        StrengthExercises se = new StrengthExercises();
        Activities a = new Activities();
        Serialization ser = new Serialization();
        ser.setFile("users.ser");
        Map<String, User> usersMap = (Map<String, User>) ser.getObject();

        System.out.println("==============================================================");
        System.out.println("Welcome. How many days a week would you like to train?");
        System.out.println("==============================================================");
        User test = usersMap.get(user.getUserId());
        int number_days = 0;
        while (number_days < 1 || number_days > 7) {
            number_days = scanner.nextInt();
            scanner.nextLine();
            if (number_days < 1 || number_days > 7) System.out.println("Please choose a valid option.");
        }

        int[] days = new int[number_days];

        help.clean();

        System.out.println("==============================================================");
        System.out.println("Please choose the days.");
        System.out.println("==============================================================");
        System.out.println("1 - Monday  2 - Tuesday   3 - Wednesday   4 - Thursday");
        System.out.println("5 - Friday  6 - Saturday  7 - Sunday ");
        System.out.println("==============================================================");

        int c = 0;
        int option;
        while (c < number_days) {
            option = 0;
            while (option < 1 || option > 7 || help.isNumberInArray(days, option)) {
                option = scanner.nextInt();
                scanner.nextLine();
                if (option < 1 || option > 7 || help.isNumberInArray(days, option))
                    System.out.println("Please choose a valid option.");
            }
            days[c] = option;
            c++;
        }

        help.clean();

        for (int i = 0; i < number_days; i++) {
            String day;
            PlanofDay planofDay = new PlanofDay();
            if (days[i] == 1) day = "Monday";
            else if(days[i]==2) day = "Tuesday";
            else if (days[i]==3) day = "Wednesday";
            else if (days[i]==4) day = "Thursday";
            else if (days[i]==5) day = "Friday";
            else if (days[i]==6) day = "Saturday";
            else day = "Sunday";

            System.out.println("==============================================================");
            System.out.println("How many exercises would you like to have on " + day + "?");
            System.out.println("Please choose at least 1 exercises per day");
            System.out.println("==============================================================");
            int number = 0;
            while (number != 1 && number != 2 && number != 3 && number != 4 && number != 5 && number != 6) {
                number = scanner.nextInt();
                if (number != 1 && number != 2 && number != 3 && number != 4 && number != 5 && number != 6) utils.choose_valid();
            }
            help.clean();

            for (int j = 0; j < number; j++) {
                utils.choose_strenght_activities();
                int option1 = 0;
                while(option1 != 1 && option1 != 2) {
                    option1 = scanner.nextInt();
                    if (option1 != 1 && option1 !=2) utils.choose_valid();
                }
                help.clean();

                if (option1 == 1) {
                    Exercise chosenex = se.strengthExercises(user);

                    if(i == 0) {
                        if (!help.hasHard(planofDay.getExercises())) {
                            int hard = 0;
                            System.out.println("==============================================================");
                            System.out.println("Hard version?");
                            System.out.println("1-Yes 2-No");
                            System.out.println("==============================================================");
                            while (hard != 1 && hard != 2) {
                                hard = scanner.nextInt();
                                scanner.nextLine();
                                if (hard != 1 && hard != 2) utils.choose_valid();
                            }
                            if (hard == 1) chosenex.setHard(true);
                        }
                    }
                    else if(days[i] - days[i-1] == 1){
                       if (!help.hasHard(userplan.getPlanofDay(i-1).getExercises())){
                           int hard = 0;
                           System.out.println("==============================================================");
                           System.out.println("Hard version?");
                           System.out.println("1-Yes 2-No");
                           System.out.println("==============================================================");
                           while (hard != 1 && hard != 2) {
                               hard = scanner.nextInt();
                               scanner.nextLine();
                               if (hard != 1 && hard != 2) utils.choose_valid();
                           }
                           if (hard == 1) chosenex.setHard(true);
                       }
                    }
                    else{
                        if (!help.hasHard(planofDay.getExercises())) {
                            int hard = 0;
                            System.out.println("==============================================================");
                            System.out.println("Hard version?");
                            System.out.println("1-Yes 2-No");
                            System.out.println("==============================================================");
                            while (hard != 1 && hard != 2) {
                                hard = scanner.nextInt();
                                scanner.nextLine();
                                if (hard != 1 && hard != 2) utils.choose_valid();
                            }
                            if (hard == 1) chosenex.setHard(true);
                        }
                    }

                    help.clean();
                    planofDay.setExerciseofPlanofDay(chosenex);
                }
                else{
                    Exercise exerciseCardio = a.activitiesExercises(user);
                    help.clean();

                    if(i == 0) {
                        if (!help.hasHard(planofDay.getExercises())) {
                            int hard = 0;
                            System.out.println("==============================================================");
                            System.out.println("Hard version?");
                            System.out.println("1-Yes 2-No");
                            System.out.println("==============================================================");
                            while (hard != 1 && hard != 2) {
                                hard = scanner.nextInt();
                                scanner.nextLine();
                                if (hard != 1 && hard != 2) utils.choose_valid();
                            }
                            if (hard == 1) exerciseCardio.setHard(true);
                        }
                    }
                    else if(days[i] - days[i-1] == 1){
                        if (!help.hasHard(userplan.getPlanofDay(i-1).getExercises())){
                            int hard = 0;
                            System.out.println("==============================================================");
                            System.out.println("Hard version?");
                            System.out.println("1-Yes 2-No");
                            System.out.println("==============================================================");
                            while (hard != 1 && hard != 2) {
                                hard = scanner.nextInt();
                                scanner.nextLine();
                                if (hard != 1 && hard != 2) utils.choose_valid();
                            }
                            if (hard == 1) exerciseCardio.setHard(true);
                        }
                    }
                    else{
                        if (!help.hasHard(planofDay.getExercises())) {
                            int hard = 0;
                            System.out.println("==============================================================");
                            System.out.println("Hard version?");
                            System.out.println("1-Yes 2-No");
                            System.out.println("==============================================================");
                            while (hard != 1 && hard != 2) {
                                hard = scanner.nextInt();
                                scanner.nextLine();
                                if (hard != 1 && hard != 2) utils.choose_valid();
                            }
                            if (hard == 1) exerciseCardio.setHard(true);
                        }
                    }

                    planofDay.setExerciseofPlanofDay(exerciseCardio);
                }
            }
            userplan.setPlanofDay(planofDay, days[i]);
            help.clean();
        }

        userplan.setDays(days);
        userplan.setExistance();
        user.setTrainingPlan(userplan);
        usersMap.remove(user.getUserId());
        usersMap.put(user.getUserId(), user);
        ser.writeObject(usersMap);

        System.out.println("==============================================================");
        System.out.println("Training plan created successfully.You can check it in My Plan");
        System.out.println("==============================================================");

        //GO BACK///////////////////////////////////////////////////////////////////////////////////////
        System.out.println("1- Return");
        int goback = 0;
        while (goback != 1) {
            goback = scanner.nextInt();
            scanner.nextLine();
            if (goback != 1) System.out.println("Please choose a valid option.");
        }
        new TrainingPlanInterface(user);
    }

    @SuppressWarnings("unchecked")
    void getPlan(User user) throws IOException, ClassNotFoundException, InterruptedException {

        //IR BUSCAR AS FUNÇÕES
        help.clean();
        Plan userplan = new Plan();
        StrengthExercises se = new StrengthExercises();
        Activities a = new Activities();
        Serialization ser = new Serialization();
        ser.setFile("users.ser");
        Map<String, User> usersMap = (Map<String, User>) ser.getObject();

        System.out.println("==============================================================");
        System.out.println("Welcome.How many days a week would you like to train?");
        System.out.println("==============================================================");
        User test = usersMap.get(user.getUserId());
        int number_days = 0;
        while (number_days < 1 || number_days > 7) {
            number_days = scanner.nextInt();
            scanner.nextLine();
            if (number_days < 1 || number_days > 7) System.out.println("Please choose a valid option.");
        }

        int[] days = new int[number_days];

        //help.clean();

        System.out.println("Please choose the days.");
        System.out.println("==============================================================");
        System.out.println("1 - Monday  2 - Tuesday   3 - Wednesday   4 - Thursday");
        System.out.println("5 - Friday  6 - Saturday  7 - Sunday ");
        System.out.println("==============================================================");

        int c = 0;
        int option;
        while (c < number_days) {
            option = 0;
            while (option < 1 || option > 7 || help.isNumberInArray(days, option)) {
                option = scanner.nextInt();
                scanner.nextLine();
                if (option < 1 || option > 7 || help.isNumberInArray(days, option))
                    System.out.println("Please choose a valid option.");
            }
            days[c] = option;
            c++;
        }

        System.out.println("What type of plan do you want");
        System.out.println("==============================================================");
        System.out.println("1 - Gain Muscle");
        System.out.println("2 - Lose Weight");
        System.out.println("3 - I want to specify");
        System.out.println("==============================================================");
        int type = 0;
        while (type < 1 || type > 3){
            type = scanner.nextInt();
            scanner.nextLine();
            if (type < 1 || type > 3) System.out.println("Please choose a valid option.");
        }
        if(type == 1){
                switch (number_days) {
                    case 1:
                        userplan.setPlanofDay(plans.pushDay(), days[0]);
                        break;
                    case 2:
                        userplan.setPlanofDay(plans.pushDay(), days[0]);
                        userplan.setPlanofDay(plans.pullDay(), days[1]);
                        break;
                    case 3:
                        userplan.setPlanofDay(plans.pushDay(), days[0]);
                        userplan.setPlanofDay(plans.pullDay(), days[1]);
                        userplan.setPlanofDay(plans.legDay(), days[2]);
                        break;
                    case 4:
                        userplan.setPlanofDay(plans.pushDay(), days[0]);
                        userplan.setPlanofDay(plans.pullDay(), days[1]);
                        userplan.setPlanofDay(plans.legDay(), days[2]);
                        userplan.setPlanofDay(plans.chestDay(), days[3]);
                        break;
                    case 5:
                        userplan.setPlanofDay(plans.pushDay(), days[0]);
                        userplan.setPlanofDay(plans.pullDay(), days[1]);
                        userplan.setPlanofDay(plans.legDay(), days[2]);
                        userplan.setPlanofDay(plans.chestDay(), days[3]);
                        userplan.setPlanofDay(plans.backDay(), days[4]);
                        break;
                    case 6:
                        userplan.setPlanofDay(plans.pushDay(), days[0]);
                        userplan.setPlanofDay(plans.pullDay(), days[1]);
                        userplan.setPlanofDay(plans.legDay(), days[2]);
                        userplan.setPlanofDay(plans.chestDay(), days[3]);
                        userplan.setPlanofDay(plans.backDay(), days[4]);
                        userplan.setPlanofDay(plans.armDay(), days[5]);
                        break;
                    case 7:
                        userplan.setPlanofDay(plans.pushDay(), days[0]);
                        userplan.setPlanofDay(plans.pullDay(), days[1]);
                        userplan.setPlanofDay(plans.legDay(), days[2]);
                        userplan.setPlanofDay(plans.chestDay(), days[3]);
                        userplan.setPlanofDay(plans.backDay(), days[4]);
                        userplan.setPlanofDay(plans.armDay(), days[5]);
                        userplan.setPlanofDay(plans.distanceDay(), days[6]);
                        break;
                }

            userplan.setDays(days);
            userplan.setExistance();
            user.setTrainingPlan(userplan);
            usersMap.remove(user.getUserId());
            usersMap.put(user.getUserId(), user);
            ser.writeObject(usersMap);
        }  else if(type == 2){
            switch (number_days) {
                case 1:
                    userplan.setPlanofDay(plans.distanceDay(), days[0]);
                    break;
                case 2:
                    userplan.setPlanofDay(plans.distanceDay(), days[0]);
                    userplan.setPlanofDay(plans.distance_altimetryDay(), days[1]);
                    break;
                case 3:
                    userplan.setPlanofDay(plans.distanceDay(), days[0]);
                    userplan.setPlanofDay(plans.distance_altimetryDay(), days[1]);
                    userplan.setPlanofDay(plans.cardioDay(), days[2]);
                    break;
                case 4:
                    userplan.setPlanofDay(plans.distanceDay(), days[0]);
                    userplan.setPlanofDay(plans.distance_altimetryDay(), days[1]);
                    userplan.setPlanofDay(plans.cardioDay(), days[2]);
                    userplan.setPlanofDay(plans.distanceDay(), days[3]);
                    break;
                case 5:
                    userplan.setPlanofDay(plans.distanceDay(), days[0]);
                    userplan.setPlanofDay(plans.distance_altimetryDay(), days[1]);
                    userplan.setPlanofDay(plans.cardioDay(), days[2]);
                    userplan.setPlanofDay(plans.distanceDay(), days[3]);
                    userplan.setPlanofDay(plans.distance_altimetryDay(), days[4]);
                    break;
                case 6:
                    userplan.setPlanofDay(plans.distanceDay(), days[0]);
                    userplan.setPlanofDay(plans.distance_altimetryDay(), days[1]);
                    userplan.setPlanofDay(plans.cardioDay(), days[2]);
                    userplan.setPlanofDay(plans.distanceDay(), days[3]);
                    userplan.setPlanofDay(plans.distance_altimetryDay(), days[4]);
                    userplan.setPlanofDay(plans.cardioDay(), days[5]);

                    break;
                case 7:
                    userplan.setPlanofDay(plans.distanceDay(), days[0]);
                    userplan.setPlanofDay(plans.distance_altimetryDay(), days[1]);
                    userplan.setPlanofDay(plans.cardioDay(), days[2]);
                    userplan.setPlanofDay(plans.distanceDay(), days[3]);
                    userplan.setPlanofDay(plans.distance_altimetryDay(), days[4]);
                    userplan.setPlanofDay(plans.cardioDay(), days[5]);
                    userplan.setPlanofDay(plans.distanceDay(), days[6]);
                    break;
            }

            userplan.setDays(days);
            userplan.setExistance();
            user.setTrainingPlan(userplan);
            usersMap.remove(user.getUserId());
            usersMap.put(user.getUserId(), user);
            ser.writeObject(usersMap);
        } else{
            for (int i = 0; i < number_days; i++)
            {
                String day;
                PlanofDay planofDay = new PlanofDay();
                if (days[i] == 1) day = "Monday";
                else if(days[i]==2) day = "Tuesday";
                else if (days[i]==3) day = "Wednesday";
                else if (days[i]==4) day = "Thursday";
                else if (days[i]==5) day = "Friday";
                else if (days[i]==6) day = "Saturday";
                else day = "Sunday";

                System.out.println("==============================================================");
                System.out.println("What kind of plan do you prefer for " + day + "?");
                System.out.println("==============================================================");
                System.out.println("==============================================================");
                System.out.println("1 - Push Day        2 - Pull Day        3 - Leg Day");
                System.out.println("4 - Chest Day       5 - Back Day        6 - Arm Day");
                System.out.println("7 - Distance Day    8 - D&A Day         9 - Cardio Day");
                System.out.println("10 - Abs Day");
                System.out.println("==============================================================");

                int optionY = 0;
                while(optionY < 1 || optionY > 10) {
                    optionY = scanner.nextInt();
                    scanner.nextLine();
                    if (optionY < 1 || optionY > 10) System.out.println("Please choose a valid number.");
                }

                switch (optionY) {
                    case 1:
                        userplan.setPlanofDay(plans.pushDay(), days[i]);
                        break;
                    case 2:
                        userplan.setPlanofDay(plans.pullDay(), days[i]);
                        break;
                    case 3:
                        userplan.setPlanofDay(plans.legDay(), days[i]);
                        break;
                    case 4:
                        userplan.setPlanofDay(plans.chestDay(), days[i]);
                        break;
                    case 5:
                        userplan.setPlanofDay(plans.backDay(), days[i]);
                        break;
                    case 6:
                        userplan.setPlanofDay(plans.armDay(), days[i]);
                        break;
                    case 7:
                        userplan.setPlanofDay(plans.distanceDay(), days[i]);
                        break;
                    case 8:
                        userplan.setPlanofDay(plans.distance_altimetryDay(), days[i]);
                        break;
                    case 9:
                        userplan.setPlanofDay(plans.cardioDay(), days[i]);
                        break;
                    case 10:
                        userplan.setPlanofDay(plans.absDay(), days[i]);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }

            userplan.setDays(days);
            userplan.setExistance();
            user.setTrainingPlan(userplan);
            usersMap.remove(user.getUserId());
            usersMap.put(user.getUserId(), user);
            ser.writeObject(usersMap);
        }



        System.out.println("==============================================================");
        System.out.println("Training plan created successfully.You can check it in My Plan");
        System.out.println("==============================================================");

        //GO BACK///////////////////////////////////////////////////////////////////////////////////////
        System.out.println("1- Return");
        int goback = 0;
        while (goback != 1) {
            goback = scanner.nextInt();
            scanner.nextLine();
            if (goback != 1) System.out.println("Please choose a valid option.");
        }
        new TrainingPlanInterface(user);

    }

}
