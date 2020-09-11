package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    JButton listBtn = new JButton("Посмотреть список транспортных средств");
    JButton addBtn = new JButton("Добавить транспортное средство");
    JButton removeBtn = new JButton("Удалить транспортное средство");
    JButton findBtn = new JButton("Найти транспортное средство");

    public MainPanel() {
        setBackground(Color.WHITE);

        listBtn.setBorderPainted(false);
        listBtn.setFocusPainted(false);
        listBtn.setForeground(Color.WHITE);
        listBtn.setBackground(Color.BLACK);
        listBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        listBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.RED);
            }
        });

        addBtn.setBorderPainted(false);
        addBtn.setFocusPainted(false);
        addBtn.setForeground(Color.WHITE);
        addBtn.setBackground(Color.BLACK);
        addBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        removeBtn.setBorderPainted(false);
        removeBtn.setFocusPainted(false);
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setBackground(Color.BLACK);
        removeBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        findBtn.setBorderPainted(false);
        findBtn.setFocusPainted(false);
        findBtn.setForeground(Color.WHITE);
        findBtn.setBackground(Color.BLACK);
        findBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(addBtn);
        add(listBtn);
        add(removeBtn);
        add(findBtn);
    }

}
