package app.GenericDao;



import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GenericDao<T, Id> {
    void create(T t);
    void update(T t);
    void delete(T t);
    T find(T t, Id id);
    List<T> findAll(T T);
    List<T> findWhere(T T, String where, Map<String, String> params);
    Integer count(T t);

}
