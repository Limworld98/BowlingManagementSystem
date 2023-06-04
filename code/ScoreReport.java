/**
 * 
 * SMTP implementation based on code by R�al Gagnon mailto:real@rgagnon.com
 * 
 */


import java.io.*;
import java.util.Vector;
import java.util.Iterator;
import java.net.*;
import java.awt.*;
import java.awt.print.*;

public abstract class ScoreReport {

	private String content;
	
	public ScoreReport( Bowler bowler, int[] scores, int games ) {
		String nick = bowler.getNickName();
		String full = bowler.getFullName();
		Vector v = null;
		try{
			v = ScoreHistoryFile.getScores(nick);
		} catch (Exception e){System.err.println("Error: " + e);}
		
		Iterator scoreIt = v.iterator();
		
		content = "";
		content += "--Lucky Strike Bowling Alley Score Report--\n";
		content += "\n";
		content += "Report for " + full + ", aka \"" + nick + "\":\n";
		content += "\n";
		content += "Final scores for this session: ";
		content += scores[0];
		for (int i = 1; i < games; i++){
			content += ", " + scores[i];
		}
		content += ".\n";
		content += "\n";
		content += "\n";

		content += "Previous scores by date: \n";
		int AvgSum = 0;
		int AvgCnt = 0;
		while (scoreIt.hasNext()){
			Score score = (Score) scoreIt.next();
			content += "  " + score.getDate() + " - " +  score.getScore();
			AvgCnt++;
			AvgSum += Integer.parseInt(score.getScore());
			content += "\n";
		}
		content += "\n\n";
		//New
		content += "Average score: ";
		content += Integer.toString(AvgSum/AvgCnt);
		content += "\n\n";
		content += "Thank you for your continuing patronage.";

	}

	public void send() {}

	public String getContent(){
		return content;
	}

}
