/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Car;
import model.Color;
import model.Day;

/**
 *
 * @author Admin
 */
public class ManageShowroom {
    // Function 2: Check and validate customer's request
    public static Car checkCar(Car car, Color color, Day day, String price) throws ExceptionCar {
        List<Car> cars = Arrays.asList(Car.values());

        if (!cars.contains(car)) {
            car = null;
            throw new ExceptionCar("Can't sell Car\nCar break");
        }

        List<Color> availableColors = getColors(car);
        if (!availableColors.contains(color)) {
            throw new ExceptionCar("Can't sell Car\nColor Car does not exit");
        }

        List<Day> soldOnDays = getDaySells(car);
        if (!soldOnDays.contains(day)) {
            throw new ExceptionCar("Can't sell Car\nCar can't sell today");
        }

        List<Integer> prices = getPrices(car);
        try {
            int x = Integer.parseInt(price);
        } catch (Exception e) {
            throw new ExceptionCar("Can't sell Car\nPrice is digit");
        }
        if (!prices.contains(color.equals(Color.NO_COLOR) ? (Integer.parseInt(price) + 100) : Integer.parseInt(price))) {
            if (Integer.parseInt(price) <= 0) {
                throw new ExceptionCar("Can't sell Car\nPrice greater than zero");
            }else{
                throw new ExceptionCar("Can't sell Car\nInvalid price");
            }
        }

        return car;
    }

    public static List<Integer> getPrices(Car car) {
        List<Integer> prices = new ArrayList<>();
        switch (car) {
            case AUDI:
                prices = Arrays.asList(5500, 3000, 4500);
                break;
            case MERCEDES:
                prices = Arrays.asList(5000, 6000, 8500);
                break;
            case BMW:
                prices = Arrays.asList(2500, 3000, 3500);
                break;
        }
        return prices;
    }

    public static List<Color> getColors(Car car) {
        List<Color> colors = new ArrayList<>();
        switch (car) {
            case AUDI:
                colors = Arrays.asList(Color.WHITE, Color.YELLOW, Color.ORANGE, Color.NO_COLOR);
                break;
            case MERCEDES:
                colors = Arrays.asList(Color.GREEN, Color.BLUE, Color.PURPLE, Color.NO_COLOR);
                break;
            case BMW:
                colors = Arrays.asList(Color.PINK, Color.RED, Color.BROWN, Color.NO_COLOR);
                break;
        }
        return colors;
    }

    public static List<Day> getDaySells(Car car) {
        List<Day> days = new ArrayList<>();
        switch (car) {
            case AUDI:
                days = Arrays.asList(Day.FRIDAY, Day.SUNDAY, Day.MONDAY);
                break;
            case MERCEDES:
                days = Arrays.asList(Day.TUESDAY, Day.SATURDAY, Day.WEDNESDAY);
                break;
            case BMW:
                days = Arrays.asList(Day.MONDAY, Day.SUNDAY, Day.THURSDAY);
                break;
        }
        return days;
    }

    public static Car getCar(String carName) {
        try {
            return Car.valueOf(carName);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static Day getDay(String dayName) {
        try {
            return Day.valueOf(dayName);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static Color getColor(String colorName) {
        try {
            if (colorName.equals("NO COLOR")) {
                return Color.NO_COLOR;
            }
            return Color.valueOf(colorName);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
