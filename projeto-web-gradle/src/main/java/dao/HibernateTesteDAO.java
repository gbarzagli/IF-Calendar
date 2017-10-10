package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Teste;
import org.hibernate.query.Query;

/**
 * HibernateTesteDAO
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
        Query query = (Query) entityManager.createQuery("FROM Teste t");
		return (List<Teste>) query.getResultList();
	}
}