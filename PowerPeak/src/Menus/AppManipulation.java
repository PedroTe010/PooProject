package Menus;

import Entities.User;
import Help.AdminDatabases;
import Help.HelpProgram;
import Help.Utils;

import java.io.IOException;
import java.util.Scanner;

public class AppManipulation {
    public AppManipulation(User user) throws IOException, ClassNotFoundException, InterruptedException {
        //IR BUSCAR AS FUNÇÕES
        HelpProgram help = new HelpProgram();
        Scanner scanner = new Scanner(System.in);
        Utils utils = new Utils();

        help.clean();

        utils.head_bar(user);
        utils.print_app_manipulation();

        //Scan app manipulation functional purpose/choice
        int option = 0;
        while (option != 1 && option != 2 && option != 3) {
            option = scanner.nextInt();
            scanner.nextLine();
            if (option != 1 && option != 2 && option != 3) utils.choose_valid();
        }

        help.clean();
        if (option == 1) new AdminDatabases(user);
        else if (option == 2) new AppStats(user);
        else new AppInterface(user);
    }

}
