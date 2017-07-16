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

	public int guardarOrden(OrdenProduccionEntity ope)
	{
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s= sf.getCurrentSession();
		s.beginTransaction();
		s.save(ope);
		int nro=ope.getNro();
		s.getTransaction().commit();
		return nro;
	}
	
	public OrdenProduccion traerOrden(int numero)
	{
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			OrdenProduccionEntity ope = (OrdenProduccionEntity)s.load(OrdenProduccionEntity.class, numero);
			s.beginTransaction().commit();
			OrdenProduccion op = ope.toNegocio();
			s.close();
			return op;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int traerSiguienteNumeroDeOrden()
	{
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			OrdenProduccionEntity ope = new OrdenProduccionEntity();
			int i = (int) s.createQuery("select ope.nro from OrdenProduccionEntity ope order by nro asc").setFirstResult(0).setMaxResults(1).uniqueResult();
			return i+1;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return -1;
	}

	public void updateOrden(OrdenProduccionEntity entity) {
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.update(entity);
			s.beginTransaction().commit();
			s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
