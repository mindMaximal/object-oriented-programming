package lab5_10;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FindDialog extends JDialog {
    //Создаем toolkit для работы его методами
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    //Получаем размеры экрана
    Dimension screen = toolkit.getScreenSize();

    public FindDialog() {
        initDialog();
        addComponentsToPane(this);
    }

    private void initDialog() {
        //Размеры фрейма
        int width = 400;
        int height = 230;
        //Расчитываем позицию по центру
        int posX = screen.width / 2 - width / 2;
        int posY = screen.height / 2 - height / 2;

        //Устанавливаем размеры и позиционирование
        setBounds(posX, posY, width, height);

        setTitle("Поиск транспортного средства");

        getContentPane().setBackground(Color.decode("#ffffff"));

        setLayout(new GridBagLayout());
    }

    private void addComponentsToPane(Container pane) {
        JTextField textField;
        JLabel label;
        GridBagConstraints c = new GridBagConstraints();
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton radioButton;
        JButton button;
        JPanel panel;

        label = new JLabel("Поиск по:");
        label.setHorizontalAlignment(JLabel.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.ipady = 15;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 1;
        c.gridy = 0;

        pane.add(label, c);

        String[] radioButtonNames = {"Автомобили", "Экспрессы", "Все"};

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.setBackground(Color.decode("#ffffff"));


        for (int i = 0; i < radioButtonNames.length; i++) {
            boolean selected = i == (radioButtonNames.length - 1);
            radioButton = new JRadioButton(radioButtonNames[i], selected);
            radioButton.setBackground(Color.decode("#ffffff"));
            radioButton.setHorizontalAlignment(SwingConstants.CENTER);
            buttonGroup.add(radioButton);
            panel.add(radioButton, c);
        }

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.ipadx = 40;
        c.gridx = 1;
        c.gridy = 2;

        pane.add(panel, c);

        label = new JLabel("Название:");
        label.setHorizontalAlignment(JLabel.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.ipady = 15;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 1;
        c.gridy = 3;

        pane.add(label, c);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.setBackground(Color.decode("#ffffff"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 1;
        c.gridy = 4;
        textField = new JTextField();
        textField.setColumns(20);

        panel.add(textField);
        pane.add(panel, c);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.setBackground(Color.decode("#ffffff"));
        c.insets = new Insets(0,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 5;

        button = new JButton("Найти");
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#7ebc59"));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        panel.add(button);
        pane.add(panel, c);

    }

    public void showDialog() {
        setVisible(true);
    }
}
