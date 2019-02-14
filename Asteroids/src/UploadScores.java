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
//					System.out.println("b e     t");
				}
			
		
			Collections.sort(AsteroidsRunner.highScores, new ScoreSorter());
			Collections.reverse(AsteroidsRunner.highScores);
		}
		public static void createDefaultScores()
		{
			AsteroidsRunner.highScores.add(new Score(1, "WIL"));
			AsteroidsRunner.highScores.add(new Score(2, "FRE"));
			AsteroidsRunner.highScores.add(new Score(3, "GAR"));
			AsteroidsRunner.highScores.add(new Score(4, "JAN"));
			AsteroidsRunner.highScores.add(new Score(5, "BAR"));
			AsteroidsRunner.highScores.add(new Score(6, "JON"));
			AsteroidsRunner.highScores.add(new Score(7, "JEF"));
			AsteroidsRunner.highScores.add(new Score(8, "CAL"));
			AsteroidsRunner.highScores.add(new Score(9, "AND"));
			AsteroidsRunner.highScores.add(new Score(10,"JOS"));
		}
	}
