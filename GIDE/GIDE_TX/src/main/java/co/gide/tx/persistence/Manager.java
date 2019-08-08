package co.gide.tx.persistence;

import java.util.Date;

import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class Manager {

	protected EntityManager entityManager;
	/** The log. */
	protected Log log = null;

	protected void configManager(EntityManager pEntityManager) throws Exception {
		this.entityManager = pEntityManager;

	}

	protected EntityManager getCurrentEntityManger() {
		return entityManager;
	}

	public Boolean insertarEstadoDIAN(Integer UID_EMPR, String NOM_TABL, Integer UID_DOEL, Integer TIP_DOEL,
			String TIP_ACTU, Date FEC_DATO, Integer EST_DATO) {
		// TODO Auto-generated method stub
		return null;
	}

}
