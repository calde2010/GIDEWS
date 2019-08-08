package co.gide.tx.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.gide.tx.Exception.ComponenteException;




public abstract class AdminiPersistencia {
	
	protected static EntityManagerFactory corponenteEntityManagerFactory;
	protected static final String DOCS_JPA_PERSISTENCEUNIT = "gide_PU";
	protected static DocumentoManagenador dm;
	
	
	protected static void iniciarPersistencia() {
		
		if (corponenteEntityManagerFactory==null || !corponenteEntityManagerFactory.isOpen()){
			corponenteEntityManagerFactory = Persistence.createEntityManagerFactory(DOCS_JPA_PERSISTENCEUNIT);
		}
		
		try {
			ManagerFactory.initFactory();
		} catch (ComponenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dm = ManagerFactory.getDocumentManager(corponenteEntityManagerFactory.createEntityManager());
		} catch (ComponenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}
	
	protected static void closePersistencia()
	{
		if (corponenteEntityManagerFactory!=null)
			corponenteEntityManagerFactory.close();	

	}
	
	
}
