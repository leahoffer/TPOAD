package daos;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ClienteEntity;
import hibernate.HibernateUtil;
import vos.ClienteVO;

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
	
	public ClienteEntity buscarCliente(int legajo){
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			ClienteEntity res = (ClienteEntity) s.get(ClienteEntity.class, legajo);
			s.getTransaction().commit();
			return res;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void eliminarCliente(ClienteVO cvo) {
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			ClienteEntity c= (ClienteEntity) s.get(ClienteEntity.class, cvo.getLegajo());
			s.delete(c);
			s.beginTransaction().commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
