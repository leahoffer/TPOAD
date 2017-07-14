package daos;

import java.util.ArrayList;
import java.util.List;
import negocio.UbicacionPrenda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.UbicacionPrendaEntity;
import hibernate.HibernateUtil;

public class UbicacionDAO {

	private static UbicacionDAO instancia;
	
	public static UbicacionDAO getInstancia()
	{
		if (instancia==null)
			instancia= new UbicacionDAO();
		return instancia;
	}
	
	public void guardarUbicacion(UbicacionPrendaEntity upe)
	{
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.save(upe);
		s.getTransaction().commit();
	}
	
	public List<UbicacionPrenda> traerUbicaciones()
	{
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s= sf.getCurrentSession();
		s.beginTransaction();
		List<UbicacionPrendaEntity> ube= s.createQuery("from UbicacionPrendaEntity").list();
		List<UbicacionPrenda> res= new ArrayList<UbicacionPrenda>();
		for (UbicacionPrendaEntity u: ube)
		{
			res.add(u.toNegocio());
		}
		return res;
	}
}
