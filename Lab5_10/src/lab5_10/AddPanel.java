package lab5_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPanel extends JPanel {

    public AddPanel() {
        setBackground(Color.decode("#ccc"));
        setVisible(true);

        JButton button;

        button = new JButton("Меню");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AppGUI.showGeneralList();
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
