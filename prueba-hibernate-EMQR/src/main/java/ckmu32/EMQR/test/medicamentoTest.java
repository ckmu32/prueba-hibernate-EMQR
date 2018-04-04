package ckmu32.EMQR.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ckmu32.EMQR.modelo.Medicamento;

public class medicamentoTest {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String[] args) {
				
		imprimirTodo();
		
		insertarPrueba();
		
		imprimirTodo();
		
		emf.close();//Cerrar todo
	}
	
	private static void insertarPrueba() {
		EntityManager manager = emf.createEntityManager();
		
		Medicamento med1 = new Medicamento(1,"Solución Hartamn", LocalDate.of(2020, 2, 19),"1.5 litros","Intravenosa");
		Medicamento med2 = new Medicamento(2,"Narcan", LocalDate.of(2019, 7, 1),"1 gramo","Intravenosa");
		Medicamento med3 = new Medicamento(3,"Carbón activado", LocalDate.of(2025, 3, 12),"350 gramos","Oral");
		
		manager.getTransaction().begin();
		manager.persist(med1);
		manager.persist(med2);
		manager.persist(med3);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		EntityManager manager = emf.createEntityManager();
		 List<Medicamento> registros = (List<Medicamento>)manager.createQuery("FROM Medicamento").getResultList();
		 
		 System.out.println("La base de datos en su tabla MEDICAMENTO tiene: " + registros.size() +
		 " registros almacenados.");
		 
		 for(Medicamento rs:registros) {
				System.out.println(rs.toString());
			}
		 manager.close();
	}
}
