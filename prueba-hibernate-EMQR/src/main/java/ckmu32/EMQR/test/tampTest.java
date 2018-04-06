package ckmu32.EMQR.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ckmu32.EMQR.modelo.Empleado;
import ckmu32.EMQR.modelo.TAMP;

public class tampTest {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String[] args) {
				
		imprimirTodo();
		
		insertarPrueba();
		
		imprimirTodo();
		
		emf.close();//Cerrar todo
	}
	
	private static void insertarPrueba() {
		EntityManager manager = emf.createEntityManager();
		
		//Crear un TAMP y a su vez crear un EMPLEADO
		TAMP tamp1 = new TAMP(1,"Avanzado","KS32SGSD454");
		tamp1.setEmpleado(new Empleado("PCERVH18B30","12373002144","Charlotte","Montés","21O4F9T","Femenino",
				"Ninguna","TUM-A",LocalDate.of(1993, Month.APRIL, 15)));
		
		TAMP tamp2 = new TAMP(2,"Básico","285NVS84241");
		tamp2.setEmpleado(new Empleado("QWERTY12345","92378162144","Mauricio","Pérez","8234FBD","Masculino",
				"Ninguna","TUM-B",LocalDate.of(1990, Month.OCTOBER, 10)));
		
		TAMP tamp3 = new TAMP(3,"Intermedio","OS28KB2200E");
		tamp3.setEmpleado(new Empleado("EBB96P01MM7","06322936010","Jorge","Vázquez","BC74KO5","Masculino",
				"Ninguna","TUM-I",LocalDate.of(1998, Month.SEPTEMBER, 30)));

		manager.getTransaction().begin();
		manager.persist(tamp1);
		manager.persist(tamp2);
		manager.persist(tamp3);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		EntityManager manager = emf.createEntityManager();
		 List<TAMP> registros = (List<TAMP>)manager.createQuery("FROM TAMP").getResultList();
		 
		 System.out.println("La base de datos en su tabla TAMP tiene: " + registros.size() +
		 " registros almacenados.");
		 
		 for(TAMP rs:registros) {
				System.out.println(rs.toString());
			}
		 manager.close();
	}
}
