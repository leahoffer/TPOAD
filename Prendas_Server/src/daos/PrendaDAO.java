package daos;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.PrendaEntity;
import hibernate.HibernateUtil;

public class PrendaDAO {
	
	private static PrendaDAO instancia;
	
	public static PrendaDAO getInstancia()
	{
		if (instancia==null)
			instancia= new PrendaDAO();
		return instancia;
	}

	public void guardarPrenda(PrendaEntity prenda) {
		// TODO Auto-generated method stub
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s= sf.getCurrentSession();
		s.beginTransaction();
		s.save(prenda);
		s.getTransaction().commit();
		
	}

}
