package ckmu32.EMQR.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ckmu32.EMQR.modelo.Empleado;

public class empleadoTest {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

	
	public static void main(String[] args) {
				
		imprimirTodo();
		
		insertarPrueba();
		
		imprimirTodo();
		
		emf.close();//Cerrar todo
	}
	
	private static void insertarPrueba() {
		/*Esta parte de código funciona correctamente si se quita la relación bidireccional en EMPLEADO.
		 * La cual está comentada por defecto.
		 * La idea es que para agregar un EMPLEADO se tenga que hacer al momento de agregar un cargo.*/
		EntityManager manager = emf.createEntityManager();
		
		Empleado emp1 = new Empleado("QWERTY12345","92378162144","Mauricio","Pérez","8234FBD","Masculino",
				"Ninguna","TUM-B",LocalDate.of(1993, Month.APRIL, 19));
		Empleado emp2 = new Empleado("OVB53KDS0MN","16878724924","Elizabeth","Murano","B57OZG5","Femenino",
				"Asma","Contaduría",LocalDate.of(1987, Month.OCTOBER, 8));
		
		manager.getTransaction().begin();
		manager.persist(emp1);
		manager.persist(emp2);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		EntityManager manager = emf.createEntityManager();
		//El FROM Reserva; "Reserva" es el nombre dela clase Java, no de la BD 
		 List<Empleado> registros = (List<Empleado>)manager.createQuery("FROM Empleado").getResultList();
		 
		 System.out.println("La base de datos en su tabla EMPLEADO tiene: " + registros.size() +
		 " registros almacenados.");
		 
		 for(Empleado rs:registros) {
				System.out.println(rs.toString());
			}
		 manager.close();
	}
	
	
	
}
