package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.ClienteEntity;
import entities.ColorEntity;
import entities.CuentaCorrienteEntity;
import entities.DetalleAreaEntity;
import entities.InsumoEntity;
import entities.ItemPedidoPEntity;
import entities.ItemRecetaEntity;
import entities.MovStockEntity;
import entities.MovimientoCCEntity;
import entities.PedidoPrendaEntity;
import entities.PrendaEntity;
import entities.PrendaGenericaEntity;
import entities.TalleEntity;

 
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
        	 config.addAnnotatedClass(ColorEntity.class);
        	 config.addAnnotatedClass(TalleEntity.class);
        	 
        	 config.addAnnotatedClass(PrendaEntity.class);
        	 config.addAnnotatedClass(PrendaGenericaEntity.class);
        	 config.addAnnotatedClass(MovStockEntity.class);
        	 config.addAnnotatedClass(DetalleAreaEntity.class);
        	 config.addAnnotatedClass(ItemRecetaEntity.class);
        	 config.addAnnotatedClass(InsumoEntity.class);

        	 config.addAnnotatedClass(PedidoPrendaEntity.class);
        	 config.addAnnotatedClass(ItemPedidoPEntity.class);

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
