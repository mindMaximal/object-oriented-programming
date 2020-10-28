package lab5_10;

public class Express extends Train {
    //Поле, отвечающее за тип экспресса
    private String expressType;

    //Стандартный конструктор
    public Express(String name, int speed, int weight, String color, int railCount, String expressType) {
        //Передаем параметры в конструктор родителя
        super(name, speed, weight, color, railCount);
          //Заполняем поля этого класса
        this.expressType = expressType;
    }

    public Express(int id, String name, int speed, int weight, String color, int railCount, String expressType) {
        //Передаем параметры в конструктор родителя
        super(id, name, speed, weight, color, railCount);
        //Заполняем поля этого класса
        this.expressType = expressType;
    }

    @Override
    public Object[] getObject() {
        return new String[] {
                name, Integer.toString(speed), Integer.toString(weight), color, Integer.toString(railCount), expressType
        };
    }

    //Метод для получения типа экспресса
    public String getType() {
        return expressType;
    }
    //Перегружаем метод родителя для получения цвета
    @Override
    public String getColor() {
        return "Вагоны поезда типа - " + name + " имееют " + color + " цвет";
    }

    @Override
    public void updateVehicle(Object[] object) {
        this.name = object[0].toString();
        this.speed = Integer.parseInt(object[1].toString());
        this.weight = Integer.parseInt(object[2].toString());
        this.color = object[3].toString();
        this.railCount = Integer.parseInt(object[4].toString());
        this.expressType = object[5].toString();

        System.out.printf("Обновлено ТС: %s %d %d %s %d %s %n", name, speed, weight, color, railCount, expressType);
    }

}
