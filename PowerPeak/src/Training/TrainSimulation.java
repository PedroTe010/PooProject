package Training;

import Entities.*;
import Help.HelpProgram;
import Help.Serialization;
import Help.Utils;
import Menus.AppInterface;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class TrainSimulation {

    @SuppressWarnings("unchecked")
    public void trainSimulator(User user) throws IOException, ClassNotFoundException, InterruptedException {

        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        HelpProgram help = new HelpProgram();
        int choice = 0;
        Historic userHistory = new Historic();
        Serialization ser = new Serialization();
        ser.setFile("users.ser");
        Map<String, User> usersMap = (Map<String, User>) ser.getObject();
        Exercise chosenex;
        Utils utils = new Utils();
        UserStats userStats = user.getUserStats();
        int user_heart_rate = Integer.parseInt(user.getAverageHeartRate());


        System.out.println("===================================================================");
        System.out.println("Choose what you are going to do:");
        System.out.println("1 - Training Plan");
        System.out.println("2 - Singular Training");
        System.out.println("3 - Go back");
        System.out.println("===================================================================");
        while (choice != 1 && choice != 2 && choice != 3) {
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice != 1 && choice != 2 && choice != 3) System.out.println("Please choose a valid option.");
        }

        if (choice == 1) {

            if (user.getTrainingPlan().planExists()) {
                System.out.print("Days to advance: ");
                int time_advance = 0;
                while (time_advance < 1) {
                    time_advance = scanner.nextInt();
                    scanner.nextLine();
                }

                Plan training_plan = user.getTrainingPlan();
                int[] days;
                days = training_plan.getDays();

                //PARA CADA DIA
                for (int i = 1; i <= time_advance; i++) {

                    Historic newHistoric = new Historic();
                    LocalDate date = user.getDate().plusDays(i);
                    int day_of_the_week = help.dayWeek(date);

                    int calories_total = 0;

                    if (help.isNumberInArray(days, day_of_the_week)) {

                        PlanofDay plan_of_day = training_plan.getPlanofDay(day_of_the_week);
                        ArrayList<Exercise> exercises = plan_of_day.getExercises();

                        //VAI EXERCICIO A EXERCICIO PREENCHER TODOS OS ARRAYS
                        for (int z = 0; z < exercises.size(); z++) {
                            int exercise_minutes = rand.nextInt(29) + 5;
                            int reps = rand.nextInt(36) + 8;
                            Exercise exercise_of = exercises.get(z);
                            if (exercise_of instanceof Hypertrophy) {
                                int heartrate = rand.nextInt(5) + Integer.parseInt(user.getAverageHeartRate());
                                int calories_spent_doing = exercise_of.calories_spent(user, exercise_minutes, heartrate);
                                newHistoric.setInfoAboutExercise(exercise_of, reps, exercise_minutes, 0, 0, calories_spent_doing, heartrate);
                                calories_total += calories_spent_doing;
                            } else if (exercise_of instanceof Distance) {
                                int heartrate = rand.nextInt(10) + Integer.parseInt(user.getAverageHeartRate());
                                int calories_spent_doing = exercise_of.calories_spent(user, exercise_minutes, heartrate);
                                int km_distance = rand.nextInt(10) + 3;
                                newHistoric.setInfoAboutExercise(exercise_of, 0, exercise_minutes, km_distance, 0, calories_spent_doing, heartrate);
                                userStats.setKms_runned(km_distance);
                                userStats.setSession_km_record(km_distance);
                                calories_total += calories_spent_doing;
                            } else if (exercise_of instanceof DistanceAndAltimetry) {
                                int heartrate = rand.nextInt(12) + Integer.parseInt(user.getAverageHeartRate());
                                int calories_spent_doing = exercise_of.calories_spent(user, exercise_minutes, heartrate);
                                int km_altimetry = rand.nextInt(8) + 2;
                                newHistoric.setInfoAboutExercise(exercise_of, 0, exercise_minutes, 0, km_altimetry, calories_spent_doing, heartrate);
                                userStats.setAltimetry_meters(km_altimetry);
                                userStats.setSession_altimetry_record(km_altimetry);
                                calories_total += calories_spent_doing;
                            } else if (exercise_of instanceof Cardio) {
                                int heartrate = rand.nextInt(20) + Integer.parseInt(user.getAverageHeartRate());
                                int calories_spent_doing = exercise_of.calories_spent(user, exercise_minutes, heartrate);
                                newHistoric.setInfoAboutExercise(exercise_of, 0, exercise_minutes, 0, 0, calories_spent_doing, heartrate);
                                calories_total += calories_spent_doing;
                            } else {
                                int heartrate = rand.nextInt(20) + Integer.parseInt(user.getAverageHeartRate());
                                int calories_spent_doing = exercise_of.calories_spent(user, exercise_minutes, heartrate);
                                newHistoric.setInfoAboutExercise(exercise_of, 0, exercise_minutes, 0, 0, calories_spent_doing, heartrate);
                                calories_total += calories_spent_doing;
                            }
                        }
                        //AQUI FICA PREENCHIDO O ARRAY PARA UM DIA

                        newHistoric.setCalories_total(calories_total);
                        userStats.setCalories_burnt(calories_total);
                        userStats.setSession_calories_record(calories_total);
                        newHistoric.setDate(date);

                        user.setHistoricsLine(newHistoric);
                        user.setUserStats(userStats);
                    }
                }

                user.setDate(user.getDate().plusDays(time_advance));


                Map<String, User> newUsersMap = new HashMap<>();
                newUsersMap.put(user.getUserId(), user);

                for (Map.Entry<String, User> entry : usersMap.entrySet()) {
                    User usersimul = entry.getValue();
                    if (!(usersimul.getUserId().equals(user.getUserId()))) {
                        SimulateAll(usersimul, time_advance);
                        newUsersMap.put(usersimul.getUserId(), usersimul);
                    }
                }

                ser.writeObject(newUsersMap);
                help.clean();
                for(int j=0; j<5; j++) {
                    System.out.println("⠀⠀⠀           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⡶⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⠄⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣴⣶⣿⣿⣿⣿⣿⣿⣿⣯⡄⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⠋⠉⠉⢹⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⡀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⠟⠀⣠⢞⣠⠴⡀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣿⣿⣷⣿⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣻⣿⠀⢰⣿⣿⣿⣿⣿⣿⠟⠻⠟⠛⠛⠛⠓⠁⠀⠀⠀⠀     WORKING OUT\n" +
                            "          ⠀⠀⠀⠀⠀⠀⠀⢀⣶⣿⢿⣤⣾⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "       ⠀⠀ ⠀⠀⠀⠀⠀⠀⠐⠿⠟⠁⢸⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⠏⠈⠉⠙⠻⣿⣿⣿⣿⡷⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣼⣿⣿⣿⣿⡟⠃⠀⠀⠀⠀⠀⠀⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⢀⡀⠀⠀⠀⠀⠀⣀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⢸⣿⣿⣷⣶⣾⣿⣿⣿⣿⣿⠿⠿⠟⠛⠛⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⣾⣿⣿⣿⣿⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⡄⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⣿⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣷⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣶⣦⣤⣾⡿\n" +
                            "⠀⠀⠻⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⡿⠿⠋⠁\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⠿⠛⠉⠀⠀⠀⠀⠀⠀⠀");
                    Thread.sleep(300);
                    help.clean();
                    System.out.println("⠀⠀          ⢀⣠⣤⣤⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣯⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠛⢿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀                    WORKING OUT\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⡟⠿⠿⠇⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣤⣤⣤⣀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣯⠈⠉⠉⠙⠻⠿⣿⡟⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣽⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⢰⣶⣶⣦⣤⣤⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⠿⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⣿⣿⣿⣿⠿⠏⠉⠁⠈⢉⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⣿⣿⡿⠋⠁⠀⠀⠀⢠⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⢻⣿⡃⠀⠀⠀⠀⠀⣾⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠉⠁⠀⠀⠀⠀⣼⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⣀⣾⣿⣿⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣦⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠈⠛⠛⠛⠻⠿⠿⠿⠟⠁⠀⠀\n");
                    Thread.sleep(300);
                    if (j!=4) help.clean();
                }
                System.out.println("1 - Go back");
                int go = 0;
                while (go != 1) {
                    go = scanner.nextInt();
                    scanner.nextLine();
                    if (go != 1) System.out.println("Please choose a valid option.");
                }
                new AppInterface(user);
            } else {
                System.out.println("You don't have a training plan yet.");
                System.out.println("1 - Go back");
                int go = 0;
                while (go != 1) {
                    go = scanner.nextInt();
                    scanner.nextLine();
                    if (go != 1) System.out.println("Please choose a valid option.");
                    new AppInterface(user);
                }
            }
        } else if (choice == 2) {
            StrengthExercises se = new StrengthExercises();
            Activities a = new Activities();
            int total_calories = 0;

            //AQUI PERGUNTA A QUANTIDADE DE EXERCICIOS//////////////////////
            System.out.println("===================================================================");
            System.out.println("How many exercises will you be doing:");
            System.out.println("===================================================================");
            int exercises = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Exercise> theExercises = new ArrayList<Exercise>();
            ////////////////////////////////////////////////////////////////

            //A PARTIR DAQUI PREENCHE SE O ARRAY DE EXS/////////////////////
            for (int i = 0; i < exercises; i++) {
                System.out.println("===================================================================");
                System.out.println("Exercise " + (i + 1) + " ");
                System.out.println("===================================================================");
                utils.choose_strenght_activities();
                int option1 = 0;
                while (option1 != 1 && option1 != 2) {
                    option1 = scanner.nextInt();
                    if (option1 != 1 && option1 != 2) utils.choose_valid();
                }
                help.clean();
                if (option1 == 1) chosenex = se.strengthExercises(user);
                else chosenex = a.activitiesExercises(user);
                if (!help.hasHard(theExercises)) {
                    int hard = 0;
                    System.out.println("===================================================================");
                    System.out.println("Hard version?");
                    System.out.println("1-Yes 2-No");
                    System.out.println("===================================================================");
                    while (hard != 1 && hard != 2) {
                        hard = scanner.nextInt();
                        scanner.nextLine();
                        if (hard != 1 && hard != 2) utils.choose_valid();
                    }
                    if (hard == 1) chosenex.setHard(true);
                }
                //AQUI O EXERCICIO E A SUA QUALIDADE HARD FICOU DEFINIDO////////
                theExercises.add(chosenex);
                ////////////////////////////////////////////////////////////////
                int option = 0;
                System.out.println("===================================================================");
                System.out.println("Exercise duration(min):");
                System.out.println("===================================================================");
                while (option < 1 || option > 60) {
                    option = scanner.nextInt();
                    scanner.nextLine();
                }
                int time = 0;
                time = option;

                if (chosenex instanceof Hypertrophy || chosenex instanceof Repetitions) {

                    int reps = 0;
                    int heartrate = 0;
                    System.out.println("===================================================================");
                    System.out.print("How many reps:");
                    while (reps < 1 || reps > 36) {
                        reps = scanner.nextInt();
                        scanner.nextLine();
                    }
                    System.out.print("Heartrate during the exercise:");
                    while (heartrate < user_heart_rate - 10 || heartrate > user_heart_rate + 20) {
                        heartrate = scanner.nextInt();
                        scanner.nextLine();
                        if (heartrate < user_heart_rate - 10 || heartrate > user_heart_rate + 20) System.out.println("We don't think that was your heartrate. \nTry again please");
                    }
                    System.out.println("===================================================================");

                    int calories_spent_doing = chosenex.calories_spent(user, time, heartrate);
                    userHistory.setInfoAboutExercise(chosenex, reps, time, 0, 0, calories_spent_doing, heartrate);
                    total_calories += calories_spent_doing;

                } else if (chosenex instanceof DistanceAndAltimetry) {

                    int km_altimetry = 0;
                    int heartrate = 0;
                    System.out.println("===================================================================");
                    System.out.print("How many kms you did:");
                    while (km_altimetry < 1) {
                        km_altimetry = scanner.nextInt();
                        scanner.nextLine();
                        userStats.setAltimetry_meters(km_altimetry);
                        userStats.setSession_altimetry_record(km_altimetry);
                    }
                    System.out.println("===================================================================");
                    System.out.print("Heartrate during the exercise:");
                    while (heartrate < user_heart_rate || heartrate > user_heart_rate + 40) {
                        heartrate = scanner.nextInt();
                        scanner.nextLine();
                        if (heartrate < user_heart_rate || heartrate > user_heart_rate + 40) System.out.println("We don't think that was your heartrate. \nTry again please");
                    }
                    System.out.println("===================================================================");

                    int calories_spent_doing = chosenex.calories_spent(user, time, heartrate);
                    userHistory.setInfoAboutExercise(chosenex, 0, time, 0, km_altimetry, calories_spent_doing, heartrate);
                    total_calories += calories_spent_doing;

                } else if (chosenex instanceof Distance) {

                    int km_distance = 0;
                    int heartrate = 0;
                    System.out.println("===================================================================");
                    System.out.print("How many kms you did:");
                    while (km_distance < 1) {
                        km_distance = scanner.nextInt();
                        scanner.nextLine();
                        userStats.setKms_runned(km_distance);
                        userStats.setSession_km_record(km_distance);
                    }
                    System.out.println("===================================================================");
                    System.out.print("Heartrate during the exercise:");
                    while (heartrate < user_heart_rate || heartrate > user_heart_rate + 40) {
                        heartrate = scanner.nextInt();
                        scanner.nextLine();
                        if (heartrate < user_heart_rate || heartrate > user_heart_rate + 40) System.out.println("We don't think that was your heartrate. \nTry again please");
                    }
                    System.out.println("===================================================================");

                    int calories_spent_doing = chosenex.calories_spent(user, time, heartrate);
                    userHistory.setInfoAboutExercise(chosenex, 0, time, km_distance, 0, calories_spent_doing, heartrate);
                    total_calories += calories_spent_doing;

                } else {
                    System.out.println("===================================================================");
                    int heartrate = 0;
                    System.out.print("Heartrate during the exercise:");
                    while (heartrate < user_heart_rate || heartrate > user_heart_rate + 40) {
                        heartrate = scanner.nextInt();
                        scanner.nextLine();
                        if (heartrate < user_heart_rate || heartrate > user_heart_rate + 40) System.out.println("We don't think that was your heartrate. \nTry again please");
                    }
                    System.out.println("===================================================================");
                    int calories_spent_doing = chosenex.calories_spent(user, time, heartrate);
                    userHistory.setInfoAboutExercise(chosenex, 0, time, 0, 0, calories_spent_doing, heartrate);
                    total_calories += calories_spent_doing;
                }
            }

            userHistory.setCalories_total(total_calories);
            userStats.setCalories_burnt(total_calories);
            userStats.setSession_calories_record(total_calories);
            userHistory.setDate(user.getDate());

            int time_advance;
            if (help.hasHard(theExercises)) {
                time_advance = 2;
            } else time_advance = 1;

            user.setDate(user.getDate().plusDays(time_advance));

            user.setHistoricsLine(userHistory);
            user.setUserStats(userStats);

            Map<String, User> newUsersMap = new HashMap<>();
            newUsersMap.put(user.getUserId(), user);


            for (Map.Entry<String, User> entry : usersMap.entrySet()) {
                User usersimul = entry.getValue();
                if (!(usersimul.getUserId().equals(user.getUserId()))) {
                    SimulateAll(usersimul, time_advance);
                    newUsersMap.put(usersimul.getUserId(), usersimul);
                }
            }

            ser.writeObject(newUsersMap);

            System.out.println("=======================================================================");
            System.out.println("Congratulations " + user.getUserId() + " you burned some calories :D");
            System.out.println("=======================================================================");

            choice = 0;
            System.out.println("1 - Continue");
            while (choice != 1) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice != 1) utils.choose_valid();
            }
            new AppInterface(user);
        } else {
            new AppInterface(user);
        }
    }


    public void SimulateAll(User user, int time_advance) {
        Random rand = new Random();
        HelpProgram help = new HelpProgram();
        UserStats userStats = user.getUserStats();


        if (user.getTrainingPlan().planExists()) {
            Plan training_plan = user.getTrainingPlan();
            int[] days;
            days = training_plan.getDays();

            //PARA CADA DIA
            for (int i = 1; i <= time_advance; i++) {

                Historic newHistoric = new Historic();
                LocalDate date = user.getDate().plusDays(i);
                int day_of_the_week = help.dayWeek(date);

                int calories_total = 0;

                if (help.isNumberInArray(days, day_of_the_week)) {

                    PlanofDay plan_of_day = training_plan.getPlanofDay(day_of_the_week);
                    ArrayList<Exercise> exercises = plan_of_day.getExercises();

                    //VAI EXERCICIO A EXERCICIO PREENCHER TODOS OS ARRAYS
                    for (int z = 0; z < exercises.size(); z++) {
                        int exercise_minutes = rand.nextInt(29) + 5;
                        int reps = rand.nextInt(36) + 8;
                        Exercise exercise_of = exercises.get(z);
                        if (exercise_of instanceof Hypertrophy) {
                            int heartrate = rand.nextInt(5) + Integer.parseInt(user.getAverageHeartRate());
                            int calories_spent_doing = exercise_of.calories_spent(user, exercise_minutes, heartrate);
                            newHistoric.setInfoAboutExercise(exercise_of, reps, exercise_minutes, 0, 0, calories_spent_doing, heartrate);
                            calories_total += calories_spent_doing;
                        } else if (exercise_of instanceof Distance) {
                            int heartrate = rand.nextInt(10) + Integer.parseInt(user.getAverageHeartRate());
                            int calories_spent_doing = exercise_of.calories_spent(user, exercise_minutes, heartrate);
                            int km_distance = rand.nextInt(10) + 3;
                            newHistoric.setInfoAboutExercise(exercise_of, 0, exercise_minutes, km_distance, 0, calories_spent_doing, heartrate);
                            userStats.setKms_runned(km_distance);
                            userStats.setSession_km_record(km_distance);
                            calories_total += calories_spent_doing;
                        } else if (exercise_of instanceof DistanceAndAltimetry) {
                            int heartrate = rand.nextInt(12) + Integer.parseInt(user.getAverageHeartRate());
                            int calories_spent_doing = exercise_of.calories_spent(user, exercise_minutes, heartrate);
                            int km_altimetry = rand.nextInt(8) + 2;
                            newHistoric.setInfoAboutExercise(exercise_of, 0, exercise_minutes, 0, km_altimetry, calories_spent_doing, heartrate);
                            userStats.setAltimetry_meters(km_altimetry);
                            userStats.setSession_altimetry_record(km_altimetry);
                            calories_total += calories_spent_doing;
                        } else if (exercise_of instanceof Cardio) {
                            int heartrate = rand.nextInt(20) + Integer.parseInt(user.getAverageHeartRate());
                            int calories_spent_doing = exercise_of.calories_spent(user, exercise_minutes, heartrate);
                            newHistoric.setInfoAboutExercise(exercise_of, 0, exercise_minutes, 0, 0, calories_spent_doing, heartrate);
                            calories_total += calories_spent_doing;
                        } else {
                            int heartrate = rand.nextInt(20) + Integer.parseInt(user.getAverageHeartRate());
                            int calories_spent_doing = exercise_of.calories_spent(user, exercise_minutes, heartrate);
                            newHistoric.setInfoAboutExercise(exercise_of, 0, exercise_minutes, 0, 0, calories_spent_doing, heartrate);
                            calories_total += calories_spent_doing;
                        }
                    }
                    //AQUI FICA PREENCHIDO O ARRAY PARA UM DIA

                    newHistoric.setCalories_total(calories_total);
                    userStats.setCalories_burnt(calories_total);
                    userStats.setSession_calories_record(calories_total);
                    newHistoric.setDate(date);

                    user.setHistoricsLine(newHistoric);
                    user.setUserStats(userStats);
                }
            }

            user.setDate(user.getDate().plusDays(time_advance));
        } else user.setDate(user.getDate().plusDays(time_advance));

    }
}

