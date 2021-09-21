package kovynev.bl;

import kovynev.jdbc.Util;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.sql.*;

public class Analyses extends Util {
    Connection connection;
   // Cash cash = Cash.create();

    {
        try {
            connection = connection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean canIBuyStrategy24_72() {
        Segment lastSegmentMA24 = getLastSegment();
        Segment lastSegmentMA72 = getLastSegment();

        if (trend(24) > 0
                && trend(72) > 0
                && lastSegmentMA24.intersection(lastSegmentMA72)
        ) return true;
        else return false;
    }


    private Segment getLastSegment() {
        double[] x = new double[2];
        double[] y = new double[2];
        String sql = "SELECT id, usdrub from currencylayer.currency ORDER BY id DESC LIMIT 2";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            int n = 0;
            while (set.next()) {
                x[n] = set.getInt("id");
                y[n] = set.getDouble("usdRub");
                n++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Segment(x[0], y[0], x[1], y[1]);

    }


    public double trend(int hours) {
        SimpleRegression regression = new SimpleRegression();
        regression.addData(getDateOfDays(hours));
        return regression.getSlope();
    } //Смотрим тренд


    private double[][] getDateOfDays(int hours) {
        String sql = "select id, usdrub from currencylayer.currency order by id desc limit  " + hours;
        double[][] arrayOfDate = new double[hours][2];
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int row = 0;

            while (resultSet.next()) {
                arrayOfDate[row][0] = resultSet.getDouble(1);
                arrayOfDate[row][1] = resultSet.getDouble(2);
                row++;
            }


        } catch (SQLException ignored) {
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayOfDate;
    }
}
