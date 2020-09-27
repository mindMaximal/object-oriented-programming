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
        System.out.println("Транспортное средство добавлено");
    }
    //Метод, добавляющий новое транспортное средство в список - экспресс
    public void addExpress(String name, int speed, int weight, String color, int railCount, String expressType) {
        //Создаем объект класса Express
        Express expressTmp = new Express(name, speed, weight, color, railCount, expressType);
        //Добавляем объект в список
        expressList.add(expressTmp);
        System.out.println("Транспортное средство добавлено");
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
                    expressType = rnd.nextInt(2) == 0 ? "Междугородний" : "Региональный";
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
    public Vehicle findVehicle(String name, String type) {
        //Объект для хранения необходимого транспортного средства
        Vehicle vehicle = null;

        ArrayList<Vehicle> list = null;

        if (type.equals("CARS")) {
            list = carList;
        } else if (type.equals("EXPRESS")) {
            list = expressList;
        }

        //Переберем список
        assert list != null;
        for(Vehicle vehicleTmp : list) {
            //Получим имя, полученного объекта
            String nameTmp = vehicleTmp.getName();
            //Если имена совпали, то
            if (nameTmp.equals(name)) {
                //Записываем полученный объект
                vehicle = vehicleTmp;
            }
        }

        return vehicle;
    }

    public Vehicle findVehicle(String name) {
        Vehicle vehicle = null;

        for (Vehicle vehicleTmp : carList) {
            //Получим имя, полученного объекта
            String nameTmp = vehicleTmp.getName();
            //Если имена совпали, то
            if (nameTmp.equals(name)) {
                //Записываем полученный объект
                vehicle = vehicleTmp;
            }
        }

        if (vehicle == null) {
            for (Vehicle vehicleTmp : expressList) {
                //Получим имя, полученного объекта
                String nameTmp = vehicleTmp.getName();
                //Если имена совпали, то
                if (nameTmp.equals(name)) {
                    //Записываем полученный объект
                    vehicle = vehicleTmp;
                }
            }
        }

        return vehicle;
    }
    //Метод удаления транспортного средства
    public void deleteVehicle(String name, String type) {
        boolean isFind = false;
        int index = 0;

        ArrayList<Vehicle> list = null;

        if (type.equals("CARS")) {
            list = carList;
        } else if (type.equals("EXPRESS")) {
            list = expressList;
        }

        
        //Переберем список
        assert list != null;
        for(Vehicle vehicleTmp : list) {
            //Получим имя, полученного объекта
            String nameTmp = vehicleTmp.getName();
            //Если имена совпали, то
            if (nameTmp.equals(name)) {
                //Получаем номер наденного объекта
                index = list.indexOf(vehicleTmp);
                //Ставим флаг, что найдено
                isFind = true;
            }
        }
        
        if (isFind) {
            //Удалить полученный объект
            list.remove(index);
            System.out.println("Транспортное средство удалено");
        } else {
            System.out.println("Транспортное средство не найдено");
        }
    }

    public void updateVehicle(String oldName, String name, int speed, int weight, String color, int wheelsCount) {
        Vehicle vehicle = null;

        for(Vehicle vehicleTmp : carList) {
            //Получим имя, полученного объекта
            String nameTmp = vehicleTmp.getName();
            //Если имена совпали, то
            if (nameTmp.equals(oldName)) {
                //Записываем полученный объект
                vehicle = vehicleTmp;
            }
        }

        if (vehicle != null) {
            Object[] object = {name, speed, weight, color, wheelsCount};

            vehicle.updateVehicle(object);
        }
    }

    public void updateVehicle(String oldName, String name, int speed, int weight, String color, int railsCount, String expressType) {
        Vehicle vehicle = null;

        for(Vehicle vehicleTmp : expressList) {
            //Получим имя, полученного объекта
            String nameTmp = vehicleTmp.getName();
            //Если имена совпали, то
            if (nameTmp.equals(oldName)) {
                //Записываем полученный объект
                vehicle = vehicleTmp;
            }
        }

        if (vehicle != null) {
            Object[] object = {name, speed, weight, color, railsCount, expressType};

            vehicle.updateVehicle(object);
        }
    }

}