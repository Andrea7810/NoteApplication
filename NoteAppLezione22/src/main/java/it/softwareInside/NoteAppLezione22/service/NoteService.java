package it.softwareInside.NoteAppLezione22.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.NoteAppLezione22.models.Note;
import it.softwareInside.NoteAppLezione22.repository.NoteCrudRepository;
import jakarta.validation.Valid;

@Service
public class NoteService {

	
	@Autowired
	NoteCrudRepository noteCrudRepository;
	
	
	
	/**
	 * Crea nuova nota , prende in input oggetto Note 
	 * e crea una nuova nota nel database. Torna true se va a buon fine,
	 * false se non è possibile aggiungerla.
	 * @param note
	 * @return
	 */
	public boolean creaNote (@Valid Note note) {
		
		try {
			
			noteCrudRepository.save(note);
			return true;
			
		} catch (Exception e) {

			return false;
		}
	}
	
	
	/**
	 * Torna un oggetto di tipo Iterable , con tutte le note 
	 * presenti nel Database.
	 * @return
	 */
	public Iterable<Note> stampaNote () {
		
		return noteCrudRepository.findAll();
	}
	
	
	
	
	/**
	 * Prende in ingresso un int id , torna un oggetto Note 
	 * presente nel database a quel id.
	 * @param id
	 * @return
	 */
	public Note noteAtId (int id) {
		
		try {
			
			return noteCrudRepository.findById(id).get();
			
		} catch (Exception e) {

			return null;
		}
		
	}
	
	
	
	
	/**
	 * Prende in input un int id, e torna un oggetto di tipo Note a quell' id
	 * e viene  rimosso dal Database.
	 * @param id
	 * @return
	 */
	public Note deleteNoteAtId (int id) {
		
		try {
			
			Note noteDelete = noteCrudRepository.findById(id).get();
			noteCrudRepository.deleteById(id);
			return noteDelete;
			
		} catch (Exception e) {
			
			return null;
		}
	}
	
	
	
	/**
	 * Prende in ingresso una String password
	 * se risulta corretta elimina tutte le note presenti
	 * nel Database.
	 * @param passoword
	 * @return
	 */
	public boolean deleteAllNotes (@Valid String passoword) {
		
		try {
			
			String correctPass = "abcd";
			
			if (passoword.equals(correctPass)) {
				noteCrudRepository.deleteAll();
				return true;
			} else
				return false;
			
		} catch (Exception e) {

			return false;
		}
		
	}
	
	
	
	/**
	 * Prende in input un oggetto di tipo Note e torna 
	 * true se riesce a modficare l'oggetto con i nuovi inseriti,
	 * false se risulta una eccezione.
	 * @param note
	 * @return
	 */
	public boolean updateNote (@Valid Note note) {
		
		return creaNote(note);
	}
	
	
	
	
	
	
	
	
	
	
}
