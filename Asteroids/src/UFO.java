
public class UFO extends SpaceObject
	{
		public UFO(double angle)
		{
			super(angle);
			pos = new Vector(950,500);
			vel = new Vector(0,0);
			xCord = new int[8];
			yCord = new int[8];
			numPoints = 8;
			updatePoints();
		}
		protected void updatePoints()
		{
			Vector v = new Vector(35.00, angle);
			xCord[0] = v.getX() + pos.getX();
			yCord[0] = v.getY() + pos.getY();
			v = new Vector(28.00, angle + ((1 * Math.PI) / 8));
			xCord[1] = v.getX() + pos.getX();
			yCord[1] = v.getY() + pos.getY();
			v = new Vector(28.00, angle + ((7 * Math.PI) / 8));
			xCord[2] = v.getX() + pos.getX();
			yCord[2] = v.getY() + pos.getY();
			v = new Vector(35.00, angle + ((8 * Math.PI) / 8));
			xCord[3] = v.getX() + pos.getX();
			yCord[3] = v.getY() + pos.getY();
			v = new Vector(18.00, angle + ((10 * Math.PI) / 8));
			xCord[4] = v.getX() + pos.getX();
			yCord[4] = v.getY() + pos.getY();
			v = new Vector(28.00, angle + ((11 * Math.PI) / 8));
			xCord[5] = v.getX() + pos.getX();
			yCord[5] = v.getY() + pos.getY();
			v = new Vector(28.00, angle + ((13 * Math.PI) / 8));
			xCord[6] = v.getX() + pos.getX();
			yCord[6] = v.getY() + pos.getY();
			v = new Vector(18.00, angle + ((14 * Math.PI) / 8));
			xCord[7] = v.getX() + pos.getX();
			yCord[7] = v.getY() + pos.getY();
		}
	}
