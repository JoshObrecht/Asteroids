import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class UploadScores
	{
		public static void writeScores()
		{
			String filename = "HighScores.ser";
			ArrayList<Score> tempHighScores = new ArrayList<Score>();
			
			try
				{
					FileOutputStream file = new FileOutputStream(filename);
					ObjectOutputStream out = new ObjectOutputStream(file);
					
					tempHighScores = AsteroidsRunner.highScores;

					out.writeObject(tempHighScores);
					
					out.close();
					file.close();
				}
			
			catch(Exception e)
				{
					System.out.println("b e t");
				}
			AsteroidsRunner.highScores=tempHighScores;
		}
		public static void readScores()
		{
			String filename ="HighScores.ser";
			ArrayList<Score> tempHighScores2 = new ArrayList<Score>();
			
			try
				{
			FileInputStream file= new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			tempHighScores2=(ArrayList<Score>)in.readObject();
			AsteroidsRunner.highScores= tempHighScores2;
			

			
			in.close();
			file.close();
				}
			catch(Exception e)
				{
					System.out.println("b e     t");
				}
			
		
			Collections.sort(AsteroidsRunner.highScores, new ScoreSorter());
			Collections.reverse(AsteroidsRunner.highScores);
		}
		public static void createDefaultScores()
		{
			AsteroidsRunner.highScores.add(new Score(0, "WIL"));
			AsteroidsRunner.highScores.add(new Score(0, "FRE"));
			AsteroidsRunner.highScores.add(new Score(0, "GAR"));
			AsteroidsRunner.highScores.add(new Score(0, "JAN"));
			AsteroidsRunner.highScores.add(new Score(0, "BAR"));
			AsteroidsRunner.highScores.add(new Score(0, "JON"));
			AsteroidsRunner.highScores.add(new Score(0, "JEF"));
			AsteroidsRunner.highScores.add(new Score(0, "CAL"));
			AsteroidsRunner.highScores.add(new Score(0, "AND"));
			AsteroidsRunner.highScores.add(new Score(0,"JOS"));
		}
	}
