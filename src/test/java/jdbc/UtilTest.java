package jdbc;

import kovynev.jdbc.Util;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class UtilTest {
    @Test
    public void shouldnNotGetNull() throws SQLException {
        Assertions.assertNotNull(new Util().connection());
    }
}
