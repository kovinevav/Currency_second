package kovynev.jdbc;

import kovynev.Entity.Entity;

public interface DAO {
    void update(Entity entity);
    double readMA(int count);

}
