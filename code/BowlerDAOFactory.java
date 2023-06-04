public class BowlerDAOFactory {
    public static BowlerDAO getBowlerDAO() {
        return new BowlerDAOProxy(LocalBowlerDAO.getInstance());
    }
}