package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.*;
 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;

    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 config.addAnnotatedClass(MovimientoCCEntity.class);
             config.addAnnotatedClass(ClienteEntity.class);
             config.addAnnotatedClass(CuentaCorrienteEntity.class);
             config.addAnnotatedClass(ColorEntity.class);
             config.addAnnotatedClass(InsumoEntity.class);
             config.addAnnotatedClass(ItemRecetaEntity.class);
             config.addAnnotatedClass(RecetaPrendaEntity.class);
             config.addAnnotatedClass(PrendaTCEntity.class);
             config.addAnnotatedClass(PrendaEntity.class);
             config.addAnnotatedClass(IdPrendaEntity.class);
             config.addAnnotatedClass(TalleEntity.class);
             config.addAnnotatedClass(ItemPedidoPEntity.class);
             config.addAnnotatedClass(PedidoPrendaEntity.class);
             config.addAnnotatedClass(StockPrendaEntity.class);
             config.addAnnotatedClass(MovimientoStockPrendaEntity.class);
             config.addAnnotatedClass(UbicacionPrendaEntity.class);
             config.addAnnotatedClass(AreaProduccionEntity.class);
             sessionFactory = config.buildSessionFactory();
             //Hola hoffer comentario salvaje//
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
