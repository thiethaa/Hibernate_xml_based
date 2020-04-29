package com.xmlbased_hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static StandardServiceRegistry reg;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        try {
            reg = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            MetadataSources sources = new MetadataSources(reg);

            Metadata metadata = sources.getMetadataBuilder().build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            e.printStackTrace();
            if (reg != null) {
                StandardServiceRegistryBuilder.destroy(reg);
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (reg != null) {
            StandardServiceRegistryBuilder.destroy(reg);
        }
    }
}
