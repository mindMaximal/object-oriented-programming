package lab5_10;

import javax.swing.*;
import java.awt.*;

/*
    frame.pack();
    размер кнопок
    контейнеры

    https://wireframe.cc/HCKf8T
 */

/*

    Color Scheme:

    1 - #7ebc59 - Зеленый
    2 - #33363b - Черный
    3 - #368cbf - Синий
    4 - #ffffff - Белый

 */

public class AppGUI extends JFrame {

    //Создаем toolkit для работы его методами
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    //Получаем размеры экрана
    Dimension screen = toolkit.getScreenSize();
    //Создаем экземпляр панелей
    MainPanel mainPanel = new MainPanel();


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
        add(mainPanel);

    }
}
