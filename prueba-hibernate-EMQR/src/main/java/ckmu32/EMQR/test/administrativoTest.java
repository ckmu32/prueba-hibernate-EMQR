package ckmu32.EMQR.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ckmu32.EMQR.modelo.Administrativo;
import ckmu32.EMQR.modelo.Empleado;

public class administrativoTest {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String[] args) {
				
		imprimirTodo();
		
		insertarPrueba();
		
		imprimirTodo();
		
		emf.close();//Cerrar todo
	}
	
	private static void insertarPrueba() {
		EntityManager manager = emf.createEntityManager();
		
		//Crear un ADMINISTRATIVO y a su vez crear un EMPLEADO
		
		Administrativo admin1 = new Administrativo(1,"Finanzas");
		admin1.setEmpleado(new Empleado("OVB53KDS0MN","16878724924","Elizabeth","Murano","B57OZG5","Femenino",
				"Asma","Contaduría",LocalDate.of(1987, Month.OCTOBER, 8)));
		
		Administrativo admin2 = new Administrativo(2,"RH");
		admin2.setEmpleado(new Empleado("HC4275KA46O","34569281052","Jaime","Velasco","29EQ02K","Masculino",
				"Ninguna","Psicología",LocalDate.of(1990, Month.JUNE, 26)));
		
		Administrativo admin3 = new Administrativo(3,"Administración");
		admin3.setEmpleado(new Empleado("FX74BX9FPSQ","03559246200","Elizabeth","Murano","4BW95MN","Femenino",
				"Ninguna","Administración de empresas",LocalDate.of(1975, Month.FEBRUARY, 12)));

		manager.getTransaction().begin();
		manager.persist(admin1);
		manager.persist(admin2);
		manager.persist(admin3);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		EntityManager manager = emf.createEntityManager();
		 List<Administrativo> registros = (List<Administrativo>)manager.createQuery("FROM Administrativo").getResultList();
		 
		 System.out.println("La base de datos en su tabla ADMINISTRATIVO tiene: " + registros.size() +
		 " registros almacenados.");
		 
		 for(Administrativo rs:registros) {
				System.out.println(rs.toString());
			}
		 manager.close();
	}
	
}
