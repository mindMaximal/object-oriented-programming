package lab5_10;

public abstract class Vehicle {
    //Название транспортного средства
    protected String name;
    //Скорость  транспортного средства
    protected int speed;
    protected int weight;
    protected String color;

    //Стандартный конструктор
    public Vehicle(String name, int speed, int weight, String color) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.color = color;
    }

    //Метод возвращающий название
    public String getName() {
        return name;
    }
    //Метод возвращающий скорость
    public int getSpeed() {
        return speed;
    }
    //Метод возвращающий вес
    public int getWeight() {
        return weight;
    }
    //Метод возвращающий данные о ТС в виде объекта
    public Object[] getObject() {
        return new String[] {
                name, Integer.toString(speed), Integer.toString(weight), color
        };
    }

    //Абстрактный метод, возвращающий нагрузку на колесную или рельсовую базу
    public abstract String getLoad();

    //Абстрактный метод, возвращающий цвет транспортного средства
    public abstract String getColor();

    public abstract void updateVehicle(Object[] object);
}
