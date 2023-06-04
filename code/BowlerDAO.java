import java.util.List;

public interface BowlerDAO {
    Bowler getBowler(String nickName);
    void addBowler(String nickName, String fullName, String email);
    List<String> getAllBowlerNickNames();
}