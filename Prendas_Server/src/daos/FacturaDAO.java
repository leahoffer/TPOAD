package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.FacturaEntity;
import hibernate.HibernateUtil;

public class FacturaDAO {
	
	private static FacturaDAO instancia;
	
	public static FacturaDAO getInstancia(){
		if(instancia == null)
			instancia = new FacturaDAO();
		return instancia;
	}
	
	private FacturaDAO(){
		super();
	}
	
	public void guardarFactura(FacturaEntity fe)
	{
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(fe);
			s.beginTransaction().commit();
			s.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
