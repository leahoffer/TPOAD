package daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ItemPedidoPEntity;
import entities.PedidoPrendaEntity;
import entities.PrendaEntity;
import hibernate.HibernateUtil;
import negocio.PedidoPrenda;
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
			List<PedidoPrendaEntity> res = (List<PedidoPrendaEntity>) s.createQuery("from PedidoPrendaEntity pp where pp.estado = 'Pendiente'").list();
			s.getTransaction().commit();
			return res;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public PedidoPrenda buscarPedido(int nro){
		try{
			PedidoPrendaEntity ppe;
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			List<PedidoPrendaEntity> pps =  s.createQuery(
					"select p " +
					"from PedidoPrendaEntity p " +
					"join fetch p.items i " +
					"join fetch i.prenda pr " +
					"join fetch pr.prenda prg " +
					"join fetch prg.colores").list();
			return pps.get(0).toNegocio();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void updatearEstadoPedido(PedidoPrenda pedidoPrenda) {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=s.createQuery("update PedidoPrendaEntity set estado = ? where numero = ?");
		q.setString(0, pedidoPrenda.getEstado().toString());
		q.setInteger(1, pedidoPrenda.getNro());
		q.executeUpdate();
		s.getTransaction().commit();
	}

}
