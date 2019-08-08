package co.gide.tx.persistence;

import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.gide.tx.Exception.CodigoErrores;
import co.gide.tx.Exception.ComponenteException;
import co.gide.tx.util.PartyEntityUtils;






/**
 * Clase para la creacion de factorias de Managers e instanciacion de persistencia JPA
 * @version 1.0
 */
public class ManagerFactory {

	/**
	 * Implementaciones de factorias disponibles
	 */

	public static final String DEFAULT_DOCUMENT_MANAGER_IMPLEMENTATION = "co.gide.tx.persistence.DocumentoManegadorImpl";
	private Log log; 
	
	/** Informa si la configuracion de la factoria esta cargada o no */
	private boolean isConfigured = false;
	/**
	 * Instancia unica permitida de la factoria
	 */
	private static ManagerFactory instance = null;

	private ManagerFactory()
	{
		log = LogFactory.getLog(ManagerFactory.class);
	}	
	
	
	/**Instanciacion del manager de documentos por defecto
	 * @return
	 * @throws RuntimeCorporateException
	 */
	public static synchronized DocumentoManagenador getDocumentManager(EntityManager entityManager) throws ComponenteException {

		return getDocumentManager(ManagerFactory.DEFAULT_DOCUMENT_MANAGER_IMPLEMENTATION, entityManager);
	}
	
	/**Instanciacion del manager de documentos determinado como parametro
	 * @return
	 * @throws RuntimeCorporateException
	 */
	public static synchronized DocumentoManagenador getDocumentManager(String managerImplementation, EntityManager entityManager) 
	throws ComponenteException {

		if (!instance.isConfigured)
			throw new ComponenteException("ManagerFactory no esta inicializado", CodigoErrores.FACTORY_NOT_INITIALIZED);
		else
			return (DocumentoManagenador) createNewManager(managerImplementation, entityManager);
	}

	/**
	 * Configura un nuevo Manager para la implementacion indicada
	 * @param managerImplementation
	 * @return
	 * @throws RuntimeCorporateException
	 */
	private static synchronized Manager createNewManager(String managerImplementation, EntityManager entityManager) throws ComponenteException
	{
		Manager manager;
		
		try
		{
			manager = (Manager) PartyEntityUtils.newInstance(managerImplementation);
			manager.configManager(entityManager);			
			return manager;			
		}
		catch (IllegalArgumentException ia)
		{
			throw new ComponenteException("Error al instanciar la clase de implementacion del manager [" + managerImplementation + "]", 
					CodigoErrores.ERROR_CREATINGIMPLCLASS_MANAGER,ia);			
		}
		catch (Exception e)
		{
			throw new ComponenteException("Error al configurar el manager de implementacion [" + managerImplementation + "]", 
					CodigoErrores.ERROR_CONFIGURINGIMPLCLASS_MANAGER,e);
		}		
	}
	
	/**Inicializa la factoriade managers PERO NO LA de documentos
	 * 
	 * @param externalB2bDocsEntityManagerFactory 
	 * @throws RuntimeCorporateException
	 */
	public static synchronized void initFactory() throws ComponenteException {

		if (instance==null || !instance.isConfigured)
		{    	    
			
			try
			{
				instance = new ManagerFactory();
				instance.isConfigured = true;
				instance.log.info("ManagerFactory started.");
			}

			catch(Exception e)
			{
				throw new ComponenteException("Error creando ManagerFactory:", 
						CodigoErrores.ERROR_CREATINGCORPORATEMANAGERFACTORY,  e);
			}
	    }			
	}
		
}