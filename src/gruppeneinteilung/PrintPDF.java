package gruppeneinteilung;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

public class PrintPDF {

    private File file;


    Document document;
    private static Font tableFontRot = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD,BaseColor.RED); // Schrift in Tabelle 
   private static Font tableFontGruen = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD,BaseColor.GREEN); // Schrift in Tabelle 
    private static Font tableFontBlau = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD,BaseColor.BLUE); // Schrift in Tabelle 
    private static Font tableFont = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD); // Schrift in Tabelle 
    private static Font tableHeadFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,
            Font.BOLD); // Klassenbezeichner
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);  // Überschrift

    private Gruppeneinteilung ge;

    public PrintPDF(Gruppeneinteilung ge) {
        this.ge = ge;
            erstellen();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addMetaData(document);
            addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void erstellen(){
        String filename = "Ausdruck.pdf";
        file = new File(filename);
        document = new Document();
        document.setPageSize(PageSize.A4.rotate());
        document.setMargins(20f, 20f, 20f, 20f);
    
    }
    
   
    private void addMetaData(Document document) {
        document.addTitle("Gruppeneinteilung");
    }

    private void addContent(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();

        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Erstellt von: " + System.getProperty("user.name") + ", " + new Date(), smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);

        for (Jahrgang j : ge.getJahrgaenge()) {
            Paragraph tabelle = new Paragraph();
            createTable(tabelle, j);
            document.add(tabelle);
            // Start a new page
            document.newPage();

        }
    }
    
    private void ausgewaehlterJahrgangDrucken(Jahrgang j)throws DocumentException{
  
        
         Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Erstellt von: " + System.getProperty("user.name") + ", " + new Date(), smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);

        Paragraph tabelle = new Paragraph();
        
            createTable(tabelle, j);
            document.add(tabelle);
            // Start a new page
            document.newPage();
    

}

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private void createTable(Paragraph newTable, Jahrgang j)
            throws BadElementException, DocumentException {

        Jahrgang aktuellerJahrgang = j;
        int n = aktuellerJahrgang.getKlassenanzahl();
        System.out.println(n);

        PdfPTable table = new PdfPTable(n); // Spaltenanzahl
        table.setWidthPercentage(100f);
         
        for (int i = 0; i < n; i++) {
            PdfPTable tableI = new PdfPTable(1);
            tableI.setHeaderRows(1);
            tableI.addCell(new Phrase(aktuellerJahrgang.getJahrgang() + aktuellerJahrgang.getKlassen().get(i).getBuchstabe(),
                    tableHeadFont));
            
            
            for (Student s : aktuellerJahrgang.getKlassen().get(i).getSchueler()) {
                
                 switch (s.getReligion()) {
                case "RK":
                    tableI.addCell(new Phrase((s.toString()), tableFontRot));
                    break;
                case "EV":
                    tableI.addCell(new Phrase((s.toString()), tableFontGruen));
                    break;
                case "ETH":
                    tableI.addCell(new Phrase((s.toString()), tableFontBlau));
                    break;
                                  
                    default:
                        tableI.addCell(new Phrase((s.toString()), tableFont));
                 }
                
            }
            
            
            
            table.addCell(tableI);
        }

        table.addCell("1.1");
        newTable.add(table);

        }

    public static void main(String[] args) {
        new PrintPDF(new Gruppeneinteilung("ASV.csv"));
    }
    
        public File getFile() {
            System.out.println(file.getAbsolutePath());
        return file;
    }
        
        
    
}                       
