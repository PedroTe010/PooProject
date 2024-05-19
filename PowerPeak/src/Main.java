import Help.HelpProgram;
import Menus.StartMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        HelpProgram help = new HelpProgram();

        help.clean();

        new StartMenu();

    }
}