package Menus;

import Entities.User;
import Help.HelpProgram;
import Help.Serialization;
import Help.Utils;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class AppStats {

    @SuppressWarnings("unchecked")
    public AppStats(User user) throws IOException, ClassNotFoundException, InterruptedException {
        //IR BUSCAR AS FUNÇÕES
        HelpProgram help = new HelpProgram();
        Scanner scanner = new Scanner(System.in);
        Utils utils = new Utils();


        help.clean();
        utils.print_app_stats();


        Serialization serialize = new Serialization();
        serialize.setFile("users.ser");
        Object obj = serialize.getObject();
        Map<String, User> usersMap = (Map<String, User>) obj;
        System.out.println("Já somos " + usersMap.size() + " utilizadores na POWER PEAK!");
        System.out.println("1 - Go Back  2 - List all " + usersMap.size() + " users");

        //Scan app stats functional purpose/choice
        int option = 0;
        while (option != 1 && option != 2) {
            option = scanner.nextInt();
            scanner.nextLine();
            if (option != 1 && option != 2) System.out.println("Please choose a valid option.");
        }
        if (option == 2) {
             help.clean();
            for (Map.Entry<String, User> entry : usersMap.entrySet()) {
                User user1 = entry.getValue();
                System.out.println("==============");
                System.out.println("User: " + user1.getUserId());
                System.out.println("==============");
            }
        }

        int option2 = 0;
        while (option2 != 1 && option2 != 2) {
            option2 = scanner.nextInt();
            scanner.nextLine();
            if (option2 != 1 && option2 != 2) System.out.println("Please choose a valid option.");
        }
        new AppManipulation(user);
    }
}
