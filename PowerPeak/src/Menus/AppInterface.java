package Menus;

import Entities.User;
import Help.HelpProgram;
import Help.Utils;
import Training.TrainSimulation;
import Training.TrainingPlanInterface;

import java.io.IOException;
import java.util.Scanner;

public class AppInterface {

    public AppInterface(User user) throws IOException, ClassNotFoundException, InterruptedException {

        //IR BUSCAR AS FUNÇÕES
        HelpProgram help = new HelpProgram();
        Scanner scanner = new Scanner(System.in);
        Utils utils = new Utils();
        TrainSimulation train = new TrainSimulation();

        help.clean();

        utils.head_bar(user);
        utils.print_main_menu(user);

        //Scan app functional purpose/choice
        int option = 0;
        if (help.isAdmin(user)) {
            do {
                while (!scanner.hasNextInt()) {
                    scanner.next(); // Descarta a entrada não inteira
                    utils.choose_valid(); // Solicita novamente uma entrada válida
                }
                option = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha após o número

                if (option < 1 || option > 7) {
                    utils.choose_valid(); // Solicita novamente se a opção não está no intervalo permitido
                }
            } while (option < 1 || option > 7);
        } else {
            do {
                while (!scanner.hasNextInt()) {
                    scanner.next(); // Descarta a entrada não inteira
                    utils.choose_valid(); // Solicita novamente uma entrada válida
                }
                option = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha após o número

                if (option < 1 || option > 6) {
                    utils.choose_valid(); // Solicita novamente se a opção não está no intervalo permitido
                }
            } while (option < 1 || option > 6);
        }

        help.clean();

        if (option == 1) {
            new Profile(user);
        } else if (option == 2) {
            new TrainingPlanInterface(user);
        } else if (option == 3) {
            train.trainSimulator(user);
        } else if (option == 4) {
            if (help.isAdmin(user)) {
                new AppManipulation(user);
            } else {
                new HistoricInterface(user);
            }
        } else if (option == 5) {
            if (help.isAdmin(user)) {
                new HistoricInterface(user);
            } else {
                new StartMenu();
            }
        } else {
            new StartMenu();
        }
    }
}
