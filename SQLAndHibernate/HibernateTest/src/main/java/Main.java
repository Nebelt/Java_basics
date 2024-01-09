import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<PurchaseList> purchaseList = session.createQuery("FROM " + PurchaseList.class.getName()).getResultList();
        List<Course> courseList = session.createQuery("FROM " + Course.class.getName()).getResultList();
        List<Student> studentList = session.createQuery("FROM " + Student.class.getName()).getResultList();

        for (PurchaseList purchase : purchaseList) {
            for (Student student : studentList) {
                if (purchase.getStudentName().equals(student.getName())) {
                    for (Course course : courseList) {
                        if (purchase.getCourseName().equals(course.getName())) {
                            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(new LinkedPurchaseListKey(student.getId(),course.getId()),student.getId(),course.getId());
                            System.out.println(linkedPurchaseList);
                            session.saveOrUpdate(linkedPurchaseList);
                        }
                    }
                }
            }
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
