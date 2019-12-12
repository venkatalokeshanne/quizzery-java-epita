package fr.quizzery.www.services;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;



@Repository
public abstract class GenericDAO<T> {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(T t) {
		
		entityManager.persist(t);

	}
	
	
	
	public void update(T t) {

		entityManager.merge(t);

	}
	
	@Transactional
	public void delete(T t) {
		entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
	}

	public T getById(Serializable id, Class<T> clazz) {

		return entityManager.find(clazz, id);
	}
	
	public List<T> search(T criteria){
		List<T> result =null;
			try {
				Query query= entityManager.createQuery(getQueryString());
				
				Map<String, Object> parameters = new LinkedHashMap<String, Object>();
				getParameters(parameters,criteria);
				
				parameters.forEach((k,v) -> query.setParameter(k,v));
				result=(List<T>) query.getResultList();
				entityManager.getTransaction().begin();
				entityManager.getTransaction().commit();
				
			} catch (Exception e) {
			}
			finally {
				entityManager.close();
		    }
			return result;
		
		
		
	}
	
	
	public List<T> getQuestionList(){
		List<T> result =null;
			try {
				Query query= entityManager.createQuery(getQuestionQueryString());
				
				result=(List<T>) query.getResultList();
				entityManager.getTransaction().begin();
				entityManager.getTransaction().commit();
				
			} catch (Exception e) {
			}
			finally {
				entityManager.close();
		    }
			return result;
	}
	
	
	
	protected abstract void getParametersChoice(Map<Integer, Object> parameters, T criteria);
	protected abstract void getParameters(Map<String, Object> parameters, T criteria);

	protected abstract String getQueryString();
	protected abstract String getQuestionQueryString();
}
