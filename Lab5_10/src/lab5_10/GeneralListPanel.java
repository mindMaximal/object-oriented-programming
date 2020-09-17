package lab5_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralListPanel extends JPanel {

    public GeneralListPanel() {
        setBackground(Color.decode("#000"));
        setVisible(true);

        JButton button;

        button = new JButton("Меню");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) AppGUI.contentPane.getLayout();
                cardLayout.show(AppGUI.contentPane, "Menu");
            }
        });

        add(button);
     }

    public void showPanel() {
        setVisible(true);
    }

    public void hidePanel() {
        setVisible(false);
    }
}
