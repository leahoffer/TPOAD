package daos;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.PedidoPrendaEntity;
import hibernate.HibernateUtil;

public class PedidoDAO {
	
	private static PedidoDAO instancia;
	
	public static PedidoDAO getInstancia()
	{
		if (instancia==null)
			instancia=new PedidoDAO();
		return instancia;
	}
	
	public void guardarPedido(PedidoPrendaEntity p)
	{
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s= sf.getCurrentSession();
		s.beginTransaction();
		s.save(p);
		s.getTransaction().commit();
	}

}
