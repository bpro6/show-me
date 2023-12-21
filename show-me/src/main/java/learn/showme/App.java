package learn.showme;

import learn.showme.domain.ShowMeService;
import learn.showme.ui.ConsoleIO;
import learn.showme.ui.View;
import learn.showme.ui.Controller;

public class App {

    public static void main(String[] args) {

        ConsoleIO io = new ConsoleIO();
        View view = new View(io);
        ShowMeService showMeService = new ShowMeService();


        Controller controller = new Controller(view, showMeService);

        controller.run();
    }

}
