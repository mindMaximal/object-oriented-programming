package lab5_10;

public class Car extends Vehicle {
    //Поле, отвечающее за количество колес
    private int wheelsCount;
    
    //Стандартный конструктор
    public Car(String name, int speed, int weight, String color, int wheelsCount) {
        //Передаем параметры в конструктор родителя
        super(name, speed, weight, color);
        //Заполняем поля этого класса
        this.wheelsCount = wheelsCount;
    }

    public Car(int id, String name, int speed, int weight, String color, int wheelsCount) {
        //Передаем параметры в конструктор родителя
        super(id, name, speed, weight, color);
        //Заполняем поля этого класса
        this.wheelsCount = wheelsCount;
    }

    @Override
    public Object[] getObject() {
        return new String[] {
                name, Integer.toString(speed), Integer.toString(weight), color, Integer.toString(wheelsCount)
        };
    }

    @Override
    public void updateVehicle(Object[] object) {
        this.name = object[0].toString();
        this.speed = Integer.parseInt(object[1].toString());
        this.weight = Integer.parseInt(object[2].toString());
        this.color = object[3].toString();
        this.wheelsCount =  Integer.parseInt(object[4].toString());

        System.out.printf("Обновлено ТС: %s %d %d %s %d %n", name, speed, weight, color, wheelsCount);
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