package daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ItemPedidoPEntity;
import entities.PedidoPrendaEntity;
import entities.PrendaEntity;
import hibernate.HibernateUtil;
import vos.PrendaVO;

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
		for (ItemPedidoPEntity ie: p.getItems())
		{
			ie.setPrenda((PrendaEntity) s.get(PrendaEntity.class, ie.getPrenda().getId()));
		}
		s.save(p);
		s.getTransaction().commit();
	}
	
	public List<PedidoPrendaEntity> mostrarPedidosSinValidar()
	{
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			List<PedidoPrendaEntity> res = (List<PedidoPrendaEntity>) s.createQuery("from PedidoPrendaEntity pp where pp.estado = 'Invalido'").list();
			s.getTransaction().commit();
			return res;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
