package bl;

import kovynev.bl.Request;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestTest {
    @Test()
    public void shouldNotGetException() {
        Request request = new Request();
        Assertions.assertNotNull(request.getDateTime());
        Assertions.assertNotNull(request.getUsd_rub());

    }
}
