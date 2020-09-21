package lab5_10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class ListPanel extends JPanel {

    int buttonCount = 0;
    JPanel tablePanel = new JPanel();
    static JTable carsTable = new JTable();
    JTable expressTable = new JTable();

    public ListPanel() {
        initPanel();
        addElementsToPanel(this);
    }

    private void initPanel() {
        setBackground(Color.decode("#ffffff"));
        setVisible(true);

        AppGUI.initCom();
    }

    private void addElementsToPanel(Container pane) {
        JButton button;
        JPanel panel;
        JLabel label;
        JRadioButton radioButton;
        Font font;
        ButtonGroup buttonGroup;

        //Установим метод компановки GridBagLayout
        pane.setLayout(new GridBagLayout());

        //Переменная, позволяющая манипулировать настройками layout
        GridBagConstraints c = new GridBagConstraints();

        label = new JLabel("Список транспортных средств:");

        font = new Font(null, Font.BOLD, 14);

        label.setFont(font);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(20,20,20,0);
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.05;

        pane.add(label, c);

        tablePanel.setLayout(new CardLayout(0, 0));
        tablePanel.add(setTable("CARS", carsTable), "CarsTable");
        tablePanel.add(setTable("EXPRESS", expressTable), "ExpressTable");
        tablePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(0,20,20,20);
        c.weightx = 0.8;
        c.weighty = 0.95;
        c.gridx = 0;
        c.gridy = 1;

        pane.add(tablePanel, c);

        panel = new JPanel();
        panel.setBackground(Color.decode("#ffffff"));
        panel.setLayout(new GridBagLayout());

        button = new JButton("Добавить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) AppGUI.contentPane.getLayout();
                cardLayout.show(AppGUI.contentPane, "Add");
            }
        });
        setButtonSetting(button);
        setLayoutSetting(c);

        panel.add(button, c);

        button = new JButton("Найти");
        setButtonSetting(button);
        setLayoutSetting(c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Vehicle> list = AppGUI.getCarsList();
                Object[] elem = list.get(list.size() - 1).getObject();
                String msg = (String) elem[0];

                JOptionPane.showMessageDialog(AppGUI.generalListPanel, msg);
            }
        });

        panel.add(button, c);

        button = new JButton("Меню");
        setButtonSetting(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) AppGUI.contentPane.getLayout();
                cardLayout.show(AppGUI.contentPane, "Menu");
            }
        });
        setLayoutSetting(c);

        panel.add(button, c);

        buttonGroup = new ButtonGroup();

        radioButton = new JRadioButton("Автомобили", true);
        radioButton.setBackground(Color.decode("#ffffff"));
        radioButton.setHorizontalAlignment(SwingConstants.LEFT);
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) tablePanel.getLayout();
                cardLayout.show(tablePanel, "CarsTable");
            }
        });
        buttonGroup.add(radioButton);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(40,20,0,20);
        c.gridx = 0;
        c.gridy = 3;

        panel.add(radioButton, c);

        radioButton = new JRadioButton("Экспрессы", false);
        radioButton.setBackground(Color.decode("#ffffff"));
        radioButton.setHorizontalAlignment(SwingConstants.LEFT);
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) tablePanel.getLayout();
                cardLayout.show(tablePanel, "ExpressTable");
            }
        });
        buttonGroup.add(radioButton);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(40,20,0,20);
        c.gridx = 0;
        c.gridy = 4;

        panel.add(radioButton, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(0,0,0,0);
        c.weightx = 0.2;
        c.weighty = 0.95;
        c.gridx = 1;
        c.gridy = 1;

        pane.add(panel, c);
    }

    public void showPanel() {
        setVisible(true);
    }

    public void hidePanel() {
        setVisible(false);
    }

    private void setButtonSetting(JButton button) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#7ebc59"));
        //button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void setLayoutSetting(GridBagConstraints constraints) {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.ipady = 15;
        constraints.insets = new Insets(5,20,5,20);
        constraints.gridx = 0;
        constraints.gridy = buttonCount;

        buttonCount++;
    }

    private JPanel setTable(String typeName, JTable table) {

        DefaultTableModel model = new DefaultTableModel();

        int type = 0;

        if (typeName.equals("CARS")) type = 1; else if(typeName.equals("EXPRESS")) type = 2;

        JPanel pane = new JPanel();

        pane.setLayout(new GridBagLayout());
        pane.setBackground(Color.decode("#ffffff"));

        GridBagConstraints c = new GridBagConstraints();

        Vector<Vector<String>> data = new Vector<Vector<String>>() ;
        // Вектор с заголовками столбцов
        Vector<String> header = new Vector<String>();

        ArrayList<Vehicle> vehiclesList = type == 1 ? AppGUI.getCarsList() : AppGUI.getExpressList();

        Object[] columnsHeader;
        // Заголовки столбцов
        if (type == 1) {
            columnsHeader = new String[] {"Название", "Скорость",
                    "Вес", "Цвет","Количество колес"};
        } else {
            columnsHeader = new String[] {"Название", "Скорость",
                    "Вес", "Цвет","Количество баз", "Тип экспресса"};
        }

        for (Object headerName: columnsHeader) {
            model.addColumn((String) headerName);
        }

        for (Vehicle vehicle : vehiclesList) {

            Vector<String> row = new Vector<String>();

            Object[] objects = vehicle.getObject();

            for (Object object : objects)
                row.add((String) object);

            model.addRow(row);
        }

        table.setModel(model);
        table.setRowHeight(30);
        table.setRowHeight(1, 20);
        table.setIntercellSpacing(new Dimension(10, 10));
        table.setGridColor(Color.blue);
        table.setShowVerticalLines(false);

        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;

        pane.add(new JScrollPane(table), c);

        return pane;
    }

    public void addCar(String name, int speed, int weight, String color, int wheelsCount) {
        DefaultTableModel model = (DefaultTableModel) carsTable.getModel();
        model.addRow(new Object[]{name, speed, weight, color, wheelsCount});
    }

    public void addExpress(String name, int speed, int weight, String color, int railsCount, String expressType) {
        DefaultTableModel model = (DefaultTableModel) carsTable.getModel();
        model.addRow(new Object[]{name, speed,weight, color, railsCount, expressType});
    }

}
