import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityDemo {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("java6");
    }
}
