package ckmu32.EMQR.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ckmu32.EMQR.modelo.Paciente;

public class pacienteTest {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String[] args) {
				
		imprimirTodo();
		
		insertarPrueba();
		
		imprimirTodo();
		
		emf.close();//Cerrar todo
	}
	
	private static void insertarPrueba() {
		EntityManager manager = emf.createEntityManager();
		
		Paciente pc1 = new Paciente("Carlos Ramírez","Masculino",15);
		Paciente pc2 = new Paciente("Samantha Velarde", "Femenino", 38);
		Paciente pc3 = new Paciente("José Pérez","Masculino",25);

		manager.getTransaction().begin();
		manager.persist(pc1);
		manager.persist(pc2);
		manager.persist(pc3);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		EntityManager manager = emf.createEntityManager();
		 List<Paciente> registros = (List<Paciente>)manager.createQuery("FROM Paciente").getResultList();
		 
		 System.out.println("La base de datos en su tabla PACIENTE tiene: " + registros.size() +
		 " registros almacenados.");
		 
		 for(Paciente rs:registros) {
				System.out.println(rs.toString());
			}
		 manager.close();
	}
}
