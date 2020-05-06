package dao;

import java.util.ArrayList;
import java.util.List;

import domain.PropositionDate;
import domain.ResultatSondage;
import domain.Sondage;
import jpa.EntityManagerHelper;

public class SondageDao {
	
	private PropositionDateDao dao;
	
	/**renvoie un sondage de type quelcomque requêtes polymorphes
	 * @param id du sondage a chercher
	 * @return sondage retourné
	 * */
	public Sondage findById(long id) {
		return EntityManagerHelper.getEntityManager().find(Sondage.class, id);
	}
	
	
	public Sondage save(Sondage S) {
		 EntityManagerHelper.beginTransaction();
	        if (S.getNomSondage() != null) {
	            EntityManagerHelper.getEntityManager().merge(S);

	        } else {
	            EntityManagerHelper.getEntityManager().persist(S);

	        }
	        EntityManagerHelper.commit();
	        return S;

	}
      /**supprime un sondage quelconque
       * @param id du sondage
       * */
	public void delete(long id) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findById(id));
		EntityManagerHelper.commit();
	}
	/**retourne la liste de tous les sondages
	 * @return une collection qui contient tous les sondages */
	  public List<Sondage> findAll() {
	       List<Sondage> liste = new ArrayList<Sondage>();
	       liste.addAll(dao.findAll());
	       return liste;
		}

}
