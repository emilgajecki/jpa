import entity.Alcohol;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class EntityDemo {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("java6");
    static EntityManager em = factory.createEntityManager();
    static Scanner scanner = new Scanner(System.in);

    static int menu() {
        System.out.print("1. Dodaj encję ");
        System.out.print("2. Wyświetl wszystkie encje ");
        System.out.print("3. Edytuj encję ");
        System.out.print("4. Usuń encję " );
        System.out.print("0. Wyjście");

        while (!scanner.hasNextInt()) {
            System.out.println("Wpisz nr polecenia!");
        }

        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    static void printAllEntities (){
        List<Alcohol> list = em.createQuery("from Alcohol ", Alcohol.class).getResultList();
        list.forEach(System.out::println);
    }

    static void addEntitu() {


        //beer.setId(1);
        System.out.println("Podaj nazwę: ");
        String name = scanner.nextLine();
        System.out.println("Podaje kategorię: ");
        String category = scanner.nextLine();
        System.out.println("Podaj zawartość");
        float voltage = scanner.nextFloat();
        System.out.println("Podaj pojemność:");
        float capacity = scanner.nextFloat();


        Alcohol beer = new Alcohol();
        beer.setCapacity(new BigDecimal(capacity));
        beer.setName(name);
        beer.setVoltage(new BigDecimal(voltage));
        beer.setCategory(category);
        // wywołanie tranzakcji - aby dane dodały się do bazy
        em.getTransaction().begin();
        em.persist(beer);
        em.getTransaction().commit();
        em.close();
    }

    public static void main(String[] args) {

        while(true){
            switch (menu()){
                case 1:
                    addEntitu();
                    break;
                case 2:
                    printAllEntities();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    return;
                default:
            }
        }
    }
}
