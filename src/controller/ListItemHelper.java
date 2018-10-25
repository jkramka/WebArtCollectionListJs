package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebArtCollectionListJs");
	
	public void cleanUp() {
		emfactory.close();
	}
	
	public void insertItem(ListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteItem(ListItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = 
				em.createQuery("select li from ListItem li where li.artist = :selectedArtist and li.item = :selectedItem and li.year = :selectedYear",
						ListItem.class);
		typedQuery.setParameter("selectedArtist",  toDelete.getArtist());
		typedQuery.setParameter("selectedItem",  toDelete.getItem());
		typedQuery.setParameter("selectedYear",  toDelete.getYear());
		
		typedQuery.setMaxResults(1);
		
		ListItem field = typedQuery.getSingleResult();
		
	    //int primary = toDelete.getId();
		//System.out.println(primary);
		//ListItem toRemove = em.find(ListItem.class, primary);
		
		
		em.remove(field);
		em.getTransaction().commit();
		em.close();
		}
	
	
	
	public List<ListItem> searchForItemByItem(String itemName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.item = :selectedItem", ListItem.class);
		typedQuery.setParameter("selectedItem", itemName);
		
 		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	
	
	public List<ListItem> searchForItemByArtist(String artistName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.Artist = :selectedArtist", ListItem.class);
		typedQuery.setParameter("selectedArtist", artistName);
		
 		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
public List<ListItem> searchForItemByYear(int year) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.year = :selectedYear", ListItem.class);
		typedQuery.setParameter("selectedYear", year);
		
 		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public ListItem searchForItemById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, id);
		em.close();
		
		return found;
	}
	
	
	
	
	public List<ListItem> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li", ListItem.class);
		List<ListItem> allItems = typedQuery.getResultList();
		em.close();
		
		return allItems;
	}
	
	
	
	public void updateItem(ListItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
}

