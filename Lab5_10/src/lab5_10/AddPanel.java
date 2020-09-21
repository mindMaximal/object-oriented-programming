package lab5_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPanel extends JPanel {
    JLabel[] labelArray;
    JTextField[] textFields;
    JRadioButton[] radioButtons;

    public AddPanel() {
        setBackground(Color.decode("#ffffff"));
        setVisible(true);

        JButton button;
        JLabel label;
        JPanel panel;
        JTextField textField;
        JRadioButton radioButton;
        ButtonGroup buttonGroup;
        Font font;

        //Установим метод компоновки GridBagLayout
        setLayout(new GridBagLayout());

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

        add(label, c);

        panel = new JPanel();
        panel.setBackground(Color.decode("#ffffff"));
        panel.setLayout(new GridBagLayout());

        /*

        buttonGroup = new ButtonGroup();

        radioButton = new JRadioButton("Автомобили", true);
        radioButton.setBackground(Color.decode("#ffffff"));
        radioButton.setHorizontalAlignment(SwingConstants.LEFT);
        buttonGroup.add(radioButton);

        c.weightx = 0.25;
        c.gridx = 0;
        c.gridy = 1;

        panel.add(radioButton, c);

        radioButton = new JRadioButton("Экспрессы", true);
        radioButton.setBackground(Color.decode("#ffffff"));
        radioButton.setHorizontalAlignment(SwingConstants.LEFT);
        buttonGroup.add(radioButton);

        c.weightx = 0.25;
        c.gridx = 1;
        c.gridy = 1;

        panel.add(radioButton, c);

        label = new JLabel("Добавить:");
        label.setHorizontalAlignment(JLabel.LEFT);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;

        panel.add(label, c);

        label = new JLabel("Название:");
        label.setHorizontalAlignment(JLabel.LEFT);
        c.gridx = 0;
        c.gridy = 2;

        panel.add(label, c);

        textField = new JTextField();
        c.gridx = 0;
        c.gridy = 3;

        panel.add(textField, c);

        label = new JLabel("Цвет:");
        label.setHorizontalAlignment(JLabel.LEFT);
        c.gridx = 1;
        c.gridy = 2;

        panel.add(label, c);

        textField = new JTextField();
        c.gridx = 1;
        c.gridy = 3;

        panel.add(textField, c);

        label = new JLabel("Скорость:");
        label.setHorizontalAlignment(JLabel.LEFT);
        c.gridx = 0;
        c.gridy = 4;

        panel.add(label, c);

        textField = new JTextField();
        c.gridx = 0;
        c.gridy = 5;

        panel.add(textField, c);

        label = new JLabel("Количество колес:");
        label.setHorizontalAlignment(JLabel.LEFT);
        c.gridx = 1;
        c.gridy = 4;

        panel.add(label, c);

        textField = new JTextField();
        c.gridx = 1;
        c.gridy = 5;

        panel.add(textField, c);

        label = new JLabel("Вес:");
        label.setHorizontalAlignment(JLabel.LEFT);
        c.gridx = 0;
        c.gridy = 6;

        panel.add(label, c);

        textField = new JTextField();
        c.gridx = 0;
        c.gridy = 7;

       panel.add(textField, c);

        */


        buttonGroup = new ButtonGroup();
        radioButtons = new JRadioButton[2];

        radioButtons[0] = new JRadioButton("Автомобили", true);
        radioButtons[0].setBackground(Color.decode("#ffffff"));
        radioButtons[0].setHorizontalAlignment(SwingConstants.LEFT);
        buttonGroup.add(radioButtons[0]);

        c.weightx = 0.25;
        c.gridx = 0;
        c.gridy = 1;

        panel.add(radioButtons[0], c);

        radioButtons[1] = new JRadioButton("Экспрессы", true);
        radioButtons[1].setBackground(Color.decode("#ffffff"));
        radioButtons[1].setHorizontalAlignment(SwingConstants.LEFT);
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
                "Название:", "Скорость:", "Вес:", "Цвет:", "Количество колес:"
        };
        labelArray = new JLabel[labelNames.length];
        textFields = new JTextField[labelNames.length];

        for (int i = 0; i < labelNames.length; i++) {
            labelArray[i] = new JLabel(labelNames[i]);
            c.weightx = 0.5;
            c.gridx = (i + 2) % 2;
            c.gridy = (i + 2) - ( (i + 2) % 2 );
            labelArray[i].setBackground(Color.BLACK);
            panel.add(labelArray[i], c);

            textFields[i] = new JTextField();
            c.gridx = (i + 2) % 2;
            c.gridy = (i + 2) - ( (i + 2) % 2 ) + 1;
            panel.add(textFields[i], c);
        }

        button = new JButton("Добавить");
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#7ebc59"));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (radioButtons[0].isSelected()) {
                    AppGUI.addCar(textFields[0].getText(), Integer.parseInt(textFields[1].getText()), Integer.parseInt(textFields[2].getText()), textFields[3].getText(), Integer.parseInt(textFields[4].getText()));
                } else if(radioButtons[1].isSelected()) {
                    //AppGUI.addExpress(textFields[0].getText(), Integer.parseInt(textFields[1].getText()), Integer.parseInt(textFields[2].getText()), textFields[3].getText(), Integer.parseInt(textFields[4].getText()));
                }

                CardLayout cardLayout = (CardLayout) AppGUI.contentPane.getLayout();
                cardLayout.show(AppGUI.contentPane, "List");

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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) AppGUI.contentPane.getLayout();
                cardLayout.show(AppGUI.contentPane, "Menu");
            }
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
        add(panel, c);
    }

    public void showPanel() {
        setVisible(true);
    }

    public void hidePanel() {
        setVisible(false);
    }
}