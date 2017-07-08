package dao;

import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import business.Cliente;
import entities.ClienteEntity;
import hibernate.HibernateUtil;
import view.ClienteVO;

public class ClienteDAO {
	
	private static ClienteDAO instancia;
	
	public static ClienteDAO getInstancia()
	{
		if (instancia==null)
			instancia=new ClienteDAO();
		return instancia;
	}

	public void guardarCliente(ClienteEntity ce) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(ce);
		s.getTransaction().commit();
	}

	public Cliente traercliente(int legajo) {
		// TODO Auto-generated method stub
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s= sf.getCurrentSession();
		s.beginTransaction();
		ClienteEntity c= (ClienteEntity) s.get(ClienteEntity.class, legajo);
		Cliente cliente=c.toNegocio();
		s.getTransaction().commit();
		return cliente;
	}

	public void eliminarCliente(ClienteVO c) {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		ClienteEntity cl= (ClienteEntity) s.get(ClienteEntity.class, c.getLegajo());
		s.delete(cl);
		s.getTransaction().commit();
	}
	
	public void actualizarCliente(ClienteEntity c)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(c);
		s.getTransaction().commit();
	}

	public Vector<Cliente> traerTodosLosClientes()
	{
		List<ClienteEntity> aux;
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.getCurrentSession();
			s.beginTransaction();
			Query q = s.createQuery("from ClienteEntity");
			aux = q.list();
			Vector<Cliente> resultado = new Vector<Cliente>();
			for (ClienteEntity ce : aux)
			{
				resultado.add(ce.toNegocio());
			}
			return resultado;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
