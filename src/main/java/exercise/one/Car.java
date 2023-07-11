package exercise.one;

public class Car {

    private int engineCapacity;
    private short productionYear;
    private String brand;
    private String model;

    //return true when car is Euro V
    public boolean get() {
        boolean e;
        e = false;

        if (engineCapacity > 3000) {
            if (productionYear > 2015) {
                e = true;
            }
        }
        return e;
    }

    public String getCarType() {
        if (engineCapacity < 1500) {
            return "slow";
        } else {
            return "fast";
        }
    }

}
