package jdbc;

import kovynev.Entity.Entity;
import kovynev.jdbc.Service;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceTest {
    @Test
public void update(){
        Service service = new Service();
        Entity entity = new Entity();
        entity.setId(242);
        entity.setDateTime(123);
        entity.setUsdRub(30);
        service.update(entity);
    }
    @Test
    public void readMA(){
        Service service = new Service();
        double result = service.readMA(5);
        System.out.println(result);
        Assertions.assertNotEquals(0.0, result);

    }
}
