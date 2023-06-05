import java.util.List;

public class BowlerDAOProxy implements BowlerDAO {
    private BowlerDAO bowlerDAO;
    private List<String> cachedBowlerNicknames;

    public BowlerDAOProxy(BowlerDAO bowlerDAO) {
        this.bowlerDAO = bowlerDAO;
    }

    @Override
    public Bowler getBowler(String nickName) {
        return bowlerDAO.getBowler(nickName);
    }

    @Override
    public void addBowler(String nickName, String fullName, String email) {
        bowlerDAO.addBowler(nickName, fullName, email);
        cachedBowlerNicknames = null;
    }

    @Override
    public List<String> getAllBowlerNickNames() {
        if (cachedBowlerNicknames == null) {
            cachedBowlerNicknames = bowlerDAO.getAllBowlerNickNames();
        }
        return cachedBowlerNicknames;
    }
}