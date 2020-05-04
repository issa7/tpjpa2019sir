package jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import domain.Createur;
import domain.PropositionDate;
import domain.Reunion;
import domain.Sondage;

public class JpaTest {
	private EntityManager manager;
    
	
	public JpaTest(EntityManager manager) {
        this.manager = manager;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("dev");

		EntityManager manager = factory.createEntityManager();
		
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
         tx.begin();


		try {
			test.createSondage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listSondage();

		manager.close();
		System.out.println(".. done");
			factory.close();
	}
      private void createSondage() {
    	  int numSondage = manager.createQuery("Select a From Sondage a", Sondage.class).getResultList().size();
    	  if (numSondage == 0) {
    		  String date1 = "22/06/2006";
  		       String date2 = "23/06/2006";
  		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
  		  try {
  			  Createur createur = new Createur("keita@gmail.com", "issa", "keita");
  			 manager.persist(createur);
			Date date11 = simpleDateFormat.parse(date1);
			Date date22 = simpleDateFormat.parse(date2);
			  PropositionDate propo1 = new PropositionDate(date11);
			  PropositionDate propo2 = new PropositionDate(date22);
			  List<PropositionDate> propo = new  ArrayList<PropositionDate>();
			  propo.add(propo1);
			  propo.add(propo2);
			  manager.persist( new Reunion("debat", "resumer"));
			  manager.persist( new Sondage("sondage de exam",propo,createur)); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
            
          }

      }
      private void listSondage() {
          List<Sondage> resultList = manager.createQuery("Select a From Sondage a", Sondage.class).getResultList();
          System.out.println("num of Sondage:" + resultList.size());
          for (Sondage next : resultList) {
              System.out.println("next Sondage: " + next);
          }
      }


}
