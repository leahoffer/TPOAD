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
		try
		{
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session s= sf.getCurrentSession();
			s.beginTransaction();
			s.save(cEntity);
			s.getTransaction().commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ClienteEntity buscarCliente(ClienteEntity ce){
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			ClienteEntity res = new ClienteEntity();
			res = (ClienteEntity) s.get(ClienteEntity.class, ce.getLegajo());
			s.close();
			return res;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void eliminarCliente(ClienteEntity ce) {
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.delete(ce);
			s.beginTransaction().commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
