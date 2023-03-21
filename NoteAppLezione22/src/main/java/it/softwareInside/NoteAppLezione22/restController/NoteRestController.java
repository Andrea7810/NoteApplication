package it.softwareInside.NoteAppLezione22.restController;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.NoteAppLezione22.models.Note;
import it.softwareInside.NoteAppLezione22.service.NoteService;
import it.softwareInside.NoteAppLezione22.service.PdfService;

@RestController
public class NoteRestController {

	
	
	
	@Autowired
	NoteService noteService;
	
	@Autowired
	PdfService pdfService;
	
	
	
	@PostMapping("/create-note")
	public boolean creaNota (@RequestBody Note note) {
		
		return noteService.creaNote(note);
	}
	
	
	
	@GetMapping("/stampa-note")
	public Iterable<Note> stampaNote () {
		
		return noteService.stampaNote();
	}
	
	
	@GetMapping("/note-at-id")
	public Note noteAtId (@RequestParam (name = "id") int id) {
		
		return noteService.noteAtId(id);
	}
	
	
	
	
	@DeleteMapping("/delete-note-id")
	public Note deleteNoteById (@RequestParam (name = "id") int id) {
		
		return noteService.deleteNoteAtId(id);
	}
	
	
	
	
	@DeleteMapping("/delete-all")
	public boolean deleteAll (@RequestParam (name = "pass") String password) {
		
		return noteService.deleteAllNotes(password);
	}
	
	
	
	@PostMapping("/update-note")
	public boolean updateNote (@RequestBody Note note) {
		
		return noteService.updateNote(note);
	}
	
	
	@GetMapping("/create-pdf")
	public PDDocument createPdf (@RequestParam (name = "id") int id) throws IOException {
		
		return pdfService.createPDF(id);
	}
	
	
	
	
}
