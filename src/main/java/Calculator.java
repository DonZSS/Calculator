import javax.swing.*;
import java.awt.*;
import java.beans.Transient;

public class Calculator {

    // Объявление всех компонентов калькулятора

    //JPanel windowContent;
    Button[] numButtons = new Button[10];
    JButton buttonPoint;
    JButton buttonEqual;
    JButton buttonAddition;
    JButton buttonSubtraction;
    JButton buttonMultiplication;
    JButton buttonDivision;
    JPanel p1;
    JPanel p2;

    JPanel windowContent = new JPanel();
    JFormattedTextField displayFormattedField = new JFormattedTextField();

    Calculator() {


        //Создаем схему для этой панели

        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);

        // Создаем и отображаем поле
        // Добавляем его в Северную область окна


        displayFormattedField.setHorizontalAlignment(SwingConstants.RIGHT);
        windowContent.add("North", displayFormattedField);

        // Создаем кнопки, используя конструктор класса JButton, который принимает текст
        // кнопки в качестве параметра

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new Button("" + i);
        }
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");
        buttonAddition = new JButton("+");
        buttonSubtraction = new JButton("-");
        buttonMultiplication = new JButton("*");
        buttonDivision = new JButton("/");


        // Создаем панель GridLayout, который содержит 12 кнопок - 10 кнопок с чистлами
        // и кнопки с точкой и знаком равно

        p1 = new JPanel();
        GridLayout gl = new GridLayout(4, 3);
        p1.setLayout(gl);

        // Добавляем кнопки на панель
        for (int i = 1; i <= 10; i++) {
            if (i == 10) {
                p1.add(numButtons[0]);
            } else p1.add(numButtons[i]);
        }
        p1.add(buttonPoint);
        p1.add(buttonEqual);

        // Помещаем панель p1 в центральную область окна

        windowContent.add("Center", p1);

        // Создаем панель GridLayout, который содержит 4 кнопок +, -, *, /

        p2 = new JPanel();
        GridLayout gl2 = new GridLayout(4, 1);
        p2.setLayout(gl2);

        // Добавляем кнопки на панель

        p2.add(buttonAddition);
        p2.add(buttonSubtraction);
        p2.add(buttonMultiplication);
        p2.add(buttonDivision);

        // Помещаем панель p2 в восточную область окна

        windowContent.add("East", p2);


        // Создаем фрейм и задаем его основную панель

        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);

        // Делаем размер окна достаточным
        // для того, чтобы вместить все компоненты

        frame.pack();

        // Отображаем окно
        frame.setSize(400, 200);
        frame.setVisible(true);

        // Создаем экземпляр слушателя событий и регистрируем его в каждой кнопке

        CalculatorEngine calculatorEngine = new CalculatorEngine(this);

        numButtons[0].addActionListener(calculatorEngine);
        numButtons[1].addActionListener(calculatorEngine);
        numButtons[2].addActionListener(calculatorEngine);
        numButtons[3].addActionListener(calculatorEngine);
        numButtons[4].addActionListener(calculatorEngine);
        numButtons[5].addActionListener(calculatorEngine);
        numButtons[6].addActionListener(calculatorEngine);
        numButtons[7].addActionListener(calculatorEngine);
        numButtons[8].addActionListener(calculatorEngine);
        numButtons[9].addActionListener(calculatorEngine);
        buttonPoint.addActionListener(calculatorEngine);
        buttonAddition.addActionListener(calculatorEngine);
        buttonSubtraction.addActionListener(calculatorEngine);
        buttonMultiplication.addActionListener(calculatorEngine);
        buttonDivision.addActionListener(calculatorEngine);
        buttonEqual.addActionListener(calculatorEngine);
    }


        public static void main (String[]args){

            Calculator calculator = new Calculator();
        }
}

