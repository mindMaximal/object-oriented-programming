package lab5_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    //Количество кнопок на панели
    private int buttonCount = 0;

    //Конструктор для изначальной компоновки панели
    public MainPanel() {
        //Установим белый фон
        setBackground(Color.decode("#ffffff"));
        //Добавим элементы на панель
        addComponentsToPane(this);
        setVisible(true);
    }

    //Функция для добавления элементов на панель
    private void addComponentsToPane(Container pane) {
        //Переменная для создания кнопок
        JButton button;
        //Установим метод компановки GridBagLayout
        pane.setLayout(new GridBagLayout());

        //Переменная, позволяющая манипулировать настройками layout
        GridBagConstraints constraints = new GridBagConstraints();

        //Создадим новую кнопку
        button = new JButton("Список транспортных средств");
        //Зададим стандартные настройки слоя для этой панели
        setLayoutSetting(constraints);
        //Зададим стандартные настройки кнопки для этой панели
        setButtonSetting(button);
        //Добавим обработчик для кнопки
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) AppGUI.getCardPane().getLayout();
                cardLayout.show(AppGUI.getCardPane(), "List");
            }
        });
        //Добавим кнопку в контейнер
        pane.add(button, constraints);

        //Создадим новую кнопку
        button = new JButton("Добавить транспортное средство");
        //Зададим стандартные настройки слоя для этой панели
        setLayoutSetting(constraints);
        //Зададим стандартные настройки кнопки для этой панели
        setButtonSetting(button);
        //Добавим обработчик для кнопки
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!AddPanel.isSaved()) {
                    AddPanel.clearFields();
                }

                AddPanel.toggleMode();

                CardLayout cardLayout = (CardLayout) AppGUI.getCardPane().getLayout();
                cardLayout.show(AppGUI.getCardPane(), "Add");
            }
        });
        //Добавим кнопку в контейнер
        pane.add(button, constraints);

        /*
        //Создадим новую кнопку
        button = new JButton("Удалить транспортное средство");
        //Зададим стандартные настройки слоя для этой панели
        setLayoutSetting(constraints);
        //Зададим стандартные настройки кнопки для этой панели
        setButtonSetting(button);
        //Добавим обработчик для кнопки
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) AppGUI.getCardPane().getLayout();
                cardLayout.show(AppGUI.getCardPane(), "List");
                JOptionPane.showMessageDialog(null, "Для того чтобы удалить транспортное средство\r\nнайдите его в списке, нажмите правкую кнопку и выберете \"Удалить\"", "Удаление транспортного средства", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //Добавим кнопку в контейнер
        pane.add(button, constraints);
        */

        /*
        //Создадим новую кнопку
        button = new JButton("Найти транспортное средство");
        //Зададим стандартные настройки слоя для этой панели
        setLayoutSetting(constraints);
        //Зададим стандартные настройки кнопки для этой панели
        setButtonSetting(button);
        //Добавим обработчик для кнопки
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppGUI.initCom();
                FindDialog findDialog = new FindDialog();

                findDialog.showDialog();
            }
        });
        //Добавим кнопку в контейнер
        pane.add(button, constraints);
         */
    }

    //Функция настройки параметров кнопок с стандартным фоном
    private void setButtonSetting(JButton button) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#7ebc59"));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    //Функция настройки параметров для добавления кнопки
    private void setLayoutSetting(GridBagConstraints constraints) {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipady = 15;
        constraints.insets = new Insets(5,0,5,0);
        constraints.gridx = 0;
        constraints.gridy = buttonCount;

        buttonCount++;
    }

}
