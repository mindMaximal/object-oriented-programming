package lab5_10;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*

    https://wireframe.cc/HCKf8T
    https://wireframe.cc/OQ8kV4

    https://coderoad.ru/40328735/%D0%9A%D0%B0%D0%BA-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-%D0%BA%D0%BD%D0%BE%D0%BF%D0%BA%D0%B8-%D0%B4%D0%BB%D1%8F-%D0%BF%D0%B5%D1%80%D0%B5%D0%BA%D0%BB%D1%8E%D1%87%D0%B5%D0%BD%D0%B8%D1%8F-%D0%BD%D0%B0-%D0%BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D0%B5%D0%BD%D0%BD%D1%8B%D0%B9-JPanel

 */

/*

    Color Scheme:

    1 - #7ebc59 - Зеленый
    2 - #33363b - Черный
    3 - #368cbf - Синий
    4 - #ffffff - Белый

 */

public class AppGUI extends JFrame {

    //Объект класса-группы
    private static Company com;
    //Создаем экземпляр панелей
    private static GeneralListPanel generalListPanel = new GeneralListPanel();;
    private static MainPanel mainPanel = new MainPanel();
    public static JPanel contentPane = new JPanel();
    public static AddPanel addPanel = new AddPanel();

    //Создаем toolkit для работы его методами
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    //Получаем размеры экрана
    Dimension screen = toolkit.getScreenSize();


    //Размеры фрейма
    private final int width = 500;
    private final int height = 300;

    public AppGUI () {
        //Устанавливает заголовок окна
        super("Транспортные средства");

        //Расчитываем позицию по центру
        int posX = (int) (screen.width / 2 - width / 2);
        int posY = (int) (screen.height / 2 - height / 2);

        //Устанавливаем размеры и позиционирование
        setBounds(posX, posY, width, height);
        //Установим цвет фона
        getContentPane().setBackground(Color.decode("#ffffff"));
        //Установим иконку приложения
        setIconImage(toolkit.getImage(getClass().getResource("train.png")));
        //Устанавливает обработчик для закрытия приложения
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Сделаем окно видимым
        setVisible(true);

        //Добавляем основную панель в frame
        //mainPanel = new MainPanel();
//        add(mainPanel);


        contentPane.setLayout(new CardLayout(0, 0));

        contentPane.add(mainPanel, "Menu");
        contentPane.add(generalListPanel, "List");
        contentPane.add(addPanel, "Add");

        contentPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        add(contentPane, BorderLayout.CENTER);

      }

    public static void initCom() {
        com = new Company();
    }

//    public static void showGeneralList() {
//        mainPanel.remove();
//        generalListPanel.showPanel();
//    }

    public ArrayList<Vehicle> getList() {
        return com.getList();
    }
}
