package dealprocessing.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author CHANDRAYAN
 *
 */
public abstract interface IAbstractDao<PK extends Serializable, T> {

    void create(T objToCreate);

    void delete(T objToDelete);

    void createAndFlush(T objToCreate);

    void deleteAndFlush(T objToDelete);

    T findById(PK key);

    List<T> findAll();

}
