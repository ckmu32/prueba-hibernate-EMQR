package ckmu32.EMQR.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ckmu32.EMQR.modelo.Unidad;


public class unidadTest {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String[] args) {
				
		imprimirTodo();
		
		insertarPrueba();
		
		imprimirTodo();
		
		emf.close();//Cerrar todo
	}
	
	private static void insertarPrueba() {
		EntityManager manager = emf.createEntityManager();
		
		Unidad ud1 = new Unidad("EMQR-32","AG36DB1353","WBM-89-32","Sprinter","Básica",2007);
		Unidad ud2 = new Unidad("EMQR-01","VNS573KP25","MOR-30-11","F-450","Rescate",2010);
		Unidad ud3 = new Unidad("EMQR-26","AG36DB1353","ZXK-51-00","Sprinter","Avanzada",2015);

		manager.getTransaction().begin();
		manager.persist(ud1);
		manager.persist(ud2);
		manager.persist(ud3);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		EntityManager manager = emf.createEntityManager();
		 List<Unidad> registros = (List<Unidad>)manager.createQuery("FROM Unidad").getResultList();
		 
		 System.out.println("La base de datos en su tabla UNIDAD tiene: " + registros.size() +
		 " registros almacenados.");
		 
		 for(Unidad rs:registros) {
				System.out.println(rs.toString());
			}
		 manager.close();
	}
}
