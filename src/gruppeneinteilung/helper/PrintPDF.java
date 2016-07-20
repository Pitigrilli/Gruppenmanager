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
import java.awt.Color;
import java.io.File;
import java.awt.Desktop;
import java.io.IOException;
import javax.swing.JOptionPane;

public class PrintPDF {

    private final Gruppeneinteilung ge;
    private String dateiname;
    private File file;
    private Document document;

    // Farben in der Tabelle
    private static final Font tableFontRot = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD, BaseColor.RED); // Schrift in Tabelle 
    private static final Font tableFontGruen = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD, BaseColor.GREEN); // Schrift in Tabelle 
    private static final Font tableFontBlau = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD, BaseColor.BLUE); // Schrift in Tabelle 
        private static final Font tableFontBlack = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD); // Schrift in Tabelle 
    private static final Font tableFontOrange = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD, new BaseColor(255, 100, 0)); // Schrift in Tabelle 
    private static final Font tableFontMagenta = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD, new BaseColor(255, 0, 255)); // Schrift in Tabelle 
    private static final Font tableFontOlive = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD, new BaseColor(128, 128, 0)); // Schrift in Tabelle 
    private static final Font tableFontCyan = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD, new BaseColor(0, 255, 255)); // Schrift in Tabelle 

    
    
    private static final Font tableHeadFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,
            Font.BOLD); // Klassenbezeichner
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);  // Überschrift
    private static final Font Fußnote = new Font(Font.FontFamily.TIMES_ROMAN, 7,
            Font.BOLD);  // Überschrift

    public PrintPDF(Gruppeneinteilung ge) {
        this.ge = ge;
    }

    public void allesDrucken() {
        dateiname = "AlleJahrgänge";
        druckVorbereiten(dateiname);
        try {
            addMetaData(document);
            for (Jahrgang j : ge.getJahrgaenge()) {
                klassenDrucken(j);
                religionsGruppeDrucken(j);
                fremdsprachenGruppeDrucken(j);
                sportGruppeDrucken(j);
                zweigGruppeDrucken(j);
            }
        } catch (DocumentException e) {
            System.out.println("Fehler beim Hinzufügen des Inhalts");
        }
        druckBeenden();
    }

    public void druckeJahrgangMitGruppen(Jahrgang j) {    //druckt den übergebenen Jahrgang erwartet einen Jahrgang und einen String fÃ¼r PDF 
        dateiname = j.getJahrgang() + ".Jahrgangsstufe";
        druckVorbereiten(dateiname);
        try {
            addMetaData(document);
            klassenDrucken(j);
            religionsGruppeDrucken(j);
            fremdsprachenGruppeDrucken(j);
            sportGruppeDrucken(j);
            zweigGruppeDrucken(j);
        } catch (DocumentException e) {
            System.out.println("Fehler beim Hinzufügen des Inhalts");
        }
        druckBeenden();
    }

    public void druckeKlassen(Jahrgang j) {

        dateiname = j.getJahrgang() + ".Klassen";
        druckVorbereiten(dateiname);
        try {
            addMetaData(document);
            klassenDrucken(j);
        } catch (DocumentException e) {
            System.out.println("Fehler beim Hinzufügen des Inhalts");
        }
        druckBeenden();
    }

    public void druckeZweigGruppe(Jahrgang j) {    //druckt den Ã¼bergebenen Jahrgang erwartet einen Jahrgang und einen String fÃ¼r PDF 
        if (j.getZweiggruppenzahl() == 0) {
        } else {
            dateiname = j.getJahrgang() + ".Klassen_Zweiggruppen";
            druckVorbereiten(dateiname);
            try {
                addMetaData(document);
                zweigGruppeDrucken(j);
            } catch (DocumentException e) {
                System.out.println("Fehler beim Hinzufügen des Inhalts");
            }
            druckBeenden();

        }

    }

    public void druckeFremdsprachenGruppe(Jahrgang j) {    //druckt den Ã¼bergebenen Jahrgang erwartet einen Jahrgang und einen String fÃ¼r PDF 
        if (j.getSprachengruppenzahl() == 0) {
        } else {
            dateiname = j.getJahrgang() + ".Klassen_Fremdsprachengruppen";
            druckVorbereiten(dateiname);
            try {
                addMetaData(document);
                fremdsprachenGruppeDrucken(j);
            } catch (DocumentException e) {
                System.out.println("Fehler beim Hinzufügen des Inhalts");
            }
            druckBeenden();
        }
    }

    public void druckeSportGruppe(Jahrgang j) {    //druckt den Ã¼bergebenen Jahrgang erwartet einen Jahrgang und einen String fÃ¼r PDF 
        if (j.getSportgruppenzahl() == 0) {
        } else {
            dateiname = j.getJahrgang() + ".Klassen_Sportgruppen";
            druckVorbereiten(dateiname);
            try {
                addMetaData(document);
                sportGruppeDrucken(j);
            } catch (DocumentException e) {
                System.out.println("Fehler beim Hinzufügen des Inhalts");
            }
            druckBeenden();
        }
    }

    public void druckeReligionsGruppe(Jahrgang j) {
        if (j.getReligionsgruppenzahl() == 0) {
        } else {
            dateiname = j.getJahrgang() + ".Klassen_Religionsgruppen";
            druckVorbereiten(dateiname);
            try {
                addMetaData(document);
                religionsGruppeDrucken(j);
            } catch (DocumentException e) {
                System.out.println("Fehler beim Hinzufügen des Inhalts");
            }
            druckBeenden();
        }
    }

    public static void main(String[] args) {
        Speicherung sp = new Speicherung();
        Gruppeneinteilung ge = sp.serialisierungLaden();
        PrintPDF pdf = new PrintPDF(ge);
        Jahrgang j = ge.getJahrgang(8);

        // pdf.druckeReligionsGruppe(j);
        // pdf.druckeKlassen(j);
        pdf.druckeJahrgangMitGruppen(j);
    }

    //Hilfsmethoden
    private void druckVorbereiten(String dateiname) {
        this.dateiname = dateiname;
        File ged = ge.getFile();
        String pfad = ged.getParent();
        String filename = dateiname + ".pdf";
        file = new File(pfad, filename);
        document = new Document();
        document.setPageSize(PageSize.A4.rotate());
        document.setMargins(20f, 20f, 20f, 20f);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void druckBeenden() {
        try {
            document.close();
        } catch (Exception e) {
            System.out.println("Fehler beim Schließen des Dokuments");
        }
        // Anzeigen im PDF-Viewer
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                // no application registered for PDFs
                JOptionPane.showMessageDialog(null, "Kein PDF-Viewer registriert.");
            }
        }
    }

    private void addMetaData(Document document) {
        document.addTitle("Gruppeneinteilung");
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private void religionsGruppeDrucken(Jahrgang j) throws DocumentException {
        if (j.getReligionsgruppenzahl() != 0) {
            Paragraph preface = new Paragraph();
            addEmptyLine(preface, 1);
            preface.add(new Paragraph(j.getJahrgang() + ". Klassen: Religionsgruppen", smallBold));
            addEmptyLine(preface, 1);
            document.add(preface);

            Paragraph tabelle = new Paragraph();
            createTableReligionGruppe(tabelle, j);
            document.add(tabelle);

            Paragraph bottom = new Paragraph();
            addEmptyLine(bottom, 1);
            bottom.add(new Paragraph("" + new Date(), Fußnote));
            document.add(bottom);
            // Start a new page
            document.newPage();
        }
    }

    private void sportGruppeDrucken(Jahrgang j) throws DocumentException {
        if (j.getSportgruppenzahl() != 0) {
            Paragraph preface = new Paragraph();
            addEmptyLine(preface, 1);
            preface.add(new Paragraph(j.getJahrgang() + ". Klassen: Sportgruppen", smallBold));
            addEmptyLine(preface, 1);
            document.add(preface);

            Paragraph tabelle = new Paragraph();

            createTableSportGruppe(tabelle, j);
            document.add(tabelle);
            Paragraph bottom = new Paragraph();
            addEmptyLine(bottom, 1);
            bottom.add(new Paragraph("" + new Date(), Fußnote));
            document.add(bottom);
            // Start a new page
            document.newPage();
        }
    }

    private void fremdsprachenGruppeDrucken(Jahrgang j) throws DocumentException {
        if (j.getSprachengruppenzahl() != 0) {
            Paragraph preface = new Paragraph();
            addEmptyLine(preface, 1);
            preface.add(new Paragraph(j.getJahrgang() + ". Klassen: Fremdsprachengruppen", smallBold));
            addEmptyLine(preface, 1);
            document.add(preface);

            Paragraph tabelle = new Paragraph();
            createTableFremdsprachenGruppe(tabelle, j);
            document.add(tabelle);

            Paragraph bottom = new Paragraph();
            addEmptyLine(bottom, 1);
            bottom.add(new Paragraph("" + new Date(), Fußnote));
            document.add(bottom);
            // Start a new page
            document.newPage();
        }
    }

    private void zweigGruppeDrucken(Jahrgang j) throws DocumentException {
        if (j.getZweiggruppenzahl() != 0) {
            Paragraph preface = new Paragraph();
            addEmptyLine(preface, 1);
            preface.add(new Paragraph(j.getJahrgang() + ". Klassen: Zweiggruppen", smallBold));
            addEmptyLine(preface, 1);
            document.add(preface);

            Paragraph tabelle = new Paragraph();

            createTableZweigGruppe(tabelle, j);
            document.add(tabelle);
            Paragraph bottom = new Paragraph();
            addEmptyLine(bottom, 1);
            bottom.add(new Paragraph("" + new Date(), Fußnote));
            document.add(bottom);
            // Start a new page
            document.newPage();
        }
    }

    private void klassenDrucken(Jahrgang j) throws DocumentException {

        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(j.getJahrgang() + ". Klassen", smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);

        Paragraph tabelle = new Paragraph();
        createTableKlassen(tabelle, j);
        document.add(tabelle);

        Paragraph bottom = new Paragraph();
        addEmptyLine(bottom, 1);
        bottom.add(new Paragraph("" + new Date(), Fußnote));
        document.add(bottom);
        // Start a new page
        document.newPage();

    }

    private void createTableReligionGruppe(Paragraph newTable, Jahrgang j)
            throws BadElementException, DocumentException {

        Jahrgang aktuellerJahrgang = j;
        int n = aktuellerJahrgang.getReligionsgruppenzahl();
        System.out.println(n);

        PdfPTable table = new PdfPTable(n); // Spaltenanzahl
        table.setWidthPercentage(100f);

        for (int i = 0; i < n; i++) {
            PdfPTable tableI = new PdfPTable(1);
            tableI.setHeaderRows(1);
            tableI.addCell((new Phrase(aktuellerJahrgang.getJahrgang() + " - " + aktuellerJahrgang.getReligionsgruppen().get(i).getTitel() + " Anzahl: " + aktuellerJahrgang.getReligionsgruppen().get(i).getReligiongroesse(), tableHeadFont)));

            for (Student s : aktuellerJahrgang.getReligionsgruppen().get(i).getSchueler()) {
                Font font = getColorForClass(s);
                tableI.addCell(new Phrase((s.getKlasse() + " " + s.getName() + " " + " " + s.getBemerkung()), font));
            }

            table.addCell(tableI);
        }

        table.addCell("1.1");
        newTable.add(table);

    }

    private void createTableSportGruppe(Paragraph newTable, Jahrgang j)
            throws BadElementException, DocumentException {

        Jahrgang aktuellerJahrgang = j;
        int n = aktuellerJahrgang.getSportgruppenzahl();
        System.out.println(n);

        PdfPTable table = new PdfPTable(n); // Spaltenanzahl
        table.setWidthPercentage(100f);

        for (int i = 0; i < n; i++) {
            PdfPTable tableI = new PdfPTable(1);
            tableI.setHeaderRows(1);
            String titel = aktuellerJahrgang.getSportgruppen().get(i).getTitel();
            int anzahl = aktuellerJahrgang.getSportgruppen().get(i).getSportgroesse();
            tableI.addCell((new Phrase(aktuellerJahrgang.getJahrgang() + " - Sport - " + titel + "  Anzahl: " + anzahl, tableHeadFont)));

            for (Student s : aktuellerJahrgang.getSportgruppen().get(i).getSchueler()) {
                Font font = getColorForClass(s);
                tableI.addCell(new Phrase((s.getKlasse() + " " + s.getName() + " " + " " + s.getBemerkung()), font));
            }

            table.addCell(tableI);
        }

        table.addCell("1.1");
        newTable.add(table);

    }

    private void createTableFremdsprachenGruppe(Paragraph newTable, Jahrgang j)
            throws BadElementException, DocumentException {

        Jahrgang aktuellerJahrgang = j;
        int n = aktuellerJahrgang.getSprachengruppenzahl();

        PdfPTable table = new PdfPTable(n); // Spaltenanzahl
        table.setWidthPercentage(100f);

        for (int i = 0; i < n; i++) {
            PdfPTable tableI = new PdfPTable(1);
            tableI.setHeaderRows(1);
            tableI.addCell((new Phrase(aktuellerJahrgang.getJahrgang() + " - " + aktuellerJahrgang.getSprachengruppen().get(i).getTitel() + " Anzahl: " + aktuellerJahrgang.getSprachengruppen().get(i).getFremdsprachengroesse(), tableHeadFont)));

            for (Student s : aktuellerJahrgang.getSprachengruppen().get(i).getSchueler()) {
                Font font = getColorForClass(s);
                tableI.addCell(new Phrase((s.getKlasse() + " " + s.getName() + " " + " " + s.getBemerkung()), font));
            }

            table.addCell(tableI);
        }

        table.addCell("1.1");
        newTable.add(table);

    }

    private void createTableZweigGruppe(Paragraph newTable, Jahrgang j)
            throws BadElementException, DocumentException {

        Jahrgang aktuellerJahrgang = j;
        int n = aktuellerJahrgang.getZweiggruppenzahl();
        System.out.println(n);

        PdfPTable table = new PdfPTable(n); // Spaltenanzahl
        table.setWidthPercentage(100f);

        for (int i = 0; i < n; i++) {
            PdfPTable tableI = new PdfPTable(1);
            tableI.setHeaderRows(1);
            tableI.addCell((new Phrase(aktuellerJahrgang.getJahrgang() + " - " + aktuellerJahrgang.getZweiggruppen().get(i).getTitel() + " Anzahl: " + aktuellerJahrgang.getZweiggruppen().get(i).getZweiggroesse(), tableHeadFont)));

           for (Student s : aktuellerJahrgang.getZweiggruppen().get(i).getSchueler()) {

               Font font = getColorForClass(s);
                tableI.addCell(new Phrase((s.getKlasse() + " " + s.getName() + " " + " " + s.getBemerkung()), font));

            }

            table.addCell(tableI);
        }

        table.addCell("1.1");
        newTable.add(table);

    }

    private void createTableKlassen(Paragraph newTable, Jahrgang j)
            throws BadElementException, DocumentException {

        Jahrgang aktuellerJahrgang = j;
        int n = aktuellerJahrgang.getKlassenanzahl();
        System.out.println(n);

        PdfPTable table = new PdfPTable(n); // Spaltenanzahl
        table.setWidthPercentage(100f);

        for (int i = 0; i < n; i++) {
            PdfPTable tableI = new PdfPTable(1);
            tableI.setHeaderRows(1);
            tableI.addCell(new Phrase(aktuellerJahrgang.getJahrgang() + aktuellerJahrgang.getKlassen().get(i).getBuchstabe() + "  Anzahl: " + aktuellerJahrgang.getKlassen().get(i).getKlassengroesse(),
                    tableHeadFont));

            for (Student s : aktuellerJahrgang.getKlassen().get(i).getSchueler()) {

                switch (s.getReligion()) {
                    case "RK":
                        tableI.addCell(new Phrase((s.getName() + " " + s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " + s.getFs4() + " " + s.getReligion() + " " + s.getBemerkung()), tableFontRot));
                        break;
                    case "EV":
                        tableI.addCell(new Phrase((s.getName() + " " + s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " + s.getFs4() + " " + s.getReligion() + " " + s.getBemerkung()), tableFontGruen));
                        break;
                    case "ETH":
                        tableI.addCell(new Phrase((s.getName() + " " + s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " + s.getFs4() + " " + s.getReligion() + " " + s.getBemerkung()), tableFontBlau));
                        break;

                    default:
                        tableI.addCell(new Phrase((s.getName() + " " + s.getGeschlecht() + " " + s.getZweig() + " " + s.getFs2() + " " + s.getFs3() + " " + s.getFs4() + " " + s.getReligion() + " " + s.getBemerkung()), tableFontBlack));
                }

            }

            table.addCell(tableI);
        }

        table.addCell("1.1");
        newTable.add(table);

    }

    private Font getColorForClass(Student s) {
        Font font = tableFontBlack;
        switch (s.getKlasse()) {
            case "a":
                font = tableFontRot;
                break;
            case "b":
                font = tableFontGruen;
//                        tableI.addCell(new Phrase((s.getKlasse()+" "+s.getName() + " "  + " " + s.getBemerkung()), font));
                break;
            case "c":
                font = tableFontBlau;
//                        tableI.addCell(new Phrase((s.getKlasse()+" "+s.getName() + " "  + " " + s.getBemerkung()), font));
                break;
            case "d":
                font = tableFontBlack;
//                        tableI.addCell(new Phrase((s.getKlasse()+" "+s.getName() + " "  + " " + s.getBemerkung()), font));
                break;
            case "e":
                font = tableFontCyan;
//                        tableI.addCell(new Phrase((s.getKlasse()+" "+s.getName() + " "  + " " + s.getBemerkung()), font));
                break;
            case "f":
                font = tableFontMagenta;
//                        tableI.addCell(new Phrase((s.getKlasse()+" "+s.getName() + " "  + " " + s.getBemerkung()), font));
                break;
            case "g":
                font = tableFontOlive;
//                        tableI.addCell(new Phrase((s.getKlasse()+" "+s.getName() + " "  + " " + s.getBemerkung()), font));
                break;
            case "h":
                font = tableFontOrange;
                break;
        }
        return font;
    }

}
