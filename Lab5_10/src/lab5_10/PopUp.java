package lab5_10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;

public class PopUp  extends JPopupMenu {
    JMenuItem menuItem;

    public PopUp(MouseEvent e, JTable table, int activeTable){

        menuItem = new JMenuItem("Редактировать");

        menuItem.addActionListener(event -> {

            int column = table.columnAtPoint(e.getPoint());
            int row = table.rowAtPoint(e.getPoint());
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            String name = model.getDataVector().elementAt(row).firstElement().toString();

            Vehicle vehicle = AppGUI.findVehicle(name, activeTable == 0 ? "CARS" : "EXPRESS");

            AddPanel.setCellPos(row,column);

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
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Вы хотите удалить эту строку?", "Warning", dialogButton);

                if(dialogResult == JOptionPane.YES_OPTION){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    String name = model.getDataVector().elementAt(row).firstElement().toString();

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