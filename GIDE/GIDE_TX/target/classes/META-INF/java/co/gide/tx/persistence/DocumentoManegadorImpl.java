package co.gide.tx.persistence;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import co.gide.tx.entities.GnAmbienteW;
import co.gide.tx.entities.TbClientes;
import co.gide.tx.entities.TbFirmaDigital;
import co.gide.tx.entities.TbParametros;
import co.gide.tx.entities.TbRangoFacturacion;
import co.gide.tx.entities.TbResolucionFacturacion;
import co.gide.tx.entities.TbSoftware;
import co.gide.tx.entities.TbSwResolCliente;

public class DocumentoManegadorImpl extends Manager implements DocumentoManagenador {

	// TRAE LA COPNFIGURACION DE LA EMPRESA /
	@Override
	public GnAmbienteW getAmbiente(String usuario, String token, String numIdent, String TipoDoc, String prefijo,
			int consecutivo) {

		EntityManager entmng = null;
		GnAmbienteW resolucionEmpresas = null;
		try {

			entmng = getCurrentEntityManger();

			StringBuilder querystr = new StringBuilder();
			querystr.append(" FROM GnAmbienteW WS ").append(" WHERE ")
					.append(" :fConsecutivo  BETWEEN    WS.numeroInicial and     WS.numeroFinal    ")
					.append(" and WS.usuario = :fUsuario    ").append("  and WS.token  = :fToken  ")
					.append("  and WS.idTipoIdentificacion  = :fTipoDoc  ")
					.append("  and WS.numIdentificacion     = :fNumIdent  ");

			if (prefijo != null && !prefijo.equals("")) {
				querystr.append(" AND WS.prefijo = :fPrefijo ");
			} else {
				querystr.append(" AND WS.prefijo = null ");
			}

			// Parametros
			TypedQuery<GnAmbienteW> jpaquery = entmng.createQuery(querystr.toString(), GnAmbienteW.class);

			if (prefijo != null && !prefijo.equals("")) {
				jpaquery.setParameter("fPrefijo", prefijo);
			}
			jpaquery.setParameter("fUsuario", usuario);
			jpaquery.setParameter("fToken", token);
			jpaquery.setParameter("fNumIdent", numIdent);
			jpaquery.setParameter("fTipoDoc", TipoDoc);
			jpaquery.setParameter("fConsecutivo", consecutivo);

			// jpaquery.setParameter("fechaFiltro", fecha);

			resolucionEmpresas = jpaquery.getSingleResult(); // resolucionEmpresa =
			jpaquery.getSingleResult();
		} catch (NoResultException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return resolucionEmpresas;
	}

	public Integer insertarEstado(Integer UID_EMPR, String NOM_TABL, Date FEC_DOEL, String PRE_DOEL, Integer NUM_DOEL,
			Integer TIP_DOEL, String COD_CUFE, Date FEC_RECI, Integer EST_RECI, Date FEC_PROC, Integer EST_PROC,
			Date FEC_FIRM, Integer EST_FIRM, Date FEC_TXDI, Integer EST_TXDI) {

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_EDOC_INSERTA_PRIMERA_VEZ")
				.registerStoredProcedureParameter("UID_EMPR", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("NOM_TABL", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("FEC_DOEL", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("PRE_DOEL", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("NUM_DOEL", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("TIP_DOEL", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("COD_CUFE", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("FEC_RECI", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("EST_RECI", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("FEC_PROC", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("EST_PROC", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("FEC_FIRM", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("EST_FIRM", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("UID_DOEL", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("MSG_ERRO", String.class, ParameterMode.OUT)
				.setParameter("UID_EMPR", UID_EMPR).setParameter("NOM_TABL", NOM_TABL)
				.setParameter("FEC_DOEL", FEC_DOEL).setParameter("PRE_DOEL", PRE_DOEL)
				.setParameter("NUM_DOEL", NUM_DOEL).setParameter("TIP_DOEL", TIP_DOEL)
				.setParameter("COD_CUFE", COD_CUFE).setParameter("FEC_RECI", FEC_RECI)
				.setParameter("EST_RECI", EST_RECI).setParameter("FEC_PROC", FEC_PROC)
				.setParameter("EST_PROC", EST_PROC).setParameter("FEC_FIRM", FEC_FIRM)
				.setParameter("EST_FIRM", EST_FIRM);

		query.execute();

		String msgError = (String) query.getOutputParameterValue("MSG_ERRO");

		if (msgError == null) {

			return (Integer) query.getOutputParameterValue("UID_DOEL");

		} else {

			return new Integer(0);
		}

	}

	public Boolean ActualizarEstadoDIAN(Integer UID_EMPR, String NOM_TABL, Integer UID_DOEL, Integer TIP_DOEL,
			String TIP_ACTU, Date FEC_DATO, Integer EST_DATO) {

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_EDOC_ACTUALIZA_PROCESO")
				.registerStoredProcedureParameter("UID_EMPR", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("NOM_TABL", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("UID_DOEL", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("TIP_DOEL", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("TIP_ACTU", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("FEC_DATO", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("EST_DATO", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("MSG_ERRO", String.class, ParameterMode.OUT)
				.setParameter("UID_EMPR", UID_EMPR).setParameter("NOM_TABL", NOM_TABL)
				.setParameter("UID_DOEL", UID_DOEL).setParameter("TIP_DOEL", TIP_DOEL)
				.setParameter("TIP_ACTU", TIP_ACTU).setParameter("FEC_DATO", FEC_DATO)
				.setParameter("EST_DATO", EST_DATO);

		query.execute();

		String msgError = (String) query.getOutputParameterValue("MSG_ERRO");

		if (msgError == null) {

			return true;

		} else {

			return false;
		}
	}


/*	public Ftpio buscarFTP(String numDocu) {

		EntityManager entmng = null;
		Ftpio co.gide.tx.ftp = null;
		try {

			entmng = getCurrentEntityManger();

			StringBuilder querystr = new StringBuilder();
			querystr.append(" FROM Ftpio f ").append(" WHERE f.numIden =:numDocu ");

			// Parametros
			TypedQuery<Ftpio> jpaquery = entmng.createQuery(querystr.toString(), Ftpio.class);

			jpaquery.setParameter("numDocu", numDocu);

			co.gide.tx.ftp = jpaquery.getSingleResult();
			// resolucionEmpresa = jpaquery.getSingleResult();
		} catch (NoResultException e) {
			e.getStackTrace();
		} catch (co.gide.tx.Exception e) {
			e.printStackTrace();

		}
		return co.gide.tx.ftp;
	}
*/
	@Override
	public String insertarEstado(Integer UID_DOEL, Integer UID_EMPR, String NOM_TABL, Date FEC_DOEL, String PRE_DOEL,
			Integer NUM_DOEL, Integer TIP_DOEL, String COD_CUFE, Date FEC_RECI, Integer EST_RECI, Date FEC_PROC,
			Integer EST_PROC, Date FEC_FIRM, Integer EST_FIRM, Date FEC_TXDI, Integer EST_TXDI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean crearCliente(TbClientes cliente) {

		EntityManager entmng = null;

		try {

			entmng = getCurrentEntityManger();
			entmng.getTransaction().begin();
			entmng.merge(cliente);
			entmng.getTransaction().commit();
		} catch (NoResultException e) {
			entmng.getTransaction().rollback();
			e.getStackTrace();
			return false;
		} catch (Exception e) {
			entmng.getTransaction().rollback();
			return false;

		}
		return true;
	}

	@Override
	public boolean crearSoftware(TbSoftware software) {

		EntityManager entmng = null;

		try {

			entmng = getCurrentEntityManger();
			entmng.getTransaction().begin();
			entmng.merge(software);
			entmng.getTransaction().commit();
		} catch (NoResultException e) {
			entmng.getTransaction().rollback();
			e.getStackTrace();
			return false;
		} catch (Exception e) {
			entmng.getTransaction().rollback();
			return false;

		}
		return true;
	}

	@Override
	public boolean crearParametros(TbParametros parametro) {
		EntityManager entmng = null;

		try {

			entmng = getCurrentEntityManger();
			entmng.getTransaction().begin();
			entmng.merge(parametro);
			entmng.getTransaction().commit();
		} catch (NoResultException e) {
			entmng.getTransaction().rollback();
			e.getStackTrace();
			return false;
		} catch (Exception e) {
			entmng.getTransaction().rollback();
			return false;

		}
		return true;
	}

	@Override
	public boolean crearRango(TbRangoFacturacion rangoFacturacion) {
		EntityManager entmng = null;

		try {

			entmng = getCurrentEntityManger();
			entmng.getTransaction().begin();
			entmng.merge(rangoFacturacion);
			entmng.getTransaction().commit();
		} catch (NoResultException e) {
			entmng.getTransaction().rollback();
			e.getStackTrace();
			return false;
		} catch (Exception e) {
			entmng.getTransaction().rollback();
			return false;

		}
		return true;
	}

	@Override
	public boolean crearFirmaDigital(TbFirmaDigital firmaDigital) {
		EntityManager entmng = null;

		try {

			entmng = getCurrentEntityManger();
			entmng.getTransaction().begin();
			entmng.merge(firmaDigital);
			entmng.getTransaction().commit();
		} catch (NoResultException e) {
			entmng.getTransaction().rollback();
			e.getStackTrace();
			return false;
		} catch (Exception e) {
			entmng.getTransaction().rollback();
			return false;

		}
		return true;
	}

	@Override
	public boolean crearResolucion(TbResolucionFacturacion resolucionFacturacion) {
		EntityManager entmng = null;

		try {

			entmng = getCurrentEntityManger();
			entmng.getTransaction().begin();
			entmng.merge(resolucionFacturacion);
			entmng.getTransaction().commit();
		} catch (NoResultException e) {
			entmng.getTransaction().rollback();
			e.getStackTrace();
			return false;
		} catch (Exception e) {
			entmng.getTransaction().rollback();
			return false;

		}
		return true;
	}

	@Override
	public boolean crearRelacion(TbSwResolCliente tbSwResolCliente) {
		EntityManager entmng = null;

		try {

			entmng = getCurrentEntityManger();
			entmng.getTransaction().begin();
			entmng.merge(tbSwResolCliente);
			entmng.getTransaction().commit();
		} catch (NoResultException e) {
			entmng.getTransaction().rollback();
			e.getStackTrace();
			return false;
		} catch (Exception e) {
			entmng.getTransaction().rollback();
			return false;

		}
		return true;
	}

}
