import entity.Alcohol;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class EntityDemo {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("java6");
        EntityManager em = factory.createEntityManager();
        Alcohol beer = new Alcohol();
        beer.setId(1);
        beer.getCapacity(new BigDecimal(0.75));
        beer.setName("Kasztelan");
        beer.setVoltage(new BigDecimal(5.5));
        beer.setCategory("beer");
        em.persist(beer);
        em.close();
    }
}
