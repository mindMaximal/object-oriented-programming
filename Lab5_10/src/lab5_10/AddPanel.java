package lab5_10;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.math.BigDecimal;

public class AddPanel extends JPanel {
    //Создаем переменные для элементов
    private static JLabel[] labelArray;
    private static JTextField[] textFields;
    private static JRadioButton[] radioButtons;
    private static boolean isEditing = false;
    private static Vehicle vehicle;
    private static int rowEditing;
    private static int columnEditing;

    //Конструктор
    public AddPanel() {
        initPanel();
        addElementToPanel(this);
        setValidation();
    }

    public static void setCellPos(int row, int column) {
        rowEditing = row;
        columnEditing = column;
    }

    public static int getRow() {
        return rowEditing;
    }

    public static int getColumn() {
        return columnEditing;
    }

    //Метод добавляющий элементы на панель
    private void addElementToPanel(Container pane) {
        JButton button;
        JLabel label;
        JPanel panel;
        ButtonGroup buttonGroup;
        Font font;

        //Переменная, позволяющая манипулировать настройками layout
        GridBagConstraints c = new GridBagConstraints();

        label = new JLabel("Добавить транспортное средство:");
        font = new Font("", Font.BOLD, 14);
        label.setFont(font);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.05;
        c.insets = new Insets(10,20,0,20);

        pane.add(label, c);

        panel = new JPanel();
        panel.setBackground(Color.decode("#ffffff"));
        panel.setLayout(new GridBagLayout());

        buttonGroup = new ButtonGroup();
        radioButtons = new JRadioButton[2];

        radioButtons[0] = new JRadioButton("Автомобили", true);
        radioButtons[0].setBackground(Color.decode("#ffffff"));
        radioButtons[0].setHorizontalAlignment(SwingConstants.LEFT);
        radioButtons[0].addActionListener(e -> {
            labelArray[4].setText("Количество колес:");
            labelArray[5].setVisible(false);
            textFields[5].setVisible(false);
        });
        buttonGroup.add(radioButtons[0]);

        c.weightx = 0.25;
        c.gridx = 0;
        c.gridy = 1;

        panel.add(radioButtons[0], c);

        radioButtons[1] = new JRadioButton("Экспрессы", true);
        radioButtons[1].setBackground(Color.decode("#ffffff"));
        radioButtons[1].setHorizontalAlignment(SwingConstants.LEFT);
        radioButtons[1].addActionListener(e -> {
            labelArray[4].setText("Количество баз:  ");
            labelArray[5].setVisible(true);
            textFields[5].setVisible(true);
        });
        buttonGroup.add(radioButtons[1]);

        c.weightx = 0.25;
        c.gridx = 1;
        c.gridy = 1;

        panel.add(radioButtons[1], c);

        label = new JLabel("Добавить:");
        label.setHorizontalAlignment(JLabel.LEFT);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;

        panel.add(label, c);

        String[] labelNames = new String[] {
                "Название:", "Скорость:", "Вес:", "Цвет:", "Количество колес:", "Тип экспресса:"
        };
        labelArray = new JLabel[labelNames.length];
        textFields = new JTextField[labelNames.length];

        for (int i = 0; i < labelNames.length; i++) {
            labelArray[i] = new JLabel(labelNames[i]);
            textFields[i] = new JTextField();
            c.weightx = 0.5;
            c.gridx = (i + 2) % 2;
            c.gridy = (i + 2) - ( (i + 2) % 2 );
            labelArray[i].setBackground(Color.BLACK);

            if (i == 5) {
                labelArray[i].setVisible(false);
                textFields[i].setVisible(false);
            }

            panel.add(labelArray[i], c);

            c.gridy = (i + 2) - ( (i + 2) % 2 ) + 1;
            panel.add(textFields[i], c);
        }

        button = new JButton("Отправить");
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#7ebc59"));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> {

            if(isEditing) {

                if (radioButtons[0].isSelected()) {
                    AppGUI.updateVehicle(
                            vehicle.getName(),
                            textFields[0].getText(),
                            Integer.parseInt(textFields[1].getText()),
                            Integer.parseInt(textFields[2].getText()),
                            textFields[3].getText(),
                            Integer.parseInt(textFields[4].getText())
                    );
                } else if(radioButtons[1].isSelected()) {
                    AppGUI.updateVehicle(
                            vehicle.getName(),
                            textFields[0].getText(),
                            Integer.parseInt(textFields[1].getText()),
                            Integer.parseInt(textFields[2].getText()),
                            textFields[3].getText(),
                            Integer.parseInt(textFields[4].getText()),
                            textFields[5].getText()
                    );
                }

                CardLayout cardLayout = (CardLayout) AppGUI.getCardPane().getLayout();
                cardLayout.show(AppGUI.getCardPane(), "List");
            } else {

                if (radioButtons[0].isSelected()) {
                    AppGUI.addCar(
                            textFields[0].getText(),
                            Integer.parseInt(textFields[1].getText()),
                            Integer.parseInt(textFields[2].getText()),
                            textFields[3].getText(),
                            Integer.parseInt(textFields[4].getText())
                    );
                } else if(radioButtons[1].isSelected()) {
                    AppGUI.addExpress(
                            textFields[0].getText(),
                            Integer.parseInt(textFields[1].getText()),
                            Integer.parseInt(textFields[2].getText()),
                            textFields[3].getText(),
                            Integer.parseInt(textFields[4].getText()),
                            textFields[5].getText()
                    );
                }

                CardLayout cardLayout = (CardLayout) AppGUI.getCardPane().getLayout();
                cardLayout.show(AppGUI.getCardPane(), "List");

            }

        });
        c.ipady = 15;
        c.weightx = 0.2;
        c.gridy = 8;
        c.gridx = 0;

        panel.add(button, c);

        button = new JButton("Меню");
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#7ebc59"));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) AppGUI.getCardPane().getLayout();
            cardLayout.show(AppGUI.getCardPane(), "Menu");
        });
        c.weightx = 0.2;
        c.gridy = 8;
        c.gridx = 1;

        panel.add(button, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.95;
        c.weightx = 1;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0,0,0,0);

        pane.add(panel, c);
    }
    //Метод задающий стандартные настройки для панели
    private void initPanel() {

        setBackground(Color.decode("#ffffff"));

        setVisible(true);

        //Установим метод компоновки GridBagLayout
        setLayout(new GridBagLayout());
    }
    //
    public static void fillFields(Vehicle vehicle) {

        AddPanel.vehicle = vehicle;

        isEditing = true;

        if(vehicle instanceof Car) {
            radioButtons[0].setSelected(true);

            labelArray[4].setText("Количество колес:");
            labelArray[5].setVisible(false);
            textFields[5].setVisible(false);

        } else if (vehicle instanceof Express) {
            radioButtons[1].setSelected(true);

            labelArray[4].setText("Количество баз:  ");
            labelArray[5].setVisible(true);
            textFields[5].setVisible(true);

        }

        Object[] data = vehicle.getObject();

        for (int i = 0; i < data.length; i++) {
            textFields[i].setText(data[i].toString());
        }
    }

    private void setValidation() {

        PlainDocument doc = (PlainDocument) textFields[0].getDocument();
        doc.setDocumentFilter(new DigitFilter());
    }

    static class DigitFilter extends DocumentFilter {
        private static final String DIGITS = "\\d+";

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException, BadLocationException {

            if (string.matches(DIGITS)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
            if (string.matches(DIGITS)) {
                super.replace(fb, offset, length, string, attrs);
            }
        }
    }

}