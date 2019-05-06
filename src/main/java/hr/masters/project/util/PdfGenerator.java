package hr.masters.project.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import hr.masters.project.model.TicketModel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PdfGenerator
{
    public static ByteArrayInputStream makePdfReport(final List<TicketModel> ticketList)
    {
        final Document document = new Document();
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try
        {
            final PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setWidths(new int[] { 4, 3, 3, 3, 4 });

            final Font headFont = FontFactory.getFont(FontFactory.COURIER_BOLD);

            PdfPCell hcell;

            hcell = new PdfPCell(new Phrase("Ticket", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Outcome", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Stake", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Coefficient", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Winning", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            ticketList.stream().forEach(ticket -> createTableCell(ticket, table));

            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            document.add(table);
            document.close();
        }
        catch (final DocumentException ex)
        {
            Logger.getLogger(PdfGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    private static void createTableCell(final TicketModel ticket, final PdfPTable table)
    {
        PdfPCell cell;

        cell = new PdfPCell(new Phrase(String.valueOf(ticket.getTicket())));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(String.valueOf(ticket.getOutcome())));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(String.valueOf(ticket.getStake())));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(String.valueOf(ticket.getCoefficient())));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(String.valueOf(ticket.getWinning())));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }
}
