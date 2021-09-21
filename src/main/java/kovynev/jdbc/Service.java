package kovynev.jdbc;

import kovynev.Entity.Entity;

import java.sql.*;

public class Service extends Util implements DAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    @Override
    public void update(Entity entity) {
        try {
            connection = connection();
            String sql = "INSERT INTO currencylayer.currency (id,dateTime, usdrub) values (DEFAULT, ?,?)";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, entity.getDateTime());
            preparedStatement.setDouble(2, entity.getUsdRub());
            preparedStatement.executeUpdate();
            System.out.println("Update");


        } catch (SQLException e) {


        }
        finally {
          if(connection != null) {
              try {
                  connection.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
        }


    }

    @Override
    public double readMA(int count) {
        try{
            connection = connection();
            //String sql = "ELECT avg(usdrub) from (select usdrub from currencylayer.currency order by id DESC limit   " + count + ")  as subquery_alisas";
            String sql = "select avg(usdrub) from currencylayer.currency order by id DESC limit   "+ count;
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                return set.getDouble(1);
            }
        }catch (SQLException e){

        }
        return 0;
    }
}
