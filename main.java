import GUI.Controller;
import GUI.View;
import Model.Model;

public class main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        controller.setVisible(true);
    }
}
