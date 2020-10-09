package lab5_10;

public abstract class Train extends Vehicle {
    //Поле, отвечающее за количество рельс
    protected int railCount;

    public Train(String name, int speed, int weight, String color, int railCount) {
        //Передаем параметры в конструктор родителя
        super(name, speed, weight, color);
        //Заполняем поля этого класса
        this.railCount = railCount;
    }
    
    //Перегружаем метод родителя для получения максимальной нагрузки на рельсовую базу
    @Override
    public  String getLoad() {
        float load = weight / railCount;
        return "Максимальная нагрузка на рельсовую базу " + load;
    }    
    //Перегружаем метод родителя для получения цвета
    @Override
    abstract public String getColor();
}