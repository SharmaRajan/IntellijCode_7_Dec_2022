import javax.swing.*;
import java.awt.*;

public class Calc {

    public static void main(String[] args) {
        AddSub add = new AddSub();

    }

}

class AddSub extends JFrame{
    JTextField text1,text2;
    JButton btn1, btn2;
    JLabel label;
    public AddSub(){
        text1 = new JTextField(5);
        text2 = new JTextField(5);
        btn1 = new JButton("Add");
        btn2 = new JButton("Sub");
        label = new JLabel("Result");

        add(text1);
        add(text2);
        add(btn1);
        add(btn2);
        add(label);

        btn1.addActionListener(action->{
            int num1 = Integer.parseInt(text1.getText());
            int num2 = Integer.parseInt(text2.getText());

            int result = num1 + num2;
            label.setText(result +"");
        });

        btn2.addActionListener(action->{
            int num1 = Integer.parseInt(text1.getText());
            int num2 = Integer.parseInt(text2.getText());

            int result = num1 - num2;
            label.setText(result +"");
        });


        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

