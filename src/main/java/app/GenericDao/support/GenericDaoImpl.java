package app.GenericDao.support;

import app.GenericDao.GenericDao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public abstract class   GenericDaoImpl<T, Id extends Serializable> implements GenericDao<T, Id>{
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    public void create(T t) {
        this.sessionFactory.getCurrentSession().save(t);
    }

    @Transactional(readOnly = false)
    public void delete(T t) {
        this.sessionFactory.getCurrentSession().delete(t);
    }

    @Transactional(readOnly = false)
    public void update(T t) {
        this.sessionFactory.getCurrentSession().update(t);
    }

    @Transactional(readOnly = false)
    public T find(T t, Id id) {
        return (T) this.sessionFactory.getCurrentSession().get(t.getClass(), id);
    }

    @Transactional(readOnly = true)
    public List<T> findAll(T t){
        Query query = this.sessionFactory.getCurrentSession().createQuery("from " + t.getClass().getName());
        return query.list();
    }
    @Transactional(readOnly = false)
    public Integer count(T t){
        Query query = this.sessionFactory.getCurrentSession().createQuery("from " + t.getClass().getName());
        return query.list().size();
    }

    @Override
    public List<T> findWhere(T T, String where, Map<String, String> params) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from " + T.getClass().getName() + " where " + where);
        for(Map.Entry<String, String> entry : params.entrySet()){
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
