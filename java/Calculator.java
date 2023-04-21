import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
  private JTextField textField;
  private double num1, num2, result;
  private int operator;

  public Calculator() {
    // Set up JFrame
    setTitle("Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    // Set up text field
    textField = new JTextField(20);
    textField.setEditable(false);
    add(textField, BorderLayout.NORTH);

    // Set up buttons
    JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
    String[] buttonLabels = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
    for (String label : buttonLabels) {
      JButton button = new JButton(label);
      button.addActionListener(this);
      buttonPanel.add(button);
    }
    add(buttonPanel, BorderLayout.CENTER);

    // Display JFrame
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String buttonText = ((JButton) e.getSource()).getText();
    switch (buttonText) {
      case "0":
      case "1":
      case "2":
      case "3":
      case "4":
      case "5":
      case "6":
      case "7":
      case "8":
      case "9":
      case ".":
        textField.setText(textField.getText() + buttonText);
        break;
      case "+":
        num1 = Double.parseDouble(textField.getText());
        operator = 1;
        textField.setText("");
        break;
      case "-":
        num1 = Double.parseDouble(textField.getText());
        operator = 2;
        textField.setText("");
        break;
      case "*":
        num1 = Double.parseDouble(textField.getText());
        operator = 3;
        textField.setText("");
        break;
      case "/":
        num1 = Double.parseDouble(textField.getText());
        operator = 4;
        textField.setText("");
        break;
      case "=":
        num2 = Double.parseDouble(textField.getText());
        switch (operator) {
          case 1:
            result = num1 + num2;
            break;
          case 2:
            result = num1 - num2;
            break;
          case 3:
            result = num1 * num2;
            break;
          case 4:
            result = num1 / num2;
            break;
        }
        textField.setText("" + result);
        break;
    }
  }

  public static void main(String[] args) {
    new Calculator();
  }
}
