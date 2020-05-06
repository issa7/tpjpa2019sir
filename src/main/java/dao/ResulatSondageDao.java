package dao;

import java.util.List;

import domain.ResultatSondage;
import jpa.EntityManagerHelper;

public class ResulatSondageDao {
   public ResultatSondage findById(long id) {
	   return EntityManagerHelper.getEntityManager().find(ResultatSondage.class, id);
   }
   
   
   public ResultatSondage save(ResultatSondage R) {
	   
	   EntityManagerHelper.beginTransaction();
	   if (R.getResulat() !=null) {
		   EntityManagerHelper.getEntityManager().merge(R);
	   }else {
		   EntityManagerHelper.getEntityManager().persist(R);
	   }
	   EntityManagerHelper.commit();
       return R;
   }
   
   public void delete(long id) {
       EntityManagerHelper.beginTransaction();
       EntityManagerHelper.getEntityManager().remove(this.findById(id));
       EntityManagerHelper.commit();        
   }
   public List<ResultatSondage> findAll() {
       return EntityManagerHelper.getEntityManager().createQuery("select n from ResultatSondage  n", ResultatSondage.class)
       .getResultList();
	}
}
