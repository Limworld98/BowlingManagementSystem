import java.io.*;
import java.util.*;
import java.util.List;

public class LocalBowlerDAO implements BowlerDAO {
    private static final String BOWLER_DAT = "BOWLERS.DAT";

    private static volatile LocalBowlerDAO instance;

    private LocalBowlerDAO() {}

    public static LocalBowlerDAO getInstance() {
        if (instance == null) {
            synchronized (LocalBowlerDAO.class) {
                if (instance == null) {
                    instance = new LocalBowlerDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public Bowler getBowler(String nickName) {
        try (BufferedReader in = new BufferedReader(new FileReader(BOWLER_DAT))) {
            String data;
            while ((data = in.readLine()) != null) {
                String[] bowler = data.split("\t");
                if (nickName.equals(bowler[0])) {
                    System.out.println(
                            "Nick: "
                                    + bowler[0]
                                    + " Full: "
                                    + bowler[1]
                                    + " email: "
                                    + bowler[2]);
                    return new Bowler(bowler[0], bowler[1], bowler[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addBowler(String nickName, String fullName, String email) {
        try (RandomAccessFile out = new RandomAccessFile(BOWLER_DAT, "rw")) {
            String data = nickName + "\t" + fullName + "\t" + email + "\n";

            out.skipBytes((int) out.length());
            out.writeBytes(data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getAllBowlerNickNames() {
        List<String> allBowlers = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(BOWLER_DAT))) {
            String data;
            while ((data = in.readLine()) != null) {
                String[] bowler = data.split("\t");
                allBowlers.add(bowler[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allBowlers;
    }
}