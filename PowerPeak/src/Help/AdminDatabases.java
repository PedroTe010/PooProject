package Help;

import Entities.*;
import Menus.AppManipulation;

import java.io.EOFException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminDatabases {

    @SuppressWarnings("unchecked")
    public AdminDatabases(User user) throws IOException, ClassNotFoundException, InterruptedException {
        //IR BUSCAR AS FUNÇÕES
        HelpProgram help = new HelpProgram();
        Scanner scanner = new Scanner(System.in);
        Utils utils = new Utils();
        Serialization serializeusers = new Serialization();
        Serialization serializeexercises = new Serialization();
        serializeusers.setFile("users.ser");
        serializeexercises.setFile("exercises.ser");

        help.clean();

        utils.print_app_AdminExercises();

        //Scan app manipulation functional purpose/choice
        int option = 0;
        while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6) {
            option = scanner.nextInt();
            scanner.nextLine();
            if (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6) utils.choose_valid();
        }

        help.clean();
        if (option == 1) {
            System.out.println("================================================================");
            System.out.println("Add Exercise");
            System.out.println("================================================================");
            System.out.println("Step 1 - Type:");
            System.out.println("1 - Hypertrophy    2 - Repetitions    3 - Distance and Altimetry");
            System.out.println("4 - Distance       5 - Cardio");
            System.out.println("================================================================");
            int chosen = 0;
            while (chosen != 1 && chosen != 2 && chosen != 3 && chosen != 4 && chosen != 5) {
                chosen = scanner.nextInt();
                scanner.nextLine();
                if (chosen != 1 && chosen != 2 && chosen != 3 && chosen != 4 && chosen != 5) utils.choose_valid();
            }
            Exercise newexercise = Exercise.allocateExercise(chosen);
            help.clean();
            if (chosen == 1) {
                System.out.println("================================================================");
                System.out.print("Muscle of purpose: ");
                newexercise.setMuscle(newexercise, scanner.nextLine());
                System.out.println("================================================================");
            }
            help.clean();
            System.out.println("================================================================");
            System.out.print("Step 2 - Id: ");
            String bug = scanner.nextLine();
            int id = Integer.parseInt(bug);
            newexercise.setId(id);
            System.out.print("Step 3 - Name: ");
            newexercise.setName(scanner.nextLine());
            System.out.print("Step 4 - Material needed: ");
            newexercise.setMaterial(scanner.nextLine());
            System.out.print("Step 5 - Description: ");
            newexercise.setDescription(scanner.nextLine());
            System.out.println("Step 6 - Is it hard? y/n");
            String answer = "";
            while (!(answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N"))) {
                answer = scanner.nextLine();
                if (answer.equals("y") || answer.equals("Y")) {
                    newexercise.setHard(true);
                } else if (answer.equals("n") || answer.equals("N")) {
                    newexercise.setHard(false);
                } else utils.choose_valid();
            }
            System.out.println("================================================================");


            try {
                Object obj = serializeexercises.getObject();
                if (obj instanceof Map) {
                    Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) obj;
                    exercisesMap.put(newexercise.getId(), newexercise);
                    serializeexercises.writeObject(exercisesMap);
                }
            } catch (EOFException e) {
                // Handle empty file
                Map<Integer, Exercise> exercisesMap = new HashMap<>();
                exercisesMap.put(newexercise.getId(), newexercise);
                try {
                    serializeexercises.writeObject(exercisesMap);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if (option == 2){
            try {
                Object obj = serializeexercises.getObject();
                if (obj instanceof Map) {
                    Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) obj;
                    System.out.print("Insert the \"id\" of the exercise you want to delete: ");
                    exercisesMap.remove(scanner.nextInt());
                    serializeexercises.writeObject(exercisesMap);
                    System.out.println("Exercise was deleted");
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("1 - Go Back");
            int choice = 0;
            while (choice != 1) {
                choice = scanner.nextInt();
                if (choice != 1) utils.choose_valid();
            }

        } else if (option == 3) {
            try {
                Object obj = serializeusers.getObject();
                if (obj instanceof Map) {
                    Map<String, User> usersMap = (Map<String, User>) obj;
                    System.out.print("Insert the \"Username\" of the user you want to delete: ");
                    usersMap.remove(scanner.nextLine());
                    serializeusers.writeObject(usersMap);
                    System.out.println("Username deleted.");
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("1 - Go Back");
            int choice = 0;
            while (choice != 1) {
                choice = scanner.nextInt();
                if (choice != 1) utils.choose_valid();
            }

        } else if (option == 4) {
            try {
                Object obj = serializeusers.getObject();
                if (obj instanceof Map) {
                    Map<String, User> usersMap = (Map<String, User>) obj;
                    Map<String, User> newusersMap = new HashMap<>();
                    for (Map.Entry<String, User> entry : usersMap.entrySet()) {

                        User user1 = entry.getValue();
                        Plan trainingPlan = new Plan();
                        UserStats userStats = new UserStats();
                        ArrayList<Historic> historics = new ArrayList<>();
                        user1.setTrainingPlan(trainingPlan);
                        user1.setUserStats(userStats);
                        user1.setHistorics(historics);
                        user1.setDate(LocalDate.now());
                        newusersMap.put(user1.getUserId(), user1);
                    }
                    serializeusers.writeObject(usersMap);
                    System.out.println("All users' journeys were rebooted");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1 - Go Back");
            int choice = 0;
            while (choice != 1) {
                choice = scanner.nextInt();
                if (choice != 1) utils.choose_valid();
            }
        } else if (option == 5) {
            try {
                Object obj = serializeexercises.getObject();
                if (obj instanceof Map) {
                    Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) obj;
                    utils.print_list_of_exercises(exercisesMap);
                    System.out.println("1 - Go Back");
                    int choice = 0;
                    while (choice != 1) {
                        choice = scanner.nextInt();
                        if (choice != 1) utils.choose_valid();
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        Map<String, User> usersMap = (Map<String, User>) serializeusers.getObject();
        User newuser = usersMap.get(user.getUserId());
        new AppManipulation(newuser);
    }
}
