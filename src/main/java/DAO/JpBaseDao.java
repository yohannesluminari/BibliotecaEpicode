package main.java.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JpBaseDao {
    protected static final Logger log = LoggerFactory.getLogger(JpaBaseDao.class);

    protected final EntityManager em = Persistence
            .createEntityManagerFactory("library")
            .createEntityManager();
}
