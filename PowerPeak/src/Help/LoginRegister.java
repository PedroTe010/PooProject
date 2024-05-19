package Help;

import Entities.User;
import Entities.UserStats;
import Menus.AppInterface;
import Menus.StartMenu;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginRegister {

    HelpProgram help = new HelpProgram();

    @SuppressWarnings("unchecked")
    public void login() throws IOException, ClassNotFoundException, InterruptedException {

        User useratlogin = null; //potential user logging in
        Scanner scanner = new Scanner(System.in);
        int whatsHappening = 5;
        String[] values = new String[7];
        Utils utils = new Utils();

        while (whatsHappening != 1 && whatsHappening != 4) {

            //VARIAVEIS////////////////////////////////////////
            int choiceAgain = 0;
            String user_code;

            int found = 0;
            ////////////////////////////////////////////////////

            //PEDE O USERNAME AO USER///////////////////////////
            utils.ask_username();
            user_code = scanner.nextLine();
            ////////////////////////////////////////////////////
            Serialization serialize = new Serialization(); //Initialize serialization class
            serialize.setFile("users.ser"); //set file name to (de)serialize
            try {
                Object obj = serialize.getObject(); // Read the deserialized object
                // Check if the deserialized object is indeed a Map<String, Entities.User>
                if (obj instanceof Map) {

                    Map<String, User> usersMap = (Map<String, User>) obj;
                    useratlogin = usersMap.get(user_code); //apply the user_code, the key, we received as input to search the user in the hashmap

                    if (useratlogin != null) {
                        found = 1; // user exists
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                // IOException occurred
                e.printStackTrace();
            }
            if (found == 0) {
                whatsHappening = 2;
            } else {
                Console cons = System.console();
                if (cons != null) {
                    char[] passwordChars = cons.readPassword("Password:");
                    String password = new String(passwordChars);
                    if (password.equals(useratlogin.getPassword())) {
                        whatsHappening = 1;
                    } else {
                        whatsHappening = 3;
                    }
                    java.util.Arrays.fill(password.toCharArray(), ' ');
                }
            }

            /////////////////////////////////////////////////////

            //CASO TENHA FALHADO O LOGIN/////////////////////////
            if (whatsHappening == 2 || whatsHappening == 3) {
                help.clean();
                if (whatsHappening == 2) utils.user_notfound();
                else utils.password_wrong();
                utils.try_again();

                do {
                    while (!scanner.hasNextInt()) {
                        scanner.next(); // descarta a entrada incorreta
                        utils.choose_valid();
                    }
                    choiceAgain = scanner.nextInt();
                    scanner.nextLine(); // lê o fim de linha após o número

                    if (choiceAgain != 1 && choiceAgain != 2 && choiceAgain != 3) {
                        utils.choose_valid();
                    }
                } while (choiceAgain != 1 && choiceAgain != 2 && choiceAgain != 3);

                if (choiceAgain == 2) whatsHappening = 4;  // VAI PARA O SIGN UP
                else if (choiceAgain == 3) System.exit(0); // FECHA O PROGRAMA
            }
            help.clean();
            ////////////////////////////////////////////////////////

            //////////////////////////////////////////////////////
        }

        //PARA FINALIZAR O PROCESSO//////////////////////////////
        help.clean();
        if (whatsHappening == 1) new AppInterface(useratlogin);
        else register();
        /////////////////////////////////////////////////////////
        scanner.close();
    }

    @SuppressWarnings("unchecked")
    public void register() throws IOException, ClassNotFoundException, InterruptedException {

        int restart = 1;

        Scanner scanner = new Scanner(System.in);
        String[] values = new String[8];
        Utils utils = new Utils();

        int found = 1;
        User user;

        while (restart == 1) {

            String username = "";
            values[4] = "okolokdas";
            values[5] = "dasd";
            values[6] = "ola";

            utils.welcome_username();
            //username = scanner.nextLine();

            while (found != 0) {

                username = scanner.nextLine();
                help.clean();

                Serialization serialize = new Serialization(); //Initialize serialization class
                serialize.setFile("users.ser"); //set file name to (de)serialize

                try {
                    Object obj = serialize.getObject(); // Read the deserialized object
                    // Check if the deserialized object is indeed a Map<String, Entities.User>
                    if (obj instanceof Map) {

                        Map<String, User> usersMap = (Map<String, User>) obj;
                        user = usersMap.get(username); //apply the user_code, the key, we received as input to search the user in the hashmap

                        if (user == null) found = 0;
                        else {
                            System.out.println("Username already exists.");
                            System.out.print("Step 1 - Username:");
                            }
                    }
                } catch (EOFException e) {
                    found = 0;
                }
            }

            values[0] = username;

            utils.get_password();
            values[1] = scanner.nextLine();
            help.clean();
            utils.get_fullname();
            values[2] = scanner.nextLine();
            help.clean();
            utils.get_adress();
            values[3] = scanner.nextLine();
            help.clean();
            while (!(help.validateEmail(values[4]))) {
                utils.get_email();
                values[4] = scanner.nextLine();
                help.clean();
            }
            while (!(help.isValidNumber(values[5]))) {
                utils.get_Heartrate();
                values[5] = scanner.nextLine();
                help.clean();
            }
            while (!(help.isValidNumber(values[6]))) {
                utils.get_weight();
                values[6] = scanner.nextLine();
                help.clean();
            }
            utils.exercice_level();
            int choice = 0;
            // Loop para garantir que o usuário digite 1, 2 ou 3
            while (choice != 1 && choice != 2 && choice != 3) {
                while (!scanner.hasNextInt()) {
                    utils.valid_input();
                    scanner.next(); // Consumir o valor inválido
                }
                choice = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha após o número
                help.clean();
            }

            // Atribuir o valor ao array com base na escolha
            switch (choice) {
                case 1:
                    values[7] = "Occasional Exercise";
                    break;
                case 2:
                    values[7] = "Amateur";
                    break;
                case 3:
                    values[7] = "Professional";
                    break;
            }

            help.clean();

            //CONFIRMAR INFORMAÇÕES////////////////////////////////////
            help.clean();
            utils.data_confirmation(values);
            int ok = 0;
            while (ok != 1 && ok != 2) {
                while (!scanner.hasNextInt()) {
                    utils.valid_input();
                    scanner.next(); // Consumir a entrada incorreta
                }
                ok = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                help.clean();
            }

            ////////////////////////////////////////////////////////////
            // Entities.User that we're gonna add into the HashMap before serializing
            User novoUser = User.allocateUser(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]);
            UserStats stats = new UserStats();
            stats.UserStatsConstructor();
            novoUser.setUserStats(stats);
            Serialization serialize = new Serialization();
            serialize.setFile("users.ser");
            try {
                Map<String, User> usersMap;
                Object obj = serialize.getObject();
                if (obj instanceof Map) {
                    usersMap = (Map<String, User>) obj;
                } else {
                    usersMap = new HashMap<>();
                }
                novoUser.setDate(utils.getExistingDate(usersMap));
                usersMap.put(novoUser.getUserId(), novoUser);
                serialize.writeObject(usersMap);

            } catch (EOFException e) {
                // Handle empty file
                novoUser.setDate(LocalDate.now());
                Map<String, User> usersMap = new HashMap<>();
                usersMap.put(novoUser.getUserId(), novoUser);

                try {
                    serialize.writeObject(usersMap);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            ///////////////////////////////////////////////////////////

            //PARA FINALIZAR//////////////////////////////////////////
            utils.singup_login(); // Presume-se que essa função prepare o ambiente ou realize operações preliminares de login/cadastro

            int login = 0;
            // Loop até que o usuário insira 1 para login ou 2 para acessar o menu inicial
            while (login != 1 && login != 2) {
                while (!scanner.hasNextInt()) {
                    scanner.next(); // Consumir entrada inválida
                    utils.choose_valid(); // Exibe um alerta se a opção escolhida for inválida
                }
                login = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                if (login != 1 && login != 2) {
                    utils.choose_valid(); // Exibe um alerta se a opção escolhida for inválida
                }
            }

            // Executar ação baseada na escolha do usuário
            if (login == 1) {
                help.clean(); // Limpar buffers ou realizar qualquer limpeza necessária
                login(); // Executa o método de login
            } else {
                help.clean(); // Limpar buffers ou realizar qualquer limpeza necessária
                new StartMenu(); // Inicia o menu inicial, presumindo que este seja um construtor de uma classe que gerencia o menu
            }
        }
    }
}
