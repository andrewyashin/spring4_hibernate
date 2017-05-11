package client;

import dao.entities.Contact;
import dao.entities.ContactTelDetail;
import dao.entities.Hobby;
import dao.interfaces.ContactDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "dao")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context
                = new GenericXmlApplicationContext("config.xml");

        ContactDAO contactDAO = (ContactDAO) context.getBean("contactDAO");
        List<Contact> contacts = contactDAO.findAllWithDetails();

        for (Contact contact: contacts) {
            System.out.println(contact);

            if(contact.getContactTelDetails() != null){
                for(ContactTelDetail contactTelDetail: contact.getContactTelDetails()){
                    System.out.println(" ---- " + contactTelDetail);
                }
            }

//            if (contact.getHobbies() != null){
//                for (Hobby hobby: contact.getHobbies()){
//                    System.out.println(" ---- " + hobby);
//                }
//            }
        }

        Contact contact = contactDAO.findById(1L);
        contactDAO.delete(contact);
        contact = contactDAO.findById(1L);
        System.out.println(contact);






    }

}

