package daos;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.OrdenProduccionEntity;
import hibernate.HibernateUtil;
import negocio.OrdenProduccion;

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
	
	public OrdenProduccion traerOrden(int numero)
	{
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			OrdenProduccionEntity ope = (OrdenProduccionEntity)s.get(OrdenProduccionEntity.class, numero);
			s.beginTransaction().commit();
			s.close();
			OrdenProduccion op = ope.toNegocio();
			return op;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
