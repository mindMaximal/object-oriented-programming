package lab5_10;

public class Express extends Train {
    //Поле, отвечающее за тип экспресса
    private final String exressType;
    
    //Стандартный конструктор
    public Express(String name, int speed, int weight, String color, int railCount, String exressType) {
        //Передаем параметры в конструктор родителя
        super(name, speed, weight, color, railCount);
          //Заполняем поля этого класса
        this.exressType = exressType;
    }

    @Override
    public Object[] getObject() {
        return new String[] {
                name, Integer.toString(speed), Integer.toString(weight), color, Integer.toString(railCount), exressType
        };
    }
    
    //Метод для получения типа экспресса
    public String getType() {
        return exressType;
    }
    //Перегружаем метод родителя для получения цвета
    @Override
    public String getColor() {
        return "Вагоны поезда типа - " + name + " имееют " + color + " цвет";
    }
    
}
