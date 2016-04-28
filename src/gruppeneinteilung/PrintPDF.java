package gruppeneinteilung;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;

public class PrintPDF {

    public static void main(String[] args) {
        new PrintPDF(new Gruppeneinteilung("ASV.csv"));
    }

    private String FILE;
    Document document;
    //private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
    //Font.BOLD);
    //private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
    // Font.NORMAL, BaseColor.RED);
    private static Font tableFont = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    Gruppeneinteilung ge;

    public PrintPDF(Gruppeneinteilung ge) {
        this.ge = ge;
        this.FILE = "Ausdruck.pdf";
        document = new Document();
        document.setPageSize(PageSize.A4.rotate());
        document.setMargins(5f, 5f, 5f, 5f);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Hier mal irgendwann anpassen
    private void addMetaData(Document document) {
        document.addTitle("Gruppeneinteilung");
        //document.addSubject("");
        //document.addKeywords("");
        //document.addAuthor();
        //document.addCreator("");
    }

    private void addContent(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();

        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Erstellt von: " + System.getProperty("user.name") + ", " + new Date(), smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);
        // Start a new page
        //document.newPage();
        Paragraph tabelle = new Paragraph();

        createTable(tabelle);
        document.add(tabelle);
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private void createTable(Paragraph subCatPart)
            throws BadElementException, DocumentException {

        PdfPTable table = new PdfPTable(5); // Spaltenanzahl

        float[] columnWidths = new float[]{50f, 50f, 50f, 50f, 40f};
        //table.setTotalWidth(columnWidths);
        table.setWidthPercentage(100f);
         //table.setBorderColor(BaseColor.BLACK);
        // t.setPadding(4);
        // t.setSpacing(4);
        //t.setBorderWidth(1);

          //  PdfPCell c1 = new PdfPCell();//(new Phrase("Name"));
        //   c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        //  table.addCell(c1);
        //table.setHeaderRows(1);

        for (int i = 0; i < 25; i++) {
            table.addCell(new Phrase((ge.getJahrgang(5).gibAlle().get(i).toString()), tableFont));
        }

        //table.addCell("1.1");
        // table.addCell("1.2");
        //  table.addCell("2.1");
        // table.addCell("2.2");
        // table.addCell("2.3");
        subCatPart.add(table);

    }

}
