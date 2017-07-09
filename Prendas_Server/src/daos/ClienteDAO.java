package daos;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ClienteEntity;
import hibernate.HibernateUtil;

public class ClienteDAO {
	
	private static ClienteDAO instancia;
	
	public static ClienteDAO getInstancia()
	{
		if (instancia==null)
			instancia=new ClienteDAO();
		return instancia;
	}

	public void guardarCliente(ClienteEntity cEntity) {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s= sf.getCurrentSession();
		s.beginTransaction();
		s.save(cEntity);
		s.getTransaction().commit();
		
	}

}
