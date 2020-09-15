package lab5_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    //Количество кнопок на панели
    int buttonCount = 0;

    //Конструктор для изначальной компоновки панели
    public MainPanel() {
        //Установим белый фон
        setBackground(Color.decode("#ffffff"));
        //Добавим элементы на панель
        addComponentsToPane(this);
    }

    //Функция для добавления элементов на панель
    public void addComponentsToPane(Container pane) {
        //Переменная для создания кнопок
        JButton button;
        //Установим метод компановки GridBagLayout
        pane.setLayout(new GridBagLayout());

        //Переменная, позволяющая манипулировать настройками layout
        GridBagConstraints constraints = new GridBagConstraints();

        //Создадим новую кнопку
        button = new JButton("Посмотреть список транспортных средств");
        //Зададим стандартные настройки слоя для этой панели
        setLayoutSetting(constraints);
        //Зададим стандартные настройки кнопки для этой панели
        setButtonSetting(button);
        //Добавим обработчик для кнопки
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.RED);
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
                setBackground(Color.RED);
            }
        });
        //Добавим кнопку в контейнер
        pane.add(button, constraints);

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
                setBackground(Color.RED);
            }
        });
        //Добавим кнопку в контейнер
        pane.add(button, constraints);

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

                //Создаем toolkit для работы его методами
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                //Получаем размеры экрана
                Dimension screen = toolkit.getScreenSize();

                JDialog findDialog = new JDialog();
                JTextField textField;
                JLabel label;
                JCheckBox checkBox;
                GridBagConstraints c = new GridBagConstraints();

                //Размеры фрейма
                final int width = 350;
                final int height = 230;

                findDialog.getContentPane().setBackground(Color.decode("#ffffff"));

                //Расчитываем позицию по центру
                int posX = (int) (screen.width / 2 - width / 2);
                int posY = (int) (screen.height / 2 - height / 2);

                //Устанавливаем размеры и позиционирование
                findDialog.setBounds(posX, posY, width, height);

                findDialog.setLayout(new GridBagLayout());

                label = new JLabel("Поиск по:");
                c.fill = GridBagConstraints.HORIZONTAL;
                c.anchor = GridBagConstraints.CENTER;
                c.ipady = 15;
                c.insets = new Insets(5,0,5,0);
                c.gridx = 0;
                c.gridy = 1;

                findDialog.add(label, c);

                checkBox = new JCheckBox("Автомобили");
                checkBox.setBackground(Color.decode("#ffffff"));
                c.fill = GridBagConstraints.HORIZONTAL;
                c.ipady = 15;
                c.insets = new Insets(5,0,5,0);
                c.weightx = 1.0;
                c.gridx = 1;
                c.gridy = 2;

                findDialog.add(checkBox, c);

                checkBox = new JCheckBox("Экспрессы");
                checkBox.setBackground(Color.decode("#ffffff"));
                c.fill = GridBagConstraints.HORIZONTAL;
                c.ipady = 15;
                c.insets = new Insets(5,0,5,0);
                c.gridx = 2;
                c.gridy = 2;

                findDialog.add(checkBox, c);

                checkBox = new JCheckBox("Все");
                checkBox.setBackground(Color.decode("#ffffff"));
                c.fill = GridBagConstraints.HORIZONTAL;
                c.ipady = 15;
                c.insets = new Insets(5,0,5,0);
                c.gridx = 3;
                c.gridy = 2;

                findDialog.add(checkBox, c);

                label = new JLabel("Название:");
                c.fill = GridBagConstraints.HORIZONTAL;
                c.anchor = GridBagConstraints.CENTER;
                c.ipady = 15;
                c.insets = new Insets(5,0,5,0);
                c.gridx = 0;
                c.gridy = 3;

                findDialog.add(label, c);

                c.fill = GridBagConstraints.HORIZONTAL;
                c.anchor = GridBagConstraints.CENTER;
                c.ipadx = 150;
                c.insets = new Insets(5,0,5,0);
                c.gridx = 0;
                c.gridy = 4;

                textField = new JTextField();

                findDialog.add(textField, c);


                findDialog.setVisible(true);
            }
        });
        //Добавим кнопку в контейнер
        pane.add(button, constraints);

    }

    //Функция настройки параметров кнопок с возможность установки фона
    public void setButtonSetting(JButton button, String backgroundColor) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode(backgroundColor));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    //Функция настройки параметров кнопок с стандартным фоном
    public void setButtonSetting(JButton button) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#7ebc59"));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    //Функция настройки параметров для добавления кнопки
    public void setLayoutSetting(GridBagConstraints constraints) {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipady = 15;
        constraints.insets = new Insets(5,0,5,0);
        constraints.gridx = 0;
        constraints.gridy = buttonCount;

        buttonCount++;
    }

}
