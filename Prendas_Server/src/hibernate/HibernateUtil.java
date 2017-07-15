package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.ClienteEntity;
import entities.ColorEntity;
import entities.CuentaCorrienteEntity;
import entities.DetalleAreaEntity;
import entities.InsumoEntity;
import entities.ItemPedidoIEntity;
import entities.ItemPedidoPEntity;
import entities.ItemRecetaEntity;
import entities.LoteInsumoEntity;
import entities.MovStockEntity;
import entities.MovimientoCCEntity;
import entities.OrdenProduccionEntity;
import entities.PedidoInsumoEntity;
import entities.PedidoPrendaEntity;
import entities.PrendaEntity;
import entities.PrendaGenericaEntity;
import entities.TalleEntity;
import entities.UbicacionInsumoEntity;
import entities.UbicacionPrendaEntity;
import negocio.OrdenProduccion;

 
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
        	 
        	 config.addAnnotatedClass(UbicacionPrendaEntity.class);
        	 config.addAnnotatedClass(OrdenProduccionEntity.class);
        	 config.addAnnotatedClass(UbicacionInsumoEntity.class);
        	 
        	 config.addAnnotatedClass(PedidoInsumoEntity.class);
        	 config.addAnnotatedClass(LoteInsumoEntity.class);
        	 config.addAnnotatedClass(ItemPedidoIEntity.class);

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
