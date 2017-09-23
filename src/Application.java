import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {

    private static String token;

    public Application(){
        JFrame frame = new JFrame("Imagibot");
        frame.setSize(300, 200);

        JPanel panel = new JPanel();

        JButton start = new JButton("Start bot");
        start.addActionListener((e)-> new Bot(token));
        panel.add(start);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        token = "MzU2NzEyOTcyOTgwMTkxMjMy.DJhdlA.jjwDAa7WCR-C3yKouuSVU72K8CY";
        new Application();
    }

}
