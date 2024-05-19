package Training;

import Entities.User;
import Help.HelpProgram;
import Help.Utils;
import Menus.AppInterface;

import java.io.IOException;
import java.util.Scanner;

public class TrainingPlanInterface {

    public TrainingPlanInterface(User user) throws IOException, ClassNotFoundException, InterruptedException {

        //IR BUSCAR AS FUNÇÕES
        HelpProgram help = new HelpProgram();
        Scanner scanner = new Scanner(System.in);
        CreateTrainingPlan create = new CreateTrainingPlan();
        Utils utils = new Utils();

        help.clean();

        System.out.println("===================================================================");
        System.out.println("List of Exercises and Training.Activities.Please choose one option:");
        System.out.println("===================================================================");
        System.out.println("1 - Get New Training Plan"); //Receber um plano de treino randomizado
        System.out.println("2 - Create New Training Plan"); //Criar um plano de treino
        System.out.println("3 - My Training Plan"); //Vai receber um plano de treino
        System.out.println("4 - Go Back");
        System.out.println("===================================================================");

        int option = 0;
        while (option < 1 || option > 4) {
            while (!scanner.hasNextInt()) {
                scanner.next(); // Descarta a entrada não inteira
                utils.choose_valid(); // Solicita novamente uma entrada válida
            }
            option = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha após o número

            if (option < 1 || option > 4) {
                utils.choose_valid(); // Exibe a mensagem para escolher uma opção válida
            }
        }


        if (option == 1) create.getPlan(user);
        else if (option == 2) create.createPlan(user);
        else if (option == 3) new MyTrainingPlan(user);
        else new AppInterface(user);

        scanner.close();
    }

}
