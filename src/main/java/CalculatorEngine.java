import javafx.scene.control.ButtonType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {

    Calculator parent;  // ссылка на окно калькулятора

    char selectedAction = ' ';  // +, -, * , /
    double currentResult = 0;

    public CalculatorEngine(Calculator parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        // получить источник действия

        JButton clickedButton = (JButton) e.getSource();
        String dispFiledText = parent.displayFormattedField.getText();
        double displayValue = 0;

        // Получить число из дисплея калькулятора

        if (!"".equals(dispFiledText)) {
            displayValue = Double.parseDouble(dispFiledText);
        }

        Object src = e.getSource();

        if (src == parent.buttonAddition) {
            selectedAction = '+';
            currentResult = displayValue;
            parent.displayFormattedField.setText("");
        } else if (src == parent.buttonSubtraction) {
            selectedAction = '-';
            currentResult = displayValue;
            parent.displayFormattedField.setText("");
        } else if (src == parent.buttonMultiplication) {
            selectedAction = '*';
            currentResult = displayValue;
            parent.displayFormattedField.setText("");
        } else if (src == parent.buttonDivision) {
            selectedAction = '/';
            currentResult = displayValue;
            parent.displayFormattedField.setText("");
        } else if (src == parent.buttonEqual) {

            // совершить арифметическое действие

            if (selectedAction == '+') {
                currentResult += displayValue;

                // сконвертировать его в строку и показать

                parent.displayFormattedField.setText("" + currentResult);
            } else if (selectedAction == '-') {
                currentResult -= displayValue;
                parent.displayFormattedField.setText("" + currentResult);
            } else if (selectedAction == '*') {
                currentResult *= displayValue;
                parent.displayFormattedField.setText("" + currentResult);
            } else if (selectedAction == '/') {
                currentResult /= displayValue;
                parent.displayFormattedField.setText("" + currentResult);
            }
        } else {
            // Для всех цифровых кнопок присоеденить надпись на кнопке к надписи в дисплее

            String clickedButtonLabel = clickedButton.getText();
            parent.displayFormattedField.setText(dispFiledText + clickedButtonLabel);
        }
    }
}
