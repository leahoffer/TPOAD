package daos;

import java.util.ArrayList;
import java.util.List;

import negocio.Insumo;
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
	
	
	public UbicacionPrenda traerUbicacionMasAlta()
	{
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			List<UbicacionPrendaEntity> ubicaciones;
			String hql = "from UbicacionPrendaEntity upe order by upe.ubicacion desc";
			ubicaciones = s.createQuery(hql).list();
			UbicacionPrendaEntity resultado = ubicaciones.get(0);
			return resultado.toNegocio();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public float traerStockI(Insumo i) {
		// TODO Auto-generated method stub
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s= sf.getCurrentSession();
		s.beginTransaction();
		float resultado = 0;
		List<UbicacionInsumoEntity> ube= s.createQuery("from UbicacionInsumoEntity where codigo='"+i.getCodigo()+"'").list();
		for (UbicacionInsumoEntity u: ube)
		{
			resultado=resultado+u.getCantidadNeta();
		}
		return resultado;
	}
	
	
}
