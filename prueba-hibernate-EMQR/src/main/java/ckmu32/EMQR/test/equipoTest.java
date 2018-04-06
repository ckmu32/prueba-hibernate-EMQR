package ckmu32.EMQR.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ckmu32.EMQR.modelo.Equipo;


public class equipoTest {

private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String[] args) {
				
		imprimirTodo();
		
		insertarPrueba();
		
		imprimirTodo();
		
		emf.close();//Cerrar todo
	}
	
	private static void insertarPrueba() {
		EntityManager manager = emf.createEntityManager();
		
		Equipo eq1 = new Equipo(1, "Tabla rígida MEXK", "Férula Espinal Larga", LocalDate.of(2000, Month.DECEMBER, 05));
		Equipo eq2 = new Equipo(2, "Collarín convertible AMBU", "Collarín Cervical", LocalDate.of(2003, Month.MARCH, 30));
		Equipo eq3 = new Equipo(3, "Camilla Stryker AutoLoad", "Carro Camilla", LocalDate.of(2007, Month.NOVEMBER, 21));

		manager.getTransaction().begin();
		manager.persist(eq1);
		manager.persist(eq2);
		manager.persist(eq3);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		EntityManager manager = emf.createEntityManager();
		 List<Equipo> registros = (List<Equipo>)manager.createQuery("FROM Equipo").getResultList();
		 
		 System.out.println("La base de datos en su tabla EQUIPO tiene: " + registros.size() +
		 " registros almacenados.");
		 
		 for(Equipo rs:registros) {
				System.out.println(rs.toString());
			}
		 manager.close();
	}
}
