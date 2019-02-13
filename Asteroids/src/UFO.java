import java.awt.Polygon;

public class UFO extends SpaceObject
	{
		public UFO(double angle, Vector v)
		{
			super(angle);
			pos = v;
			vel = new Vector((Math.random() * 4) + 1, angle);
			xCord = new int[8];
			yCord = new int[8];
			numPoints = 8;
			bounds = new Polygon();
			path = new Path(pos, vel.getR(), angle);
			updatePoints();
		}
		protected void updatePoints()
		{
			Vector v = new Vector(35.00, 0);
			xCord[0] = v.getX() + pos.getX();
			yCord[0] = v.getY() + pos.getY();
			v = new Vector(28.00, ((1 * Math.PI) / 8));
			xCord[1] = v.getX() + pos.getX();
			yCord[1] = v.getY() + pos.getY();
			v = new Vector(28.00, ((7 * Math.PI) / 8));
			xCord[2] = v.getX() + pos.getX();
			yCord[2] = v.getY() + pos.getY();
			v = new Vector(35.00, ((8 * Math.PI) / 8));
			xCord[3] = v.getX() + pos.getX();
			yCord[3] = v.getY() + pos.getY();
			v = new Vector(18.00, ((10 * Math.PI) / 8));
			xCord[4] = v.getX() + pos.getX();
			yCord[4] = v.getY() + pos.getY();
			v = new Vector(28.00, ((11 * Math.PI) / 8));
			xCord[5] = v.getX() + pos.getX();
			yCord[5] = v.getY() + pos.getY();
			v = new Vector(28.00, ((13 * Math.PI) / 8));
			xCord[6] = v.getX() + pos.getX();
			yCord[6] = v.getY() + pos.getY();
			v = new Vector(18.00, ((14 * Math.PI) / 8));
			xCord[7] = v.getX() + pos.getX();
			yCord[7] = v.getY() + pos.getY();
			
			bounds = new Polygon(xCord, yCord, xCord.length);
		}
		public void tick()
		{
			super.tick();
			int random = (int)((Math.random() * 100) + 1);
			if(random == 69)
			{
				angle = (Math.random() * (Math.PI * 2));
				path = new Path(pos, vel.getR(), angle);
			}
		}
	}
