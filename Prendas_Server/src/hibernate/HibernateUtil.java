package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;
import entities.MovimientoCCEntity;

 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;

    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 config.addAnnotatedClass(ClienteEntity.class);
        	 config.addAnnotatedClass(CuentaCorrienteEntity.class);
        	 config.addAnnotatedClass(MovimientoCCEntity.class);
             sessionFactory = config.buildSessionFactory();
             
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
