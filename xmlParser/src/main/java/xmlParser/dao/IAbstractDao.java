package xmlParser.dao;

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

    void update(T objToUpdate);

    void createAndFlush(T objToCreate);

    void deleteAndFlush(T objToDelete);

    void updateAndFlush(final T objToUpdate);

    T findById(PK key);

    List<T> findAll();

}
