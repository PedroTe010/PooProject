package Menus;

import Entities.User;
import Help.HelpProgram;
import Help.Serialization;
import Help.Utils;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Profile {

    @SuppressWarnings("unchecked")
    public Profile(User user) throws IOException, ClassNotFoundException, InterruptedException {
        HelpProgram help = new HelpProgram();
        Scanner scanner = new Scanner(System.in);
        Utils utils = new Utils();
        Serialization ser = new Serialization();

        ser.setFile("users.ser");
        utils.profile(user);

        int choice = 0;
        while (choice != 1 && choice != 2 && choice != 3) {
            while (!scanner.hasNextInt()) {
                scanner.next(); // Descarta a entrada não inteira
                utils.choose_valid(); // Solicita novamente uma entrada válida
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha após o número

            if (choice != 1 && choice != 2 && choice != 3) {
                utils.choose_valid(); // Solicita novamente se a opção não está no intervalo permitido
            }
        }

        if(choice == 1) new AppInterface(user);
        else if(choice == 2) {
            utils.my_user_stats(user);
        }
        else {
            Map<String, User> usersMap = (Map<String, User>) ser.getObject();
            int opt = 0;
            while (opt != 1 && opt != 2) {
                System.out.print("Please input your password: ");
                String password = scanner.nextLine();
                if (password.equals(usersMap.get(user.getUserId()).getPassword())) {
                    help.clean();
                    System.out.println("Are you sure you want to delete your account?");
                    System.out.println("1 - Yes 2 - Go Back");
                    opt = scanner.nextInt();
                    if (opt == 1) {
                        usersMap.remove(user.getUserId());
                        ser.writeObject(usersMap);
                        System.out.println("Account deleted. Come back Soon!");
                        Thread.sleep(3000);
                        System.exit(0);
                    } else if (opt == 2) {
                        help.clean();
                        new Profile(user);
                    } else utils.choose_valid();
                } else {
                    System.out.println("Wrong Password");
                    Thread.sleep(1000);
                    help.clean();
                    new Profile(user);
                }
            }
        }
        help.clean();
    }
}
