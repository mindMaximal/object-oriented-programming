package lab5_10;

import java.util.ArrayList;
import java.util.Random;

public class Company {
    //Список для хранения объектов
    protected ArrayList<Vehicle> vehicles = new ArrayList<>();
    //Поле для получения случайного числа
    final Random rnd = new Random();
    
    //Стандартный конструктор
    public Company() {
        //Поля для объектов
        String name;
        int speed;
        int weight;
        String color;
        int wheelsCount;
        String expressType;
        int railCount;
        
        //Счетчики 
        int carsCount = 0;
        int expressCount = 0;
        
        //Заполним список 10 случайными объектами
        for (int i = 0; i < 10; i++) {
            //С помощью случайных чисел добавим объекты
            switch(rnd.nextInt(2)) {
                case(0): 
                    carsCount++;
                    //Заполним поля
                    name = "car " + carsCount;
                    speed = rnd.nextInt(150);
                    weight = rnd.nextInt(500) + 1000;
                    color = "белый";
                    wheelsCount = rnd.nextInt(4) + 2;
                    
                    //Создаем объект класса Car
                    Car carTmp = new Car(name, speed, weight, color, wheelsCount);
                    //Добавляем объект в список
                    vehicles.add(carTmp);
                    break;
                case(1):
                    expressCount++;
                    //Заполним поля
                    name = "express " + expressCount;
                    speed = rnd.nextInt(350);
                    weight = rnd.nextInt(1000) + 2000;
                    color = "синий";
                    wheelsCount = rnd.nextInt(4) + 2;
                    expressType = "междугородний";
                    railCount = 2;
                    
                    //Создаем объект класса Express
                    Express expressTmp = new Express(name, speed, weight, color, railCount, expressType);
                    //Добавляем объект в список
                    vehicles.add(expressTmp);
                    break;
            }
        }
    }
    
    //Метод, добавляющий новое транспортное средство в список - машина
    public void addVehicle(String name, int speed, int weight, String color, int wheelsCount) {
        //Создаем объект класса Car
        Car carTmp = new Car(name, speed, weight, color, wheelsCount);
        //Добавляем объект в список
        vehicles.add(carTmp);
    }
    //Метод, добавляющий новое транспортное средство в список - экспресс
    public void addVehicle(String name, int speed, int weight, String color, int railCount, String expressType) {
        //Создаем объект класса Express
        Express expressTmp = new Express(name, speed, weight, color, railCount, expressType);
        //Добавляем объект в список
        vehicles.add(expressTmp);
    }

    //Метод, возвращающий список всех транспортных средств
    public ArrayList<Vehicle> getList() {
        return vehicles;
    }
    //Метод поиска транспортного средства
    public String findVehicle(String name) {
        //Результат работы функции
        String result = "";
        //Объект для хранения необходимого транспортного средства
        Vehicle vehicle = null;
        
        //Переберем список
        for(Vehicle vehicleTmp : vehicles) {
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
        for(Vehicle vehicleTmp : vehicles) {
            //Получим имя, полученного объекта
            String nameTmp = vehicleTmp.getName();
            //Если имена совпали, то
            if (nameTmp.equals(name)) {
                //Получаем номер наденного объекта
                index = vehicles.indexOf(vehicleTmp);
                //Ставим флаг, что найдено
                isFind = true;
            }
        }
        
        if (isFind) {
            //Удалить полученный объект
            vehicles.remove(index);
            System.out.println("Транспортное средство удалено");
        } else {
            System.out.println("Транспортное средство не найдено");
        }
    }
}