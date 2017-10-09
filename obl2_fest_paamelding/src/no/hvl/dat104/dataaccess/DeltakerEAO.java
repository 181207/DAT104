package no.hvl.dat104.dataaccess;

import java.util.List;

import javax.ejb.Stateless;

import no.hvl.dat104.modell.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *  Tankegangen med StudentEAO er at man gjør de nødvendige database-oppdateringer
 *  gjennom metodekall her. Objektene vi får returnert fra metodene er "detached",
 *  og vi må eksplisitt kalle f.eks. oppdaterStudent() om vi vil at endringer skal
 *  reflekteres i databasen.
 */
@Stateless
public class DeltakerEAO {  
	@PersistenceContext(name = "deltakerPersistenceUnit")
	private EntityManager em;
	
	public void leggTilDeltaker(Deltaker d) {
		em.persist(d);
	}
	
	public void oppdaterDeltaker(Deltaker d) {
		em.merge(d);
	}
	
	public void slettDeltaker(String id) {
		em.remove(em.find(Deltaker.class, id));
	}

	public List<Deltaker> alleDelakerTotalt() {
		TypedQuery<Deltaker> query = em.createQuery("SELECT d FROM Deltaker d ORDER BY d.fornavn, d.etternavn", Deltaker.class);
		return query.getResultList();
	}

	public Deltaker finnDeltaker(String mobil) {
		return em.find(Deltaker.class, mobil);
	}
}
