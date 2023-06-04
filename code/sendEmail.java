import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class sendEmail extends ScoreReport{
    public sendEmail(Bowler bowler, int[] scores, int games) {
        super(bowler, scores, games);
    }

    public void send(String recipient) {
        try {
            Socket s = new Socket("osfmail.rit.edu", 25);
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(s.getInputStream(), "8859_1"));
            BufferedWriter out =
                    new BufferedWriter(
                            new OutputStreamWriter(s.getOutputStream(), "8859_1"));

            String boundary = "DataSeparatorString";

            // here you are supposed to send your username
            sendln(in, out, "HELO world");
            sendln(in, out, "MAIL FROM: <mda2376@rit.edu>");
            sendln(in, out, "RCPT TO: <" + recipient + ">");
            sendln(in, out, "DATA");
            sendln(out, "Subject: Bowling Score Report ");
            sendln(out, "From: <Lucky Strikes Bowling Club>");

            sendln(out, "Content-Type: text/plain; charset=\"us-ascii\"\r\n");
            sendln(out, this.getContent() + "\n\n");
            sendln(out, "\r\n");

            sendln(in, out, ".");
            sendln(in, out, "QUIT");
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendln(BufferedReader in, BufferedWriter out, String s) {
        try {
            out.write(s + "\r\n");
            out.flush();
            // System.out.println(s);
            s = in.readLine();
            // System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendln(BufferedWriter out, String s) {
        try {
            out.write(s + "\r\n");
            out.flush();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
