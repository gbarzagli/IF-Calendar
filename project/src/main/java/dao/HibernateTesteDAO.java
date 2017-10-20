package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import model.Teste;
import org.hibernate.query.Query;

/**
 * HibernateTesteDAO
 * Hibernate implementation of the DAO
 * 
 * @author Gabriel Barzagli
 */
public class HibernateTesteDAO implements TesteDAO {

    private static TesteDAO instance;
    private EntityManagerFactory factory;

    private HibernateTesteDAO() {
        factory = Persistence.createEntityManagerFactory("manager");
    }
       

    public static TesteDAO getInstance() {
        if (instance == null) {
            instance = new HibernateTesteDAO();
        }
        return instance; 
    }


	@Override
	public void insert(Teste value) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(value);
        entityManager.getTransaction().commit();
	}


	@Override
	public List<Teste> all() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaQuery<Teste> criteria = entityManager.getCriteriaBuilder().createQuery(Teste.class);
        Query<Teste> query = (Query<Teste>) entityManager.createQuery(criteria);
        return (List<Teste>) query.getResultList();
	}


	@Override
	public void update(Teste object) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
	}


	@Override
	public Teste findByKey(Long id) {
		EntityManager entityManager = factory.createEntityManager();
        return entityManager.find(Teste.class, id);
	}
}