package it.softwareInside.NoteAppLezione22.service;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.NoteAppLezione22.repository.NoteCrudRepository;

@Service
public class PdfService {

	
	@Autowired
	NoteCrudRepository noteCrudRepository;
	
	
	@SuppressWarnings("deprecation")
	public PDDocument createPDF (int id) throws IOException {
		
		String autore = noteCrudRepository.findById(id).get().getAutore();
		String text = noteCrudRepository.findById(id).get().getText();
		
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage( page );

		
		PDFont font = PDType1Font.HELVETICA_BOLD;

		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		
		contentStream.beginText();
		contentStream.setFont( font, 12 );
		contentStream.moveTextPositionByAmount( 100, 700 );
		contentStream.drawString( autore );
		contentStream.newLine();
		contentStream.drawString(text);
		contentStream.endText();
		
		
		contentStream.close();

		
		document.save("Nota.pdf");
		document.close();
		
	
		return document;
		
	}
	
	
	
	
}
