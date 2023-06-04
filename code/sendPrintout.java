import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class sendPrintout extends ScoreReport {
    public sendPrintout(Bowler bowler, int[] scores, int games) {
        super(bowler, scores, games);
    }

    @Override
    public void send() {
        PrinterJob job = PrinterJob.getPrinterJob();

        PrintableText printobj = new PrintableText(this.getContent());

        job.setPrintable(printobj);

        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException e) {
                System.out.println(e);
            }
        }

    }
}
