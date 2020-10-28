package lab5_10;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*

    https://sqlitebrowser.org/dl/

 */

public class AppGUI extends JFrame {

    //Объект класса-группы
    private static Company com;
    //Создаем экземпляр панелей
    private static final ListPanel listPanel = new ListPanel();
    private static final MainPanel mainPanel = new MainPanel();
    private static final JPanel cardPane = new JPanel();
    private static final AddPanel addPanel = new AddPanel();

    //Создаем toolkit для работы его методами
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    //Получаем размеры экрана
    Dimension screen = toolkit.getScreenSize();

    //Размеры фрейма
    private final int width = 1000;
    private final int height = 600;

    public AppGUI () {
        //Устанавливает заголовок окна
        super("Транспортные средства");

        //Расчитываем позицию по центру
        int posX = screen.width / 2 - width / 2;
        int posY = screen.height / 2 - height / 2;

        //Устанавливаем размеры и позиционирование
        setBounds(posX, posY, width, height);
        //Установим цвет фона
        getCardPane().setBackground(Color.decode("#ffffff"));
        //Установим иконку приложения
        setIconImage(toolkit.getImage(getClass().getResource("train.png")));
        //Устанавливает обработчик для закрытия приложения
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Сделаем окно видимым
        setVisible(true);

        cardPane.setLayout(new CardLayout(0, 0));

        cardPane.add(mainPanel, "Menu");
        cardPane.add(listPanel, "List");
        cardPane.add(addPanel, "Add");

        cardPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        add(cardPane, BorderLayout.CENTER);

      }

    public static void initCom() {
        com = new Company();
    }

    public static Company getCom() {
        return com;
    }

    public static ArrayList<Vehicle> getCarsList() {
        return com.getCarsList();
    }

    public static ArrayList<Vehicle> getExpressList() {
        return com.getExpressList();
    }

    public static void addVehicle(String name, int speed, int weight, String color, int railsCount, String expressType) {
        com.addExpress(name, speed,weight, color, railsCount, expressType);
        listPanel.addVehicle(name, speed,weight, color, railsCount, expressType);
    }

    public static void addVehicle(String name, int speed, int weight, String color, int wheelsCount) {
        com.addCar(name, speed,weight, color, wheelsCount);
        listPanel.addVehicle(name, speed,weight, color, wheelsCount);
    }

    public static JPanel getCardPane() {
        return cardPane;
    }

    public static void deleteVehicle(String name, String type) {
        com.deleteVehicle(name, type);
    }

    public static Vehicle findVehicle(String name, String type) {
        return com.findVehicle(name, type);
    }

    public static Vehicle findVehicle(String name) {
        return com.findVehicle(name);
    }

    public static void updateVehicle(String oldName, String name, int speed, int weight, String color, int wheelsCount) {
        com.updateVehicle(oldName, name, speed, weight, color, wheelsCount);
        listPanel.updateData(oldName, name, speed, weight, color, wheelsCount);
    }

    public static void updateVehicle(String oldName, String name, int speed, int weight, String color, int railsCount, String expressType) {
        com.updateVehicle(oldName, name, speed, weight, color, railsCount, expressType);
        listPanel.updateData(oldName, name, speed, weight, color, railsCount, expressType);
    }

    public static String[] getExpressTypes() {
        return  com.getExpressTypes();
    }
}
