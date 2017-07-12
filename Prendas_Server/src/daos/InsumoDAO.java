package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.InsumoEntity;
import hibernate.HibernateUtil;

public class InsumoDAO {

	private static InsumoDAO instancia;
	
	public static InsumoDAO getInstancia(){
		if(instancia==null)
			instancia = new InsumoDAO();
		return instancia;
	}
	
	public List<InsumoEntity> traerTodosLosInusmos()
	{
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.getCurrentSession();
			s.beginTransaction();
			List<InsumoEntity> lista = (List<InsumoEntity>)s.createQuery("from InsumoEntity").list();
			return lista;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
