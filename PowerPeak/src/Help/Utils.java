package Help;

import Entities.*;
import Menus.Profile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class Utils {

    HelpProgram help = new HelpProgram();

    public void print_login_signup() {
        System.out.println("=============================================================================");
        System.out.println("██████   ██████  ██     ██ ███████ ██████     ██████  ███████  █████  ██   ██");
        System.out.println("██   ██ ██    ██ ██     ██ ██      ██   ██    ██   ██ ██      ██   ██ ██  ██");
        System.out.println("██████  ██    ██ ██  █  ██ █████   ██████     ██████  █████   ███████ █████");
        System.out.println("██      ██    ██ ██ ███ ██ ██      ██   ██    ██      ██      ██   ██ ██  ██");
        System.out.println("██       ██████   ███ ███  ███████ ██   ██    ██      ███████ ██   ██ ██   ██");
        System.out.println("=============================================================================");

        System.out.println("Welcome to the program! Please choose one of the next options.\n");
        System.out.println(
                " ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀    ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢤⡖⠺⠉⠓⠢⣄⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀  ⠀     ⠀⠀⠀⢀⣴⢞⣿⣿⣭⣟⣯⣾⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⢸⣅⠉⠀⢻⣦⠀⡀⠘⣆⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀1- Login⠀⠀⠀  ⠀⠀⠀⠀⣸⣟⣿⡿⣿⣿⣿⢟⣿⣿⠟⢿⡀⠀⠀⠀⠀⠀⠀⠀⢟⣿⣾⣿⣿⣿⣇⠀⢡⠘⣆⠀⠀⠀⠀⠀\n" +
                "⠀⠀2- SignUp ⠀⠀  ⠀⠀⠀⣿⣿⣿⣿⣿⣶⣿⣻⡿⠁⠀⠀⢣⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠉⠉⠁⢻⠈⡆⢳⡈⢳⡀⠀⠀⠀\n" +
                "⠀⠀3- Leave⠀  ⠀  ⠀⠀⠸⢿⣿⣿⣿⣿⣽⣿⡏⠀⠐⠾⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠟⢰⡥⠀⢝⣄⠀⠀\n" +
                "⠀⠀         ⠀⠀    ⠀⠀⠈⣿⣿⣿⣷⡘⠃⠀⠀⠀⠀⠙⢁⣱⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢼⢣⠞⣀⢇⠈⠱⠚⣆⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⠀⠀⢰⣿⢿⣻⣿⣿⣿⡅⠀⠀⠀⢦⣬⡇⠀⠀⠀⠀⠀⠀⠀⢠⠚⡏⠉⠑⢺⡄⠀⠀⠙⣧⡀⠇⠀⡇\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⢀⡾⣷⠈⠉⠙⠛⠿⢿⣷⣦⣄⢰⣾⠖⣊⣉⡩⠍⢉⠓⠶⣿⢁⠜⢇⠁⢀⣹⣷⣤⣤⣈⣇⠀⣸⢧\n" +
                "    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⢛⡇⠉⠀⠀⡀⢀⡀⠀⠀⠉⢙⡏⠁⠀⢹⣇⡀⠙⣏⠢⡌⡉⠉⣒⡷⠚⠉⠉⢻⣿⣿⣿⣵⣾⣷⣾\n" +
                "⠀⠀⠀    ⠀⠀⠀⠀⠀⢀⡤⠚⠁⢀⣼⠋⣿⡅⠀⠀⠀⠀⠈⠉⠓⣦⡨⠀⡀⠀⠀⢈⣉⡒⠒⣶⡶⠂⠉⠀⠠⣤⣴⣶⣾⣿⣿⠿⠛⠉⠁\n" +
                "⠀    ⠀⠀⠀⠀⠀⠀⣴⠋⠉⠙⠋⠉⢸⣥⡤⠜⠋⢤⣦⢤⣤⣴⡾⠟⠁⠀⠙⢒⣫⣥⣴⣶⣿⣏⠀⠉⠛⠿⢿⣿⣿⣿⡿⠋⠁⠀⠀⠀⠀\n" +
                "⠀    ⠀⠀⠀⢀⡤⠚⠙⣷⣿⣦⡀⠀⢨⡏⠀⠀⠀⠀⠀⠀⠀⣩⠀⠀⠀⠉⠉⠉⢉⡛⢻⣿⣿⣿⣷⣶⣶⣶⣶⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀    ⠀⠀⣰⠏⢀⠀⠀⣖⠈⠁⠉⠙⢻⣷⣄⣀⣤⣤⡴⠿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀    ⠀⠀⡏⢰⡟⠀⠀⣿⡄⠀⠀⠀⣿⠀⠀⠀⠀⠀⢀⣴⠟⠁⢿⣄⣀⡀⠀⣀⣤⣶⣿⣿⣾⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀    ⠀⣸⠀⢸⡁⠀⠀⠸⣿⣄⠀⡀⣿⠀⠀⡠⣶⡷⠋⡀⠀⠀⠚⠛⠛⠛⠛⠛⠛⠃⠈⠑⡿⢸⣯⡝⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "    ⠀⢠⠇⠀⠘⣿⣦⣤⣤⣿⡟⠛⠓⢿⣞⠻⠟⣔⠲⡇⣀⡀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀⢠⣾⣺⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "    ⠀⢸⠀⠀⠀⣿⣿⠉⠛⠿⢦⣄⡠⠘⡆⣀⣤⠀⠀⠀⢐⣮⠗⠃⠋⠛⠛⠛⠛⠛⢻⣿⡿⡍⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "    ⠀⣼⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠭⠌⣧⢾⣧⣤⣾⣦⠥⢠⣀⣀⢄⣠⣦⣶⣾⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "    ⠀⣿⠀⣀⣴⣿⣿⣿⣿⣦⡂⠀⠀⠀⣾⣙⡇⠀⠀⠀⠀⠀⠀⠁⠀⣡⣿⣿⣿⣿⣯⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "    ⠀⣿⡿⢋⣡⣾⣿⣿⣟⣻⠿⣿⠷⣤⣿⣿⣇⠀⠀⠀⠀⠀⠠⣀⣿⣿⣿⠛⠛⠻⠏⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "    ⢰⡟⣻⣿⣿⣿⣿⣿⣼⡏⠀⠈⠑⢤⣹⡿⣿⣯⠻⢿⣿⣿⣿⣽⠿⢟⣃⣀⣀⡨⣏⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n");
        System.out.println("============================================================= Version 1.2 ===");

    }

    public void print_main_menu(User user) {
        HelpProgram help = new HelpProgram();
        System.out.println("Welcome to the program! Please choose one of the next options.");
        System.out.println("==============================================================");
        System.out.println("1 - Profile");
        System.out.println("2 - Training Plan");
        System.out.println("3 - Training(Time Advance)");
        if (help.isAdmin(user)) {
            System.out.println("4 - App Manipulation");
            System.out.println("5 - Historic");
            System.out.println("6 - Logout");
        } else {
            System.out.println("4 - Historic");
            System.out.println("5 - Logout");
        }
        System.out.println("==============================================================");
    }

    public void print_app_manipulation() {
        System.out.println("Welcome again admin!");
        System.out.println("==============================================================");
        System.out.println("1 - Manipulate app databases");
        System.out.println("2 - App stats");
        System.out.println("3 - Go Back");
        System.out.println("==============================================================");
    }

    public void print_app_AdminExercises() {
        System.out.println("==============================================================");
        System.out.println("Welcome again admin!");
        System.out.println("==============================================================");
        System.out.println("1 - Add an exercise");
        System.out.println("2 - Delete an exercise");
        System.out.println("3 - Delete an user");
        System.out.println("4 - Reset all the users journey");
        System.out.println("5 - List all the exercises");
        System.out.println("6 - Go back");
        System.out.println("==============================================================");
    }

    public void print_list_of_exercises(Map<Integer, Exercise> exerciseMap) {
        for (Map.Entry<Integer, Exercise> entry : exerciseMap.entrySet()) {
            int exerciseID = entry.getKey();
            Exercise exercise = entry.getValue();
            System.out.println("========================================================================================");
            System.out.println("ID: " + entry.getKey());
            System.out.println("Name: " + entry.getValue().getName() + " | Type: " + entry.getValue().getType());
            System.out.println("Muscle: " + entry.getValue().getMuscle(exercise) + " | Material: " + entry.getValue().getMaterial());
            System.out.println("Description: " + entry.getValue().getDescription());
            System.out.println("========================================================================================");
        }
    }

    public void print_app_stats() {
        System.out.println("==============================================================");
        System.out.println("Welcome Admin");
        System.out.println("==============================================================");
    }

    public void print_add_exercise() {
        System.out.println("Add an exercise");
    }

    public void head_bar(User user) {
        System.out.println("==============================================================");
        System.out.println(user.getUserId() + " | " + user.getDate());
        System.out.println("==============================================================");
    }

    public void profile(User user) {
        System.out.println("==============================================================");
        System.out.println("PROFILE");
        System.out.println("==============================================================");
        System.out.println("Informations:");
        System.out.println("==============================================================");
        System.out.println("Username:" + user.getUserId());
        System.out.println("Full Name:" + user.getName());
        System.out.println("Address:" + user.getAddress());
        System.out.println("Email:" + user.getEmail());
        System.out.println("HeartRate:" + user.getAverageHeartRate());
        System.out.println("User Level:" + user.getGym_level());
        System.out.println("==============================================================");
        System.out.println("1-Return | 2-My Stats | 3-Delete Profile");
        System.out.println("==============================================================");
    }

    public void my_user_stats(User user) throws IOException, ClassNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Utils utils = new Utils();
        UserStats stats = user.getUserStats();
        help.clean();
        System.out.println("==============================================================");
        System.out.println("PROFILE");
        System.out.println("==============================================================");
        System.out.println("Informations:");
        System.out.println("==============================================================");
        System.out.println("Calories burned all time:" + stats.getCalories_burnt());
        System.out.println("(Distance)Km runned all time:" + stats.getKms_runned());
        System.out.println("(Distance & Altimetry)Km runned all time:" + stats.getAltimetry_meters());
        System.out.println("Most calories burned in one session:" + stats.getSession_calories_record());
        System.out.println("Most (Distance)km in one session:" + stats.getSession_km_record());
        System.out.println("Most (Distance & Altimetry)km in one session:" + stats.getSession_altimetry_record());
        System.out.println("==============================================================");
        System.out.println("1-Return   2-Leaderboard");
        System.out.println("==============================================================");
        int choice = 0;
        while (choice != 1 && choice != 2) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha após o número

                if (choice != 1 && choice != 2) {
                    choose_valid(); // Exibe a mensagem para escolher uma opção válida
                }
                if (choice == 1) {
                    help.clean();
                    new Profile(user);
                } else {
                    help.clean();
                    utils.leaderboard(user);
                }
        }
    }

    @SuppressWarnings("unchecked")
    public void leaderboard(User user) throws IOException, ClassNotFoundException, InterruptedException {
        Serialization serialize = new Serialization();
        serialize.setFile("users.ser");
        Map<String, User> usersMap = (Map<String, User>) serialize.getObject();
        Scanner scanner = new Scanner(System.in);
        int most_calories = 0;
        int most_distance = 0;
        int most_altimetry = 0;

        User userC = null;
        User userD = null;
        User userA = null;
        for (Map.Entry<String, User> entry : usersMap.entrySet()) {
            User user1 = entry.getValue();
            if (user1.getUserStats().getSession_calories_record() >= most_calories) {
                most_calories = user1.getUserStats().getSession_calories_record();
                userC = user1;
            }
            if (user1.getUserStats().getSession_km_record() >= most_distance) {
                most_distance = user1.getUserStats().getSession_km_record();
                userD = user1;
            }
            if (user1.getUserStats().getSession_altimetry_record() >= most_altimetry) {
                most_altimetry = user1.getUserStats().getSession_altimetry_record();
                userA = user1;
            }
        }
        System.out.println("====================================================================");
        System.out.println(" USER THAT HAVE PEAKED THE MOST IN TERMS OF LOSING CALORIES");
        System.out.println("====================================================================");
        System.out.println(userC.getUserId());
        System.out.println("====================================================================");
        System.out.println("Calories burned all time:" + userC.getUserStats().getCalories_burnt());
        System.out.println("Most calories burned in one session:" + userC.getUserStats().getSession_calories_record());
        System.out.println("====================================================================\n\n");

        System.out.println("====================================================================");
        System.out.println(" USER THAT HAVE PEAKED THE MOST IN TERMS OF DISTANCE");
        System.out.println("====================================================================");
        System.out.println(userD.getUserId());
        System.out.println("====================================================================");
        System.out.println("(Distance)Km runned all time:" + userD.getUserStats().getKms_runned());
        System.out.println("Most (Distance)km in one session:"  + userD.getUserStats().getSession_km_record());
        System.out.println("====================================================================\n\n");

        System.out.println("====================================================================");
        System.out.println(" USER THAT HAVE PEAKED THE MOST IN TERMS OF DISTANCE AND ALTIMETRY");
        System.out.println("====================================================================");
        System.out.println(userA.getUserId());
        System.out.println("====================================================================");
        System.out.println("(Distance & Altimetry)Km runned all time:" + userA.getUserStats().getAltimetry_meters());
        System.out.println("Most (Distance & Altimetry)km in one session:"+ userA.getUserStats().getSession_altimetry_record());
        System.out.println("====================================================================\n");
        System.out.println("====================================================================");
        System.out.println("1-Return");
        System.out.println("====================================================================");

        int choice = 0;
        while (choice != 1) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha após o número

                if (choice != 1) {
                    choose_valid(); // Exibe a mensagem para escolher uma opção válida
                } else {
                    help.clean();
                    new Profile(user);
                }
        }
    }



    ////////////////////////////////Help.LoginRegister//////////////////////////////////////////

    public void ask_username() {
        System.out.println("Welcome to the Login");
        System.out.println("==============================================================");
        System.out.print("Please input your username:");
    }

    public void ask_password() {
        System.out.print("Password:");
    }

    public void user_notfound() {
        System.out.println("User Not Found.Choose:");
    }

    public void password_wrong() {
        System.out.println("Password Incorrect.Choose:");
    }

    public void try_again() {
        System.out.println("==============================================================");
        System.out.println("1-Try Again 2-SignUp 3-Leave");
        System.out.println("==============================================================");
    }

    public void welcome_username() {
        System.out.println("Welcome to the SignUp");
        System.out.println("==============================================================");
        System.out.print("Step 1 - Username:");
    }

    public void get_password() {
        System.out.println("Welcome to the SignUp");
        System.out.println("==============================================================");
        System.out.print("Step 2 - Password:");
    }

    public void get_fullname() {
        System.out.println("Welcome to the SignUp");
        System.out.println("==============================================================");
        System.out.print("Step 3 - Full Name:");
    }

    public void get_adress() {
        System.out.println("Welcome to the SignUp");
        System.out.println("==============================================================");
        System.out.print("Step 4 - Address:");
    }

    public void get_email() {
        System.out.println("Welcome to the SignUp");
        System.out.println("==============================================================");
        System.out.print("Step 5 - Email:");
    }

    public void get_Heartrate() {
        System.out.println("Welcome to the SignUp");
        System.out.println("==============================================================");
        System.out.print("Step 6 - HeartRate(Please note it must be a number):");
    }

    public void get_weight() {
        System.out.println("Welcome to the SignUp");
        System.out.println("==============================================================");
        System.out.print("Step 7 - Weight:");
    }

    public void exercice_level() {
        System.out.println("Welcome to the SignUp");
        System.out.println("==============================================================");
        System.out.println("Step 8 -");
        System.out.println("Indicate your exercise level:");
        System.out.println("==============================================================");
        System.out.println("1-Occasional Exercise");
        System.out.println("2-Amateur");
        System.out.println("3-Professional");
        System.out.println("==============================================================");
    }

    public void data_confirmation(String[] values) {
        System.out.println("==============================================================");
        System.out.println("Confirm your informations:");
        System.out.println("==============================================================");
        System.out.println("Username:" + values[0]);
        System.out.println("Password:" + values[1]);
        System.out.println("Full Name:" + values[2]);
        System.out.println("Address:" + values[3]);
        System.out.println("Email:" + values[4]);
        System.out.println("HeartRate:" + values[5]);
        System.out.println("Weight:" + values[6]);
        System.out.println("User level:" + values[7]);
        System.out.println("==============================================================");
        System.out.println("1-Ok 2-Restart");
        System.out.println("==============================================================");
    }

    public void singup_login() {
        System.out.println("SignUp Successful.Login?");
        System.out.println("==============================================================");
        System.out.println("1-Yes 2-No");
        System.out.println("==============================================================");
    }

    /////////////////////////////////// Uteis ////////////////////////////////////////////////

    public void choose_valid() {
        System.out.println("Please choose a valid option.");
    }

    public void go_back() {
        System.out.println("1- Go back");
    }

    public void valid_input() {
        System.out.println("Please write a valid input");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    public void type_cardio() {
        System.out.println("==============================================================");
        System.out.println("Type of Exercises");
        System.out.println("==============================================================");
        System.out.println("Please choose a category");
        System.out.println("==============================================================");
        System.out.println("1 - Distance & Altimetry");
        System.out.println("2 - Distance");
        System.out.println("3 - Other Activities");
        System.out.println("==============================================================");
    }

    public void distance_altimetry() {
        System.out.println("====================================================================");
        System.out.println("Exercises");
        System.out.println("====================================================================");
        System.out.println("1 - Running on the road(ID:44)    2 - Trail on the mountain(ID:45");
        System.out.println("3 - Bicycle on the road(ID:46)    4 - Bicycle on the mountain(ID:47)");
        System.out.println("====================================================================");
    }

    public void distance_and_altimetry(Map<Integer, Exercise> exercisesMap) {
        System.out.println("==============================================================");
        System.out.println("Please choose an exercise by inputing its ID");
        System.out.println("==============================================================");
        for (Map.Entry<Integer, Exercise> entry : exercisesMap.entrySet()) {
            Exercise ex = entry.getValue();
            if (ex instanceof DistanceAndAltimetry) {
                System.out.println("ID:" + ex.getId() + " - " + ex.getName());
            }
        }
        System.out.println("==============================================================");
    }

    public void distance(Map<Integer, Exercise> exercisesMap) {
        System.out.println("==============================================================");
        System.out.println("Please choose an exercise by inputing its ID");
        System.out.println("==============================================================");
        for (Map.Entry<Integer, Exercise> entry : exercisesMap.entrySet()) {
            Exercise ex = entry.getValue();
            if (ex instanceof Distance) {
                System.out.println("ID:" + ex.getId() + " - " + ex.getName());
            }
        }
        System.out.println("==============================================================");
    }

    public void cardio(Map<Integer, Exercise> exercisesMap) {
        System.out.println("==============================================================");
        System.out.println("Please choose an exercise by inputing its ID");
        System.out.println("==============================================================");
        for (Map.Entry<Integer, Exercise> entry : exercisesMap.entrySet()) {
            Exercise ex = entry.getValue();
            if (ex instanceof Cardio) {
                System.out.println("ID:" + ex.getId() + " - " + ex.getName());
            }
        }
        System.out.println("==============================================================");
    }

    public void other_cardio_act() {
        System.out.println("==============================================================");
        System.out.println("Exercises");
        System.out.println("==============================================================");
        System.out.println("1 - Running on the Treadmill(ID:51)     2 - Zumba class(ID:52)");
        System.out.println("3 - Jump Rope(ID:53)                    4 - Swimming(ID:54)");
        System.out.println("==============================================================");
    }

    public void choose_strenght_activities() {
        System.out.println("==============================================================");
        System.out.println("List of Exercises and Activities.Please choose one option:");
        System.out.println("==============================================================");
        System.out.println("1 - Hypertrophy Exercises");
        System.out.println("2 - Activities");
        System.out.println("3 - Go Back");
        System.out.println("==============================================================");
    }

    ///////////////////////////////////////Strength Exercises////////////////////////////////////////////
    public void strenght_exercises() {
        System.out.println("==============================================================");
        System.out.println("List of Hypertrophy Exercises");
        System.out.println("==============================================================");
        System.out.println("Please choose a category");
        System.out.println("==============================================================");
        System.out.println("1 - Chest");
        System.out.println("2 - Shoulder");
        System.out.println("3 - Bicep");
        System.out.println("4 - Tricep");
        System.out.println("5 - Leg");
        System.out.println("6 - Back");
        System.out.println("7 - Abs");
        System.out.println("==============================================================");
    }

    public void chest_exercises(Map<Integer, Exercise> exercisesMap) {
        System.out.println("==============================================================");
        System.out.println("Please choose an exercise by inputing its ID");
        System.out.println("==============================================================");
        for (Map.Entry<Integer, Exercise> entry : exercisesMap.entrySet()) {
            Exercise ex = entry.getValue();
            if (ex.getMuscle(ex).equals("Chest")) {
                System.out.println("ID:" + ex.getId() + " - " + ex.getName());
            }
        }
        System.out.println("==============================================================");
    }

    public void strenght_extras(Exercise chosenex) {
        System.out.println("==============================================================");
        System.out.println(chosenex.getName() + " - " + chosenex.getDescription());
        System.out.println("\nYou will need: " + chosenex.getMaterial());
        System.out.println("==============================================================");
    }

    public void shoulders_exercises(Map<Integer, Exercise> exercisesMap) {
        System.out.println("==============================================================");
        System.out.println("Please choose an exercise by inputing its ID");
        System.out.println("==============================================================");
        for (Map.Entry<Integer, Exercise> entry : exercisesMap.entrySet()) {
            Exercise ex = entry.getValue();
            if (ex.getMuscle(ex).equals("Shoulder")) {
                System.out.println("ID:" + ex.getId() + " - " + ex.getName());
            }
        }
        System.out.println("==============================================================");
    }

    public void bicep_exercises(Map<Integer, Exercise> exercisesMap) {
        System.out.println("==============================================================");
        System.out.println("Please choose an exercise by inputing its ID");
        System.out.println("==============================================================");
        for (Map.Entry<Integer, Exercise> entry : exercisesMap.entrySet()) {
            Exercise ex = entry.getValue();
            if (ex.getMuscle(ex).equals("Bicep")) {
                System.out.println("ID:" + ex.getId() + " - " + ex.getName());
            }
        }
        System.out.println("==============================================================");
    }

    public void tricep_exercises(Map<Integer, Exercise> exercisesMap) {
        System.out.println("==============================================================");
        System.out.println("Please choose an exercise by inputing its ID");
        System.out.println("==============================================================");
        for (Map.Entry<Integer, Exercise> entry : exercisesMap.entrySet()) {
            Exercise ex = entry.getValue();
            if (ex.getMuscle(ex).equals("Tricep")) {
                System.out.println("ID:" + ex.getId() + " - " + ex.getName());
            }
        }
        System.out.println("==============================================================");
    }

    public void legs_exercises(Map<Integer, Exercise> exercisesMap) {
        System.out.println("==============================================================");
        System.out.println("Please choose an exercise by inputing its ID");
        System.out.println("==============================================================");
        for (Map.Entry<Integer, Exercise> entry : exercisesMap.entrySet()) {
            Exercise ex = entry.getValue();
            if (ex.getMuscle(ex).equals("Leg")) {
                System.out.println("ID:" + ex.getId() + " - " + ex.getName());
            }
        }
        System.out.println("==============================================================");
    }

    public void back_exercises(Map<Integer, Exercise> exercisesMap) {
        System.out.println("==============================================================");
        System.out.println("Please choose an exercise by inputing its ID");
        System.out.println("==============================================================");
        for (Map.Entry<Integer, Exercise> entry : exercisesMap.entrySet()) {
            Exercise ex = entry.getValue();
            if (ex.getMuscle(ex).equals("Back")) {
                System.out.println("ID:" + ex.getId() + " - " + ex.getName());
            }
        }
        System.out.println("==============================================================");
    }

    public void abs_exercises(Map<Integer, Exercise> exercisesMap) {
        System.out.println("==============================================================");
        System.out.println("Please choose an exercise by inputing its ID");
        System.out.println("==============================================================");
        for (Map.Entry<Integer, Exercise> entry : exercisesMap.entrySet()) {
            Exercise ex = entry.getValue();
            if (ex.getMuscle(ex).equals("Abs")) {
                System.out.println("ID:" + ex.getId() + " - " + ex.getName());
            }
        }
        System.out.println("==============================================================");
    }

    public void days(int x) {

        switch (x) {
            case 1:
                System.out.println("Monday;");
                break;
            case 2:
                System.out.println("Tuesday;");
                break;
            case 3:
                System.out.println("Wednesday;");
                break;
            case 4:
                System.out.println("Thursday;");
                break;
            case 5:
                System.out.println("Friday;");
                break;
            case 6:
                System.out.println("Saturday;");
                break;
            case 7:
                System.out.println("Sunday;");
                break;
            default:
                System.out.println("Invalid instance");
        }

    }

    public LocalDate getExistingDate(Map<String, User> usersMap) {
        for (Map.Entry<String, User> entry : usersMap.entrySet()) {
            return entry.getValue().getDate();
        }
        return LocalDate.now();
    }
}
