
package projectcanhan;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener{

    double number, answer;
    int calculation;

    JFrame frame;
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JRadioButton onRadioButton = new JRadioButton("on");
    JRadioButton offRadioButton = new JRadioButton("off");
    JButton buttonZero = new JButton("0");
    JButton buttonOne = new JButton("1");
    JButton buttonTwo = new JButton("2");
    JButton buttonThree = new JButton("3");
    JButton buttonFour = new JButton("4");
    JButton buttonFive = new JButton("5");
    JButton buttonSix = new JButton("6");
    JButton buttonSeven = new JButton("7");
    JButton buttonEight = new JButton("8");
    JButton buttonNine = new JButton("9");
    JButton buttonDot = new JButton(".");
    JButton buttonClear = new JButton("C");
    JButton buttonDelete = new JButton("DEL");
    JButton buttonEqual = new JButton("=");
    JButton buttonMul = new JButton("x");
    JButton buttonDiv = new JButton("/");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonSquare = new JButton("x\u00B2");
    JButton buttonReciprocal = new JButton("1/x");
    JButton buttonSqrt = new JButton("\u221A");

    ;

    Calculator() {
        prepareGUI();
        addComponents();
        addActionEvent();
    }

    public void prepareGUI() {
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(300, 490);
        frame.getContentPane().setLayout(null);
//        frame.getContentPane().setBackground(Color.black);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addComponents() {
        label.setBounds(250, 0, 50, 50);
        label.setForeground(Color.white);
        frame.add(label);

        textField.setBounds(10, 40, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);

        onRadioButton.setBounds(10, 95, 60, 40);
        onRadioButton.setSelected(true);
        onRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
//        onRadioButton.setBackground(Color.black);
        onRadioButton.setForeground(Color.white);
        frame.add(onRadioButton);

        offRadioButton.setBounds(10, 120, 60, 40);
        offRadioButton.setSelected(false);
        offRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
//        offRadioButton.setBackground(Color.black);
        offRadioButton.setForeground(Color.white);
        frame.add(offRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onRadioButton);
        buttonGroup.add(offRadioButton);

        buttonSeven.setBounds(10, 230, 60, 40);
        buttonSeven.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSeven);

        buttonEight.setBounds(80, 230, 60, 40);
        buttonEight.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonEight);

        buttonNine.setBounds(150, 230, 60, 40);
        buttonNine.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonNine);

        buttonFour.setBounds(10, 290, 60, 40);
        buttonFour.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFour);

        buttonFive.setBounds(80, 290, 60, 40);
        buttonFive.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFive);

        buttonSix.setBounds(150, 290, 60, 40);
        buttonSix.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSix);

        buttonOne.setBounds(10, 350, 60, 40);
        buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonOne);

        buttonTwo.setBounds(80, 350, 60, 40);
        buttonTwo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonTwo);

        buttonThree.setBounds(150, 350, 60, 40);
        buttonThree.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonThree);

        buttonDot.setBounds(150, 410, 60, 40);
        buttonDot.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonDot);

        buttonDiv.setBounds(220, 110, 60, 40);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonDiv);

        buttonSqrt.setBounds(10, 170, 60, 40);
        buttonSqrt.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSqrt);

        buttonMul.setBounds(220, 230, 60, 40);
        buttonMul.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonMul);

        buttonMinus.setBounds(220, 170, 60, 40);
        buttonMinus.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonMinus);

        buttonPlus.setBounds(220,290,60,40);
        buttonPlus.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonPlus);
        
        buttonSquare.setBounds(80,170,60,40);
        buttonSquare.setFont(new Font("Arial", Font.BOLD,20));
        frame.add(buttonSquare);
        
        buttonReciprocal.setBounds(150,170,60,40);
        buttonReciprocal.setFont(new Font("Arial", Font.BOLD,15));
        frame.add(buttonReciprocal);
        
        buttonDelete.setBounds(150,110,60,40);
        buttonDelete.setFont(new Font("Arial", Font.BOLD,12));
        buttonDelete.setForeground(Color.white);
        frame.add(buttonDelete);
        
        buttonClear.setBounds(80,110,60,40);
        buttonClear.setFont(new Font("Arial", Font.BOLD,12));
        buttonClear.setForeground(Color.white);
        frame.add(buttonClear);

        buttonEqual.setBounds(220, 350, 60, 100); // 
        buttonEqual.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonEqual);

        
    }

    private void addActionEvent() {
        onRadioButton.addActionListener(this);
        offRadioButton.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonSqrt.addActionListener(this);
        buttonSquare.addActionListener(this);
        buttonReciprocal.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonZero.addActionListener(this);
        buttonDot.addActionListener(this);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();

    if (source == onRadioButton) {
        enable();
    } else if (source == offRadioButton) {
        disable();
    } else if (source == buttonClear) {
        textField.setText("");
        label.setText("");
    } else if (source == buttonDelete) {
        int length = textField.getText().length();
        int number = length - 1;

        if (length > 0) {
            StringBuilder back = new StringBuilder(textField.getText());
            back.deleteCharAt(number);
            textField.setText(back.toString());
        }
        if(textField.getText().endsWith("")){
            label.setText("");
        }
    } else if (source == buttonZero) {
        if(textField.getText().equals("0")){
            return;
        } else {
            textField.setText(textField.getText() + "0");
        }
    } else if (source == buttonOne) {
        textField.setText(textField.getText() + "1");
    } else if (source == buttonTwo) {
        textField.setText(textField.getText() + "2");
    } else if (source == buttonThree) {
        textField.setText(textField.getText() + "3");
    } else if (source == buttonFour) {
        textField.setText(textField.getText() + "4");
    } else if (source == buttonFive) {
        textField.setText(textField.getText() + "5");
    } else if (source == buttonSix) {
        textField.setText(textField.getText() + "6");
    } else if (source == buttonSeven) {
        textField.setText(textField.getText() + "7");
    } else if (source == buttonEight) {
        textField.setText(textField.getText() + "8");
    } else if (source == buttonNine) {
        textField.setText(textField.getText() + "9");
    } else if (source == buttonDot) {
       if( textField.getText().contains( ".")){
           return;
       } else{ 
           textField.setText(textField.getText()+" ");

       }
    } 
    

    // Handling the arithmetic operations
    else if (source == buttonPlus) {
        number = Double.parseDouble(textField.getText());
        calculation = 1; // Addition
        textField.setText("");
        label.setText(number + "+");
    } else if (source == buttonMinus) {
        number = Double.parseDouble(textField.getText());
        calculation = 2; // Subtraction
        textField.setText("");
        label.setText(number + "-");
    } else if (source == buttonMul) {
        number = Double.parseDouble(textField.getText());
        calculation = 3; // Multiplication
        textField.setText("");
        label.setText(number + "x");
    } else if (source == buttonDiv) {
        number = Double.parseDouble(textField.getText());
        calculation = 4; // Division
        textField.setText("");
        label.setText(number + "/");
    } else if (source == buttonEqual) {
        performCalculation();
        label.setText("");
    }

    // Handling special operations like square, square root, etc.
    else if (source == buttonSquare) {
        number = Double.parseDouble(textField.getText());
        double square = Math.pow(number, 2);
        textField.setText(Double.toString(square));
    } else if (source == buttonSqrt) {
        number = Double.parseDouble(textField.getText());
        Double sqrt = Math.sqrt(number);
        textField.setText(Double.toString(sqrt));
    }
}

public void performCalculation() {
    switch (calculation) {
        case 1: // Addition
            answer = number + Double.parseDouble(textField.getText());
            textField.setText(Double.toString(answer));
            break;
        case 2: // Subtraction
            answer = number - Double.parseDouble(textField.getText());
            textField.setText(Double.toString(answer));
            break;
        case 3: // Multiplication
            answer = number * Double.parseDouble(textField.getText());
            textField.setText(Double.toString(answer));
            break;
        case 4: // Division
            answer = number / Double.parseDouble(textField.getText());
            textField.setText(Double.toString(answer));
            break;
    }
}

public void enable() {
    textField.setEnabled(true);
    buttonZero.setEnabled(true);
    buttonOne.setEnabled(true);
    onRadioButton.setEnabled(false);
    offRadioButton.setEnabled(true);
    label.setEnabled(true);
    buttonClear.setEnabled(true);
    buttonDelete.setEnabled(true);
    buttonDiv.setEnabled(true);
    buttonSqrt.setEnabled(true);
    buttonSquare.setEnabled(true);
    buttonReciprocal.setEnabled(true);
    buttonMinus.setEnabled(true);
    buttonSeven.setEnabled(true);
    buttonEight.setEnabled(true);
    buttonNine.setEnabled(true);
    buttonMul.setEnabled(true);
    buttonFour.setEnabled(true);
    buttonFive.setEnabled(true);
    buttonSix.setEnabled(true);
    buttonPlus.setEnabled(true);
    buttonTwo.setEnabled(true);
    buttonThree.setEnabled(true);
    buttonEqual.setEnabled(true);
    
}

public void disable() {
    textField.setText(" ");
    buttonZero.setEnabled(false);
    buttonOne.setEnabled(false);
  // onRadioButton.setEnabled(true);
    offRadioButton.setEnabled(false);
    label.setText(" ");
    buttonClear.setEnabled(false);
    buttonDelete.setEnabled(false);
    buttonDiv.setEnabled(false);
    buttonSqrt.setEnabled(false);
    buttonSquare.setEnabled(false);
    buttonReciprocal.setEnabled(false);
    buttonMinus.setEnabled(false);
    buttonSeven.setEnabled(false);
    buttonEight.setEnabled(false);
    buttonNine.setEnabled(false);
    buttonMul.setEnabled(false);
    buttonFour.setEnabled(false);
    buttonFive.setEnabled(false);
    buttonSix.setEnabled(false);
    buttonPlus.setEnabled(false);
    buttonTwo.setEnabled(false);
    buttonThree.setEnabled(false);
    buttonEqual.setEnabled(false);
}


}