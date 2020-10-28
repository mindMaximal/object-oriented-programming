package lab5_10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;
import java.util.Vector;

public class PopUp extends JPopupMenu {
    private JMenuItem menuItem;

    public PopUp(MouseEvent e, JTable table, int activeTable) {

        menuItem = new JMenuItem("Редактировать");

        menuItem.addActionListener(event -> {

            int row = table.rowAtPoint(e.getPoint());
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Vector element = (Vector) model.getDataVector().elementAt(row);

            String name = element.get(0).toString();

            Vehicle vehicle = AppGUI.findVehicle(name, activeTable == 0 ? "CARS" : "EXPRESS");

            AddPanel.setCellPos(row);

            AddPanel.fillFields(vehicle);

            AddPanel.setEditMode();

            CardLayout cardLayout = (CardLayout) AppGUI.getCardPane().getLayout();
            cardLayout.show(AppGUI.getCardPane(), "Add");
        });

        add(menuItem);

        menuItem = new JMenuItem("Удалить");

        try {
            int column = table.columnAtPoint(e.getPoint());
            int row = table.rowAtPoint(e.getPoint());
            table.setColumnSelectionInterval(column, column);
            table.setRowSelectionInterval(row, row);

            menuItem.addActionListener(event -> {

                String nameForDelete = table.getValueAt(row, 0).toString();

                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, MessageFormat.format("Вы хотите удалить \"{0}?\"", nameForDelete), "Warning", dialogButton);

                if(dialogResult == JOptionPane.YES_OPTION){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    Vector element = (Vector) model.getDataVector().elementAt(row);

                    String name = element.get(0).toString();

                    AppGUI.deleteVehicle(name, activeTable == 0 ? "CARS" : "EXPRESS");

                    model.removeRow(row);
                }
            });
        } catch (IllegalAccessError error) {
            System.out.println("Строка не выбрана");
        }

        add(menuItem);
    }
}