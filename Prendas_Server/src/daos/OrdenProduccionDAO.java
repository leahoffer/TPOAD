package daos;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.OrdenProduccionEntity;
import hibernate.HibernateUtil;

public class OrdenProduccionDAO {
	
	private static OrdenProduccionDAO instancia;
	
	public static OrdenProduccionDAO getInstancia()
	{
		if (instancia==null)
			instancia= new OrdenProduccionDAO();
		return instancia;
	}

	public void guardarOrden(OrdenProduccionEntity ope)
	{
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s= sf.getCurrentSession();
		s.beginTransaction();
		s.save(ope);
		s.getTransaction().commit();
	}
}
