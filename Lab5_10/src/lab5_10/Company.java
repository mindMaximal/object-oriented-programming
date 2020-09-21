package lab5_10;

import java.util.ArrayList;
import java.util.Random;

public class Company {
    //Список для хранения объектов
    protected ArrayList<Vehicle> carList = new ArrayList<>();
    protected ArrayList<Vehicle> expressList = new ArrayList<>();
    //Поле для получения случайного числа
    final Random rnd = new Random();

    //Поля для объектов
    protected String name;
    protected int speed;
    protected int weight;
    protected String color;
    protected int wheelsCount;
    protected String expressType;
    protected int railCount;
    
    //Стандартный конструктор
    public Company() {
        //Заполним список 10 случайными объектами
        randomVehicles(5);
    }
    
    //Метод, добавляющий новое транспортное средство в список - машина
    public void addCar(String name, int speed, int weight, String color, int wheelsCount) {
        //Создаем объект класса Car
        Car carTmp = new Car(name, speed, weight, color, wheelsCount);
        //Добавляем объект в список
        carList.add(carTmp);
    }
    //Метод, добавляющий новое транспортное средство в список - экспресс
    public void addExpress(String name, int speed, int weight, String color, int railCount, String expressType) {
        //Создаем объект класса Express
        Express expressTmp = new Express(name, speed, weight, color, railCount, expressType);
        //Добавляем объект в список
        expressList.add(expressTmp);
    }

    public void randomVehicles(int count) {

        //Счетчики
        int carsCount = 0;
        int expressCount = 0;

        for (int i = 0; i < count; i++) {
            //С помощью случайных чисел добавим объекты
            switch(rnd.nextInt(2)) {
                case(0):
                    carsCount++;
                    //Заполним поля
                    name = "car " + carsCount;
                    speed = rnd.nextInt(150);
                    weight = rnd.nextInt(500) + 1000;
                    color = rnd.nextInt(2) == 0 ? "белый" : "синий";
                    wheelsCount = rnd.nextInt(4) + 2;

                    //Создаем объект класса Car
                    Car carTmp = new Car(name, speed, weight, color, wheelsCount);
                    //Добавляем объект в список
                    carList.add(carTmp);
                    break;
                case(1):
                    expressCount++;
                    //Заполним поля
                    name = "express " + expressCount;
                    speed = rnd.nextInt(350);
                    weight = rnd.nextInt(1000) + 2000;
                    color = "синий";
                    wheelsCount = rnd.nextInt(4) + 2;
                    expressType = rnd.nextInt(2) == 0 ? "Междугородний" : "Региональный";;
                    railCount = 2;

                    //Создаем объект класса Express
                    Express expressTmp = new Express(name, speed, weight, color, railCount, expressType);
                    //Добавляем объект в список
                    expressList.add(expressTmp);
                    break;
            }
        }
    }

    //Метод, возвращающий список всех транспортных средств
    public ArrayList<Vehicle> getCarsList() {
        return carList;
    }
    //Метод, возвращающий список всех транспортных средств
    public ArrayList<Vehicle> getExpressList() {
        return expressList;
    }
    //Метод поиска транспортного средства
    public String findVehicle(String name) {
        //Результат работы функции
        String result = "";
        //Объект для хранения необходимого транспортного средства
        Vehicle vehicle = null;
        
        //Переберем список
        for(Vehicle vehicleTmp : carList) {
            //Получим имя, полученного объекта
            String nameTmp = vehicleTmp.getName();
            //Если имена совпали, то
            if (nameTmp.equals(name)) {
                //Записываем полученный объект
                vehicle = vehicleTmp;
            }
        }
        
        //Если объект не найден, то
        if (vehicle == null) {
            //Выведем информцаию о этом
            return "Не найдено";
        }
        
        //Получим информацию
        result += "\r\nНазвание: " + vehicle.getName() + "\r\n";
        result += "Скорость: " + vehicle.getSpeed() + " км/ч\r\n";
        result += "Вес: " + vehicle.getSpeed() + " кг\r\n";
        result += "Цвет: " + vehicle.getColor() + "\r\n";
        result += "Максимальная нагрузка: " + vehicle.getLoad() + "\r\n";

        //Если это объект класса Express
        if (vehicle instanceof Express) {
            //Приведем тип к Express
            result += "Тип экспресса " + ((Express) vehicle).getType() + "\r\n";
        }
        
        return result;
    } 
    //Метод удаления транспортного средства
    public void deleteVehicle(String name) {
        boolean isFind = false;
        int index = 0;
        
        //Переберем список
        for(Vehicle vehicleTmp : carList) {
            //Получим имя, полученного объекта
            String nameTmp = vehicleTmp.getName();
            //Если имена совпали, то
            if (nameTmp.equals(name)) {
                //Получаем номер наденного объекта
                index = carList.indexOf(vehicleTmp);
                //Ставим флаг, что найдено
                isFind = true;
            }
        }
        
        if (isFind) {
            //Удалить полученный объект
            carList.remove(index);
            System.out.println("Транспортное средство удалено");
        } else {
            System.out.println("Транспортное средство не найдено");
        }
    }
}