package ckmu32.EMQR.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ckmu32.EMQR.modelo.Empleado;
import ckmu32.EMQR.modelo.Labora_en_una;
import ckmu32.EMQR.modelo.TAMP;
import ckmu32.EMQR.modelo.Unidad;

public class labora_en_unaTest {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String[] args) {
				
		imprimirTodo();
		
		insertarPrueba();
		
		insertarConBusqueda();
		
		imprimirTodo();
		
		emf.close();//Cerrar todo
	}
	
	private static void insertarPrueba() {
		EntityManager manager = emf.createEntityManager();
		
		/*Insertamos primero los TAMP, lo cuál insertará empleados a su vez*/
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
				
		/*Insertamos UNIDAD*/
				Unidad ud1 = new Unidad("EMQR-32","AG36DB1353","WBM-89-32","Sprinter","Básica",2007);
				Unidad ud2 = new Unidad("EMQR-01","VNS573KP25","MOR-30-11","F-450","Rescate",2010);
				Unidad ud3 = new Unidad("EMQR-26","AG36DB1353","ZXK-51-00","Sprinter","Avanzada",2015);

				manager.getTransaction().begin();
				manager.persist(ud1);
				manager.persist(ud2);
				manager.persist(ud3);
				manager.getTransaction().commit();
				
		/*Para crear la relación, se tiene que buscar primero al TAMP y asignarle una UNIDAD*/
				//Se hará prueba con los objetos previamente creados para probar que funciona.
		/*		
		 		Labora_en_una unitTAMP1 = new Labora_en_una(1,LocalDateTime.of(2018,Month.APRIL,7,19,43),LocalDateTime.of(2018,Month.APRIL,8,3,43));
				unitTAMP1.setTamp(tamp1);
				unitTAMP1.setUnidad(ud3);
				
				Labora_en_una unitTAMP2 = new Labora_en_una(2,LocalDateTime.of(2018,Month.APRIL,7,19,43),LocalDateTime.of(2018,Month.APRIL,8,3,43));
				unitTAMP2.setTamp(tamp2);
				unitTAMP2.setUnidad(ud3);
				
				manager.getTransaction().begin();
				manager.persist(unitTAMP1);
				manager.persist(unitTAMP2);
				manager.getTransaction().commit();
		*/
				
				manager.close();
	}
	
	private static void insertarConBusqueda() {//Así es como se debería relacionar. Se busca y se agrega.
		EntityManager manager = emf.createEntityManager();
		
		//Búsqueda de UNIDAD
		Unidad unidadBusqueda = manager.find(Unidad.class,"EMQR-26");
		
		//Búsqueda de TAMP
		TAMP tampBusqueda1 = manager.find(TAMP.class, 1);
		TAMP tampBusqueda2 = manager.find(TAMP.class, 2);
		
		//Creamos relación con los datos encontrados;
		if(unidadBusqueda!=null && tampBusqueda1!=null && tampBusqueda2!=null) {
			Labora_en_una unitTAMP1 = new Labora_en_una(1,LocalDateTime.of(2018,Month.APRIL,7,19,43),LocalDateTime.of(2018,Month.APRIL,8,3,43));
			unitTAMP1.setTamp(tampBusqueda1);
			unitTAMP1.setUnidad(unidadBusqueda);
			
			Labora_en_una unitTAMP2 = new Labora_en_una(2,LocalDateTime.of(2018,Month.APRIL,7,19,43),LocalDateTime.of(2018,Month.APRIL,8,3,43));
			unitTAMP2.setTamp(tampBusqueda2);
			unitTAMP2.setUnidad(unidadBusqueda);
			
			manager.getTransaction().begin();
			manager.persist(unitTAMP1);
			manager.persist(unitTAMP2);
			manager.getTransaction().commit();
			
			System.out.println("TAMP y UNIDAD relacionados correctamente.");
		}else
			System.out.println("No sé encontró la UNIDAD o TAMP buscados.");
		
		manager.close();
			
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		EntityManager manager = emf.createEntityManager();
		 List<Labora_en_una> registros = (List<Labora_en_una>)manager.createQuery("FROM Labora_en_una").getResultList();
		 
		 System.out.println("La base de datos en su tabla LABORA_EN_UNA tiene: " + registros.size() +
		 " registros almacenados.");
		 
		 for(Labora_en_una rs:registros) {
				System.out.println(rs.toString());
			}
		 manager.close();
	}
}
