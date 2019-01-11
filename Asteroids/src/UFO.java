
public class UFO extends SpaceObject
	{
		public UFO(double angle)
		{
			super(angle);
			pos = new Vector(950,500);
			vel = new Vector(0,0);
			xCord = new int[6];
			yCord = new int[6];
			numPoints = 6;
			updatePoints();
		}
		protected void updatePoints()
		{
			Vector v = new Vector(30.00, angle);
			xCord[0] = v.getX() + pos.getX();
			yCord[0] = v.getY() + pos.getY();
			v = new Vector(20.00, angle + ((1 * Math.PI) / 8));
			xCord[1] = v.getX() + pos.getX();
			yCord[1] = v.getY() + pos.getY();
			v = new Vector(20.00, angle + ((7 * Math.PI) / 8));
			xCord[2] = v.getX() + pos.getX();
			yCord[2] = v.getY() + pos.getY();
			v = new Vector(30.00, angle + ((8 * Math.PI) / 8));
			xCord[3] = v.getX() + pos.getX();
			yCord[3] = v.getY() + pos.getY();
			v = new Vector(20.00, angle + ((9 * Math.PI) / 8));
			xCord[4] = v.getX() + pos.getX();
			yCord[4] = v.getY() + pos.getY();
			v = new Vector(20.00, angle + ((15 * Math.PI) / 8));
			xCord[5] = v.getX() + pos.getX();
			yCord[5] = v.getY() + pos.getY();
		}
	}
