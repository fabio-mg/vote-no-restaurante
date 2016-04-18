package DAO;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;
 

@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {
    protected EntityManager entityManager;

    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 
    public T findById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }
 
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
    public void update(T entity) {
        entityManager.merge(entity);
    }
 
    public void delete(T entity) {
        entityManager.remove(entity);
    }
 
    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
