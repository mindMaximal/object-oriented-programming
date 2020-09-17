package lab5_10;

public class Car extends Vehicle {
    //Поле, отвечающее за количество колес
    private int wheelsCount = 0;
    
    //Стандартный конструктор
    public Car(String name, int speed, int weight, String color, int wheelsCount) {
        //Передаем параметры в конструктор родителя
        super(name, speed, weight, color);
        //Заполняем поля этого класса
        this.wheelsCount = wheelsCount;
    }

    //Перегружаем метод родителя для получения максимальной нагрузки на колесную базу
    @Override
    public String getLoad() {
        float load = weight / wheelsCount;
        return "Максимальная нагрузка на колесную базу составляет " + load;
    }
    
    //Перегружаем метод родителя, возвращающий цвет автомобиля
    @Override
    public String getColor() {
        return name + " имеет " + color + " цвет";
    }
    
}