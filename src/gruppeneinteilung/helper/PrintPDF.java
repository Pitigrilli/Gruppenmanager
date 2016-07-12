package gruppeneinteilung.helper;

import gruppeneinteilung.model.Gruppeneinteilung;
import gruppeneinteilung.model.Student;
import gruppeneinteilung.model.Jahrgang;
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
import java.io.File;
import java.awt.Desktop;
import java.io.IOException;

public class PrintPDF {

    private File file;

    Document document;
    private static Font tableFontRot = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD, BaseColor.RED); // Schrift in Tabelle 
    private static Font tableFontGruen = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD, BaseColor.GREEN); // Schrift in Tabelle 
    private static Font tableFontBlau = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD, BaseColor.BLUE); // Schrift in Tabelle 
    private static Font tableFont = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD); // Schrift in Tabelle 
    private static Font tableHeadFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,
            Font.BOLD); // Klassenbezeichner
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);  // Ãœberschrift
    private static Font Fußnote = new Font(Font.FontFamily.TIMES_ROMAN, 7,
            Font.BOLD);  // Ãœberschrift

    private Gruppeneinteilung ge;
    private String name;
    public PrintPDF(Gruppeneinteilung ge) {
        this.ge = ge;
        
        
         
       }
    /**
     * Druckt alle JahrgÃ¤nge,erwartet einen String als Name fÃ¼r die PDF-Datei
     * @param name 
     */
    public void Drucken(){     
        
        name = "AlleJahrgängeOhneGruppen";
        
        
        try {
            erstellen(name);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addMetaData(document);
            addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
                   if (Desktop.isDesktopSupported()) {
    try {
       String titel = "AlleJahrgängeOhneGruppen.pdf";
        File myFile = new File(titel);
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
        }
    }
    }
  
        
    
    

    private void erstellen(String n) {
        
        String filename = n +".pdf";
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
       
        preface.add(new Paragraph(  " Klassen ", smallBold));
        
        addEmptyLine(preface, 1);
        document.add(preface);

        for (Jahrgang j : ge.getJahrgaenge()) {
            Paragraph tabelle = new Paragraph();
            createTable(tabelle, j);
            document.add(tabelle);
            Paragraph bottom = new Paragraph();
        addEmptyLine(bottom, 1);
        bottom.add(new Paragraph( ""+new Date(), Fußnote));
        document.add(bottom);
            // Start a new page
            document.newPage();

        }
    }
    
    /**
     * Druckt den Ã¼bergebenen Jahrgang,erwartet einen Jahrgang und einen String fÃ¼r die PDF-Datei
     * @param j
     * @param name 
     */
    public void druckeKlassen(Jahrgang j){    //druckt den Ã¼bergebenen Jahrgang erwartet einen Jahrgang und einen String fÃ¼r PDF 
            
        name = j.getJahrgang() + ".Klassen";
        
        try {
            
            erstellen(name);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addMetaData(document);
            ausgewaehlterJahrgangDrucken(document,j);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
                   if (Desktop.isDesktopSupported()) {
    try {
       String titel = j.getJahrgang() + ".Klassen.pdf";
        File myFile = new File(titel);
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
        }
    }
    }
    
    
    
    
       
    private void ausgewaehlterJahrgangDrucken(Document document,Jahrgang j) throws DocumentException {

        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(j.getJahrgang() + " .Klassen", smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);

        Paragraph tabelle = new Paragraph();

        createTable(tabelle, j);
        document.add(tabelle);
        Paragraph bottom = new Paragraph();
        addEmptyLine(bottom, 1);
        bottom.add(new Paragraph( ""+new Date(), Fußnote));
        document.add(bottom);
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
                        tableI.addCell(new Phrase((s.getName() + " "+ s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " +s.getFs4() + " "+ s.getReligion() + " " + s.getBemerkung()), tableFontRot));
                        break;
                    case "EV":
                        tableI.addCell(new Phrase((s.getName() + " "+ s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " +s.getFs4() + " "+ s.getReligion() + " " + s.getBemerkung()), tableFontGruen));
                        break;
                    case "ETH":
                        tableI.addCell(new Phrase((s.getName() + " "+ s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " +s.getFs4() + " "+ s.getReligion() + " " + s.getBemerkung()), tableFontBlau));
                        break;

                    default:
                        tableI.addCell(new Phrase((s.getName() + " "+ s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " +s.getFs4() + " "+ s.getReligion() + " " + s.getBemerkung()), tableFont));
                }

            }

            table.addCell(tableI);
        }

        table.addCell("1.1");
        newTable.add(table);

    }
    
    

    public static void main(String[] args) {
       Speicherung sp = new Speicherung ("20160711.ged");
        Gruppeneinteilung ge = sp.serialisierungLaden();
        PrintPDF pdf =new PrintPDF(ge);
        Jahrgang j= ge.getJahrgang(8);
        
       // pdf.druckeReligionsGruppe(j);
        
   
        
    
        // no application registered for PDFs
    

       //pdf.druckeKlassen(j);
      pdf.druckeGesammterJahrgangMitGruppen(j);
       // try{
        
       // catch(DocumentException e){}
        //pdf.Drucken();
        
        
        
    }

    public File getFile() {
        System.out.println(file.getAbsolutePath());
        return file;
    }
  
    
    
    //Ab hier funktionierts
    
    
    
    
     public void druckeReligionsGruppe(Jahrgang j){    //druckt den Ã¼bergebenen Jahrgang erwartet einen Jahrgang und einen String fÃ¼r PDF 
if(j.getReligionsgruppenzahl()== 0){}else{
         name = j.getJahrgang() + ".Klassen_Religionsgruppen";
         
        try {
            
            erstellen(name);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addMetaData(document);
            religionsGruppeDrucken(document,j);
            
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }
           if (Desktop.isDesktopSupported()) {
    try {
       String titel = j.getJahrgang() + ".Klassen_Religionsgruppen.pdf";
        File myFile = new File(titel);
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
        }
    }
     }
    
    
    
       
    private void religionsGruppeDrucken(Document document,Jahrgang j) throws DocumentException {

        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph( j.getJahrgang() + " .Klassen: Religionsgruppen", smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);

        Paragraph tabelle = new Paragraph();

        createTableReligionGruppe(tabelle, j);
        document.add(tabelle);
        
        Paragraph bottom = new Paragraph();
        addEmptyLine(bottom, 1);
        bottom.add(new Paragraph( ""+new Date(), Fußnote));
        document.add(bottom);
        // Start a new page
        document.newPage();

    }

    

    private void createTableReligionGruppe(Paragraph newTable, Jahrgang j)
            throws BadElementException, DocumentException {

        Jahrgang aktuellerJahrgang = j;
        int n =aktuellerJahrgang.getReligionsgruppenzahl();
        System.out.println(n);

        PdfPTable table = new PdfPTable(n); // Spaltenanzahl
        table.setWidthPercentage(100f);

        for (int i = 0; i < n; i++) {
            PdfPTable tableI = new PdfPTable(1);
            tableI.setHeaderRows(1);
            tableI.addCell((new Phrase(aktuellerJahrgang.getJahrgang() +" - "+ aktuellerJahrgang.getReligionsgruppen().get(i).getTitel()+ " Anzahl: "+aktuellerJahrgang.getReligionsgruppen().get(i).getReligiongroesse() ,tableHeadFont)));
                    

            for (Student s : aktuellerJahrgang.getReligionsgruppen().get(i).getSchueler()) {

                switch (s.getReligion()) {
                    case "RK":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getBemerkung()), tableFontRot));
                        break;
                    case "EV":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getBemerkung()), tableFontGruen));
                        break;
                    case "ETH":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getBemerkung()), tableFontBlau));
                        break;

                    default:
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getBemerkung()), tableFont));
                }

            }

            table.addCell(tableI);
        }
        

        table.addCell("1.1");
        newTable.add(table);

    }
    
    
    
    
    
    
    
         public void druckeSportGruppe(Jahrgang j){    //druckt den Ã¼bergebenen Jahrgang erwartet einen Jahrgang und einen String fÃ¼r PDF 
if(j.getSportgruppenzahl()== 0){}else{
              name = j.getJahrgang() + ".Klassen_Sportgruppen";
             
        try {
            
            erstellen(name);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addMetaData(document);
            sportGruppeDrucken(document,j);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
           if (Desktop.isDesktopSupported()) {
    try {
       String titel = j.getJahrgang() + ".Klassen_Sportgruppen.pdf";
        File myFile = new File(titel);
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
        }
    }
         }  
    
    
    
       
    private void sportGruppeDrucken(Document document,Jahrgang j) throws DocumentException {

        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(j.getJahrgang() + " .Klassen: Sportgruppen", smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);

        Paragraph tabelle = new Paragraph();

        createTableSportGruppe(tabelle, j);
        document.add(tabelle);
        Paragraph bottom = new Paragraph();
        addEmptyLine(bottom, 1);
        bottom.add(new Paragraph( ""+new Date(), Fußnote));
        document.add(bottom);
        // Start a new page
        document.newPage();

    }

    

    private void createTableSportGruppe(Paragraph newTable, Jahrgang j)
            throws BadElementException, DocumentException {

        Jahrgang aktuellerJahrgang = j;
        int n =aktuellerJahrgang.getSportgruppenzahl();
        System.out.println(n);

        PdfPTable table = new PdfPTable(n); // Spaltenanzahl
        table.setWidthPercentage(100f);

        for (int i = 0; i < n; i++) {
            PdfPTable tableI = new PdfPTable(1);
            tableI.setHeaderRows(1);
            tableI.addCell((new Phrase(aktuellerJahrgang.getJahrgang() +" - Sport - "+ aktuellerJahrgang.getSportgruppen().get(i).getTitel() ,tableHeadFont)));
                    

            for (Student s : aktuellerJahrgang.getSportgruppen().get(i).getSchueler()) {

                switch (s.getReligion()) {
                    case "RK":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getBemerkung()), tableFontRot));
                        break;
                    case "EV":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getBemerkung()), tableFontGruen));
                        break;
                    case "ETH":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getBemerkung()), tableFontBlau));
                        break;

                    default:
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getBemerkung()), tableFont));
                }

            }

            table.addCell(tableI);
        }

        table.addCell("1.1");
        newTable.add(table);

    }
    
    
    
    
    
           public void druckeFremdsprachenGruppe(Jahrgang j){    //druckt den Ã¼bergebenen Jahrgang erwartet einen Jahrgang und einen String fÃ¼r PDF 
               if(j.getSprachengruppenzahl()== 0){}else{
                name = j.getJahrgang() + ".Klassen_Fremdsprachengruppen";
               
        try {
            
            erstellen(name);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addMetaData(document);
            fremdsprachenGruppeDrucken(document,j);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
               if (Desktop.isDesktopSupported()) {
    try {
       String titel = j.getJahrgang() + ".Klassen_Fremdsprachengruppen.pdf";
        File myFile = new File(titel);
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
        }
    }
           }
    
    
       
    private void fremdsprachenGruppeDrucken(Document document,Jahrgang j) throws DocumentException {

        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(j.getJahrgang() + " .Klassen: Fremdsprachengruppen", smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);

        Paragraph tabelle = new Paragraph();

        createTableFremdsprachenGruppe(tabelle, j);
        document.add(tabelle);
        Paragraph bottom = new Paragraph();
        addEmptyLine(bottom, 1);
        bottom.add(new Paragraph( ""+new Date(), Fußnote));
        document.add(bottom);
        // Start a new page
        document.newPage();

    }

    

    private void createTableFremdsprachenGruppe(Paragraph newTable, Jahrgang j)
            throws BadElementException, DocumentException {

        Jahrgang aktuellerJahrgang = j;
        int n =aktuellerJahrgang.getSprachengruppenzahl();
        System.out.println(n);

        PdfPTable table = new PdfPTable(n); // Spaltenanzahl
        table.setWidthPercentage(100f);

        for (int i = 0; i < n; i++) {
            PdfPTable tableI = new PdfPTable(1);
            tableI.setHeaderRows(1);
            tableI.addCell((new Phrase(aktuellerJahrgang.getJahrgang() +" - "+ aktuellerJahrgang.getSprachengruppen().get(i).getTitel()+ " Anzahl: "+aktuellerJahrgang.getSprachengruppen().get(i).getFremdsprachengroesse() ,tableHeadFont)));
                    

            for (Student s : aktuellerJahrgang.getSprachengruppen().get(i).getSchueler()) {

                switch (s.getReligion()) {
                    case "RK":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getZweig()+ " " + s.getBemerkung()), tableFontRot));
                        break;
                    case "EV":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getZweig()+ " " + s.getBemerkung()), tableFontGruen));
                        break;
                    case "ETH":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getZweig()+ " " + s.getBemerkung()), tableFontBlau));
                        break;

                    default:
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getZweig()+ " " + s.getBemerkung()), tableFont));
                }

            }

            table.addCell(tableI);
        }

        table.addCell("1.1");
        newTable.add(table);

    }
    
    
    
    
               public void druckeZweigGruppe(Jahrgang j){    //druckt den Ã¼bergebenen Jahrgang erwartet einen Jahrgang und einen String fÃ¼r PDF 
if(j.getZweiggruppenzahl()== 0){}else{
                    name = j.getJahrgang() + ".Klassen_Zweiggruppen";
                   
        try {
            
            erstellen(name);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addMetaData(document);
            zweigGruppeDrucken(document,j);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
               if (Desktop.isDesktopSupported()) {
    try {
       String titel = j.getJahrgang() + ".Klassen_Zweiggruppen.pdf";
        File myFile = new File(titel);
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
        }
    }
               } 
    
    
       
    private void zweigGruppeDrucken(Document document,Jahrgang j) throws DocumentException {

        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(j.getJahrgang() + ".Klassen: Zweiggruppen", smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);

        Paragraph tabelle = new Paragraph();

        createTableZweigGruppe(tabelle, j);
        document.add(tabelle);
        Paragraph bottom = new Paragraph();
        addEmptyLine(bottom, 1);
        bottom.add(new Paragraph( ""+new Date(), Fußnote));
        document.add(bottom);
        // Start a new page
        document.newPage();

    }

    

    private void createTableZweigGruppe(Paragraph newTable, Jahrgang j)
            throws BadElementException, DocumentException {

        Jahrgang aktuellerJahrgang = j;
        int n =aktuellerJahrgang.getZweiggruppenzahl();
        System.out.println(n);

        PdfPTable table = new PdfPTable(n); // Spaltenanzahl
        table.setWidthPercentage(100f);

        for (int i = 0; i < n; i++) {
            PdfPTable tableI = new PdfPTable(1);
            tableI.setHeaderRows(1);
            tableI.addCell((new Phrase(aktuellerJahrgang.getJahrgang() +" - "+ aktuellerJahrgang.getZweiggruppen().get(i).getTitel()+ " Anzahl: "+aktuellerJahrgang.getZweiggruppen().get(i).getZweiggroesse() ,tableHeadFont)));
                    

            for (Student s : aktuellerJahrgang.getZweiggruppen().get(i).getSchueler()) {

                switch (s.getReligion()) {
                    case "RK":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getFs2()+" " + s.getFs3()+ " " + s.getBemerkung()+ " "+ s.getFs4()), tableFontRot));
                        break;
                    case "EV":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getFs2()+" " + s.getFs3()+ " " + s.getBemerkung()+ " "+ s.getFs4()), tableFontGruen));
                        break;
                    case "ETH":
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getFs2()+" " + s.getFs3()+ " " + s.getBemerkung()+ " "+ s.getFs4()), tableFontBlau));
                        break;

                    default:
                        tableI.addCell(new Phrase((s.getName()+ " " + s.getGeschlecht()+ " " + s.getFs2()+" " + s.getFs3()+ " " + s.getBemerkung()+ " "+ s.getFs4()), tableFont));
                }

            }

            table.addCell(tableI);
        }

        table.addCell("1.1");
        newTable.add(table);

    }
 public void druckeGesammterJahrgangMitGruppen(Jahrgang j){    //druckt den Ã¼bergebenen Jahrgang erwartet einen Jahrgang und einen String fÃ¼r PDF 
            
        name = j.getJahrgang() + ".Klassen";
     
        try {
            
            erstellen(name);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addMetaData(document);
            ausgewaehlterJahrgangGruppenDrucken(document,j);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       druckeReligionsGruppe(j);
        druckeFremdsprachenGruppe(j);
        druckeSportGruppe(j);
        druckeZweigGruppe(j);
        
        
                   if (Desktop.isDesktopSupported()) {
    try {
       String titel = j.getJahrgang() + ".Klassen.pdf";
        File myFile = new File(titel);
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
        }
    }
    }
    
    
    
    
       
    private void ausgewaehlterJahrgangGruppenDrucken(Document document,Jahrgang j) throws DocumentException {

        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(j.getJahrgang() + ".Klassen", smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);

        Paragraph tabelle = new Paragraph();
        

        createTableJahrgangGruppen(tabelle, j);
        document.add(tabelle);
        Paragraph bottom = new Paragraph();
        addEmptyLine(bottom, 1);
        bottom.add(new Paragraph( ""+new Date(), Fußnote));
        document.add(bottom);
        // Start a new page
        document.newPage();
        
        
    }

    

    private void createTableJahrgangGruppen(Paragraph newTable, Jahrgang j)
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
                        tableI.addCell(new Phrase((s.getName() + " "+ s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " +s.getFs4() + " "+ s.getReligion() + " " + s.getBemerkung()), tableFontRot));
                        break;
                    case "EV":
                        tableI.addCell(new Phrase((s.getName() + " "+ s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " +s.getFs4() + " "+ s.getReligion() + " " + s.getBemerkung()), tableFontGruen));
                        break;
                    case "ETH":
                        tableI.addCell(new Phrase((s.getName() + " "+ s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " +s.getFs4() + " "+ s.getReligion() + " " + s.getBemerkung()), tableFontBlau));
                        break;

                    default:
                        tableI.addCell(new Phrase((s.getName() + " "+ s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " +s.getFs4() + " "+ s.getReligion() + " " + s.getBemerkung()), tableFont));
                }

            }

            table.addCell(tableI);
        }

        table.addCell("1.1");
        newTable.add(table);

    }
    
    
    
    
 

    

   
    
}


