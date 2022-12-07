import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGUI {

    public static void main(String[] args) {

        Addition addition = new Addition();

    }
}

class Addition extends JFrame{ //implements ActionListener {
    JTextField text,text1;
    JButton btn;
    JLabel label;
    public Addition(){
        text = new JTextField(5);
        text1 = new JTextField(5);

        btn = new JButton("Ok");
        label = new JLabel("Result");

        add(text);
        add(text1);
        add(btn);
        add(label);




        // ActionListener is an interface
//        btn.addActionListener(this);

//        ActionListener action = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int num1 = Integer.parseInt(text.getText());
//                int num2 = Integer.parseInt(text1.getText());
//
//                int result = num1 + num2;
//                label.setText(result +"");
//            }
//        };
//        btn.addActionListener(action);

//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int num1 = Integer.parseInt(text.getText());
//                int num2 = Integer.parseInt(text1.getText());
//
//                int result = num1 + num2;
//                label.setText(result +"");
//            }
//        });

        // Functional Interface - only one method implementation
        // Using Lambda Expression
        btn.addActionListener(action->{
            int num1 = Integer.parseInt(text.getText());
            int num2 = Integer.parseInt(text1.getText());

            int result = num1 + num2;
            label.setText(result +"");
        });

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        int num1 = Integer.parseInt(text.getText());
//        int num2 = Integer.parseInt(text1.getText());
//
//        int result = num1 + num2;
//
//        label.setText(result +"");
//    }
}
