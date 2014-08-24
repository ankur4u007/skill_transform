/**
 *
 */
package dealprocessing.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author CHANDRAYAN
 *
 */
public abstract class AbstractDao<PK extends Serializable, T> extends HibernateDaoSupport implements
IAbstractDao<PK, T> {

    private final Class<T> domainObj;

    /**
     *
     */
    @SuppressWarnings("unchecked")
    public AbstractDao() {
	final Type t = getClass().getGenericSuperclass();
	final ParameterizedType pt = (ParameterizedType) t;
	domainObj = (Class<T>) pt.getActualTypeArguments()[1];
    }

    public void create(final T objToCreate) {
	getHibernateTemplate().save(objToCreate);

    }

    public void delete(final T objToDelete) {
	getHibernateTemplate().delete(objToDelete);

    }

    public void createAndFlush(final T objToCreate) {
	getHibernateTemplate().save(objToCreate);
	getHibernateTemplate().flush();

    }

    public void deleteAndFlush(final T objToDelete) {
	getHibernateTemplate().delete(objToDelete);
	getHibernateTemplate().flush();
    }

    public T findById(final PK key) {
	return getHibernateTemplate().load(domainObj, key);
    }

    public List<T> findAll() {
	return getHibernateTemplate().loadAll(domainObj);
    }

    @Autowired
    private void setHibernateTemplateInSuper(final HibernateTemplate hibernateTemplate) {
	setHibernateTemplate(hibernateTemplate);
    }

}
