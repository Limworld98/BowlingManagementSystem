/*
 * Party.java
 *
 * Version:
 *   $Id$
 *
 * Revisions:
 *   $Log: Party.java,v $
 *   Revision 1.3  2003/02/09 21:21:31  ???
 *   Added lots of comments
 *
 *   Revision 1.2  2003/01/12 22:23:32  ???
 *   *** empty log message ***
 *
 *   Revision 1.1  2003/01/12 19:09:12  ???
 *   Adding Party, Lane, Bowler, and Alley.
 *
 */

/**
 *  Container that holds bowlers
 *
 */

import java.util.*;

public class Party {

	/** Vector of bowlers in this party */	
    private Vector myBowlers;
	
	/**
	 * Constructor for a Party
	 * 
	 * @param bowlers	Vector of bowlers that are in this party
	 */
		
    public Party( Vector bowlers ) {
		this.myBowlers = createParty(bowlers);
    }

	/**
	 * Create Party
	 *
	 * @param bowlers	Vector of bowlers that are in this party
	 * */

	public Vector createParty(Vector bowlers) {
		Vector partyBowlers = new Vector();
		for (int i = 0; i < bowlers.size(); i++) {
			Bowler newBowler = registerPatron(((String) bowlers.get(i)));
			partyBowlers.add(newBowler);
		}
		return partyBowlers;
	}

	/**
	 * Retrieves a matching Bowler from the bowler database.
	 *
	 * @param nickName	The NickName of the Bowler
	 *
	 * @return a Bowler object.
	 *
	 */

	public Bowler registerPatron(String nickName) {
		Bowler patron = BowlerDAOFactory.getBowlerDAO().getBowler(nickName);
		return patron;
	}

	/**
	 * Accessor for members in this party
	 * 
	 * @return 	A vector of the bowlers in this party
	 */

    public Vector getMembers() {
		return myBowlers;
    }

}
