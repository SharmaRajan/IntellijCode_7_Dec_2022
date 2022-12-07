import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Abc obj = new Abc();
//        obj.setVisible(true);
//        obj.setSize(400,400);
    }
}

    class Abc extends JFrame{
        public Abc(){

            //JFrame follows CardLayout it override previous JLabel
            //to resolve it
            // we can use setLayout, FLowLayout, GridLayout, Null

            JLabel label = new JLabel("Hello World");
            JLabel label1 = new JLabel("Welcome Rajan");
            add(label);
            add(label1);

            setLayout(new FlowLayout());
            setVisible(true);
            setSize(400,400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            setLayout(new FlowLayout());
            setVisible(true);
            setSize(400,400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

