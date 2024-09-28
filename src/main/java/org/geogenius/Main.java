package org.geogenius;


import org.checkerframework.checker.units.qual.C;
import org.geogenius.database.entities.Category;
import org.geogenius.database.repository.CategoryRepository;
import org.geogenius.utils.hibernate.HibernateUtils;
import org.hibernate.Session;

import javax.swing.event.HyperlinkEvent;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CategoryRepository categoryRepository = new CategoryRepository();


//        Session session = HibernateUtils.getSessionFactory().openSession();
//        session.beginTransaction();
//        Category category = (Category) session.save(new Category("sda124241"));
//        session.getTransaction().commit();
//
//        System.out.println(category.toString());
    }
}