package daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;


import entities.InsumoEntity;
import entities.ItemRecetaEntity;
import entities.PrendaEntity;
import entities.PrendaGenericaEntity;
import hibernate.HibernateUtil;
import negocio.Prenda;
import vos.PrendaGenericaVO;
import vos.PrendaVO;

public class PrendaDAO {
	
	private static PrendaDAO instancia;
	
	public static PrendaDAO getInstancia()
	{
		if (instancia==null)
			instancia= new PrendaDAO();
		return instancia;
	}

	public void guardarPrenda(PrendaEntity prenda) {
		try
		{
			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session s= sf.openSession();
			s.beginTransaction();
			s.saveOrUpdate(prenda);
			s.getTransaction().commit();
			s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}

	public List<PrendaGenericaEntity> traerTodasLasGenericas() {
		// TODO Auto-generated method stub
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s= sf.openSession();
		s.beginTransaction();
		List<PrendaGenericaEntity> lista = (List<PrendaGenericaEntity>)s.createQuery("from PrendaGenericaEntity").list();
		s.getTransaction().commit();
		s.close();
		return lista;
	}

	public void agregarItemPrendas(ItemRecetaEntity i, PrendaEntity p) {
		// TODO Auto-generated method stub
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s= sf.openSession();
		s.beginTransaction();
		p.AgregarItem(i);
		s.saveOrUpdate(p);
		s.getTransaction().commit();
		s.close();
				
	}

	public List<PrendaEntity> traerEspecificas(PrendaGenericaVO prenda) {
		// TODO Auto-generated method stub
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		List<PrendaEntity> lista= s.createQuery("from PrendaEntity p where p.prenda.codigo ='"+prenda.getCodigo()+"'").list();
		s.getTransaction().commit();
		s.close();
		return lista;
	}

	public PrendaEntity traerEspecifica(PrendaVO prenda) {
		// TODO Auto-generated method stub
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		String hql="from PrendaEntity p where p.prenda.codigo='"+prenda.getPrenda().getCodigo()+"' and p.color.color='"+prenda.getColor()+"' and p.talle.talle='"+prenda.getTalle()+"'";
		System.out.println(hql);
		List<PrendaEntity> lista= s.createQuery(hql).list();
		PrendaEntity res= lista.get(0);
		return res;
	}
	
	public void updatePrenda(PrendaEntity entity) {
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(entity);
			s.beginTransaction().commit();
			s.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
