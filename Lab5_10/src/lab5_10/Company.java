package lab5_10;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Company {
    //Список для хранения объектов
    protected ArrayList<Vehicle> carList = new ArrayList<>();
    protected ArrayList<Vehicle> expressList = new ArrayList<>();
    protected String[] expressTypes;
    //Поле для получения случайного числа
    private final Random rnd = new Random();
    private Database db;

    //Стандартный конструктор
    public Company() {
        db = new Database();

        try {
            db.setConnection();

            carList = db.read("cars");

            expressList = db.read("express");

            db.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Подключение закрыто");
        }

        expressTypes = new String[] {
                "Междугородний",
                "Региональный",
                "Скоростной",
                "Местной линии"
        };
    }
    
    //Метод, добавляющий новое транспортное средство в список - машина
    public void addCar(String name, int speed, int weight, String color, int wheelsCount) {
        //Создаем объект класса Car
        Car carTmp = new Car(name, speed, weight, color, wheelsCount);
        //Добавляем объект в список

        try {
            db.setConnection();

            db.add(name, speed, weight, color, wheelsCount);

            carList.add(carTmp);
            db.close();

            System.out.println("Транспортное средство добавлено");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Подключение закрыто");
        }

    }
    //Метод, добавляющий новое транспортное средство в список - экспресс
    public void addExpress(String name, int speed, int weight, String color, int railCount, String expressType) {
        //Создаем объект класса Express
        Express expressTmp = new Express(name, speed, weight, color, railCount, expressType);
        //Добавляем объект в список
        expressList.add(expressTmp);


        try {
            db.setConnection();

            db.add(name, speed, weight, color, railCount, expressType);

            expressList.add(expressTmp);
            db.close();

            System.out.println("Транспортное средство добавлено");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Подключение закрыто");
        }
    }

    private void randomVehicles(int count) {
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
                    expressType = rnd.nextInt(2) == 0 ? "Междугородний" : "Региональный";
                    railCount = 2;

                    //Создаем объект класса Express
                    Express expressTmp = new Express(name, speed, weight, color, railCount, expressType);
                    //Добавляем объект в список
                    expressList.add(expressTmp);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + rnd.nextInt(2));
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
                //Получаем номер наденного объекта
                index = list.indexOf(vehicleTmp);
                vehicle = vehicleTmp;
                //Ставим флаг, что найдено
                isFind = true;
            }
        }
        
        if (isFind) {
            //Удалить полученный объект
            try {
                db.setConnection();

                int id = vehicle.getId();
                String vehicleType = vehicle instanceof Car ? "cars" : vehicle instanceof Express ? "express" : null;

                db.remove(id, vehicleType);

                list.remove(index);
                db.close();

                System.out.println("Транспортное средство добавлено");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Подключение закрыто");
            }

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

            try {
                db.setConnection();

                int id = vehicle.getId();

                db.update(id, name, speed, weight, color, wheelsCount);

                vehicle.updateVehicle(object);

                db.close();


            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Подключение закрыто");
            }
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


            try {
                db.setConnection();

                int id = vehicle.getId();

                db.update(id, name, speed, weight, color, railsCount, expressType);

                vehicle.updateVehicle(object);

                db.close();


            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Подключение закрыто");
            }
        }
    }

    public String[] getExpressTypes() {
        return expressTypes;
    }
}