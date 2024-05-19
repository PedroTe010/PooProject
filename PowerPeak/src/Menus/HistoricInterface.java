package Menus;

import Entities.Historic;
import Entities.User;
import Help.Utils;

import java.io.IOException;
import java.util.Scanner;

public class HistoricInterface {

    public HistoricInterface(User user) throws IOException, ClassNotFoundException, InterruptedException {

        Historic line;

        if(user.getHistorics().isEmpty()){
            System.out.println("No active historics");
        }
        else {
            int size = user.getHistorics().size();
            for (int i = 0; i < size; i++) {
                line = user.getHistorics().get(i);
                int num_exercises = line.getExercises().size();
                System.out.println("======================================================");
                System.out.println("Date:" + line.getDate());
                System.out.println("======================================================");
                for (int x = 0; x < num_exercises; x++){
                    if (x != 0) System.out.println("------------------------------------------------------");
                    System.out.println("Exercise " + (x+1) + ": " + line.getExercises().get(x).getName());
                    System.out.println("Number of reps: " + line.getTotal_reps().get(x) + "     Minutes: " + line.getTime().get(x) + "     Distance(km): " + line.getKms_only_distance().get(x));
                    System.out.println("Altimetry(km): " + line.getKms_altimetry().get(x) + "     Calories: " + line.getCalories().get(x) + "     Heart Rate: " + line.getHeart_rate().get(x));
                }
                System.out.println("------------------------------------------------------");
                System.out.println("Total Calories: " + line.getCalories_total());
                System.out.println("======================================================");
                System.out.println("\n"); //2 "\n"s
            }
        }

        Utils utils = new Utils();
        Scanner scanner = new Scanner(System.in);

        utils.go_back();

        int choice = 0;
        while(choice != 1) {
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice != 1) utils.choose_valid();
        }
        new AppInterface(user);
    }

}
