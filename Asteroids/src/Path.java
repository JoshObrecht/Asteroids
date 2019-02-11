import java.util.ArrayList;
public class Path
	{
		ArrayList<Vector> vals;
		int place;
		public Path(Vector pos, double r, double angle)
		{
			vals = new ArrayList<Vector>();
			vals.add(pos);
			place = 0;
		}
		public Vector getNewPos()
		{
			place++;
			return vals.get(place - 1);
		}
	}
