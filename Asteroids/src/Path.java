import java.util.ArrayList;
public class Path
	{
		ArrayList<Vector> vals;
		int place;
		double angle;
		double r;
		public Path(Vector pos, double r, double angle)
		{
			vals = new ArrayList<Vector>();
			vals.add(pos);
			place = 0;
			this.angle = angle;
			this.r = r;
			generateVals();
		}
		public Vector getNewPos()
		{
			place++;
			return vals.get(place - 1);
		}
		private void generateVals()
		{
			double k = 0;
			for(int i = 0; i < 999; i++)
				{
					k+=r;
					Vector v = new Vector(k, angle);
					vals.add(new Vector(vals.get(0).getX() + v.getX(), vals.get(0).getY() + v.getY()));
				}
		}
	}
