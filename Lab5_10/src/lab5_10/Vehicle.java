package lab5_10;

public abstract class Vehicle {
    //Название транспортного средства
    protected String name;
    //Скорость  транспортного средства
    protected int speed;
    protected int weight;
    protected String color;
    
    //Метод возвращающий название
    public String getName() {
        return name;
    }
    //Метод возвращающий скорость
    public int getSpeed() {
        return speed;
    }
    
    public int getWeight() {
        return weight;
    }
    
    //Стандартный конструктор 
    public Vehicle(String name, int speed, int weight, String color) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.color = color;
    }
    
    //Абстрактный метод, возвращающий нагрузку на колесную или рельсовую базу
    public abstract String getLoad();
    //Абстрактный метод, возвращающий цвет транспортного средства
    public abstract String getColor();
}
