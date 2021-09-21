package kovynev.bl;

import java.io.*;
import java.util.Properties;

public class Cash {
    private static Cash instance;
    double usd;
    double rub;

    @Override
    public String toString() {
        return "Cash{" +
                "usd=" + usd +
                ", rub=" + rub +
                '}';
    }

    File file = new File("src/main/resources/strategy24_72.properties");
    Properties properties = new Properties();

    public Cash() {
        try {
            properties.load(new FileInputStream(file));
            usd = Double.parseDouble(properties.getProperty("usd"));
            rub = Double.parseDouble(properties.getProperty("rub"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static Cash create() {
        if (instance == null) {
            instance = new Cash();
        }
        return instance;

    }

    public boolean buyUSD(int n, double cost) {
        double needOfRub = cost * n;
        if (needOfRub <= rub) {
            rub -= needOfRub;
            usd += n;
            properties.setProperty("usd", String.valueOf(usd));
            properties.setProperty("rub", String.valueOf(rub));
            return true;
        } else return false;
    }

    public boolean sellUSD(int n, double cost) {
        if (n < usd) {
            usd -= n;
            rub += (n * cost);
            properties.setProperty("usd", String.valueOf(usd));
            properties.setProperty("rub", String.valueOf(rub));
            return true;
        } else return false;
    }
}
