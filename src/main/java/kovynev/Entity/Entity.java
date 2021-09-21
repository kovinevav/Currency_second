package kovynev.Entity;

public class Entity {
    long id;
    long dateTime;
    double usdRub;
    double ma1;
    double ma2;
    double ma3;

    public void setId(int id) {
        this.id = id;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public void setUsdRub(double usdRub) {
        this.usdRub = usdRub;
    }

    public void setMa1(double ma1) {
        this.ma1 = ma1;
    }

    public void setMa2(double ma2) {
        this.ma2 = ma2;
    }

    public void setMa3(double ma3) {
        this.ma3 = ma3;
    }

    public long getId() {
        return id;
    }

    public double getDateTime() {
        return dateTime;
    }

    public double getUsdRub() {
        return usdRub;
    }

    public double getMa1() {
        return ma1;
    }

    public double getMa2() {
        return ma2;
    }

    public double getMa3() {
        return ma3;
    }
}
