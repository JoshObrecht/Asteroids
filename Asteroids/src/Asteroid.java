import java.util.*;
import java.awt.Polygon;
public class Asteroid extends SpaceObject
	{
		private int type;
		private Polygon bounds = new Polygon();
		
	public Asteroid(double angle, int type)
		{
			super(angle);
			this.type = type;
			pos = new Vector(80,80);
			xCord = new int[10];
			yCord = new int[10];
			updatePoints();
		}
	
		public Polygon getBounds()
		{
			return bounds;
		}
		public void setBounds(Polygon bounds)
		{
			this.bounds = bounds;
		}

		protected void updatePoints()
		{
			Vector v;
			switch(type)
			{
				case 1:
					v = new Vector(25.00, 0.087267);
					xCord[0] = pos.getX() + v.getX();
					yCord[0] = pos.getY() + v.getY();
					
					v = new Vector(30.00, 0.610865);
					xCord[1] = pos.getX() + v.getX();
					yCord[1] = pos.getY() + v.getY();
					
					v = new Vector(20.00, 1.22173);
					xCord[2] = pos.getX() + v.getX();
					yCord[2] = pos.getY() + v.getY();
					
					v = new Vector(35.00, 1.91986);
					xCord[3] = pos.getX() + v.getX();
					yCord[3] = pos.getY() + v.getY();
					
					v = new Vector(25.00 , 2.87979);
					xCord[4] = pos.getX() + v.getX();
					yCord[4] = pos.getY() + v.getY();
					
					v = new Vector(25.00, 3.75246);
					xCord[5] = pos.getX() + v.getX();
					yCord[5] = pos.getY() + v.getY();
					
					v = new Vector(35.00, 4.36332);
					xCord[6] = pos.getX() + v.getX();
					yCord[6] = pos.getY() + v.getY();
					
					v = new Vector(35.00, 5.14872);
					xCord[7] = pos.getX() + v.getX();
					yCord[7] = pos.getY() + v.getY();
					
					v = new Vector(15.00, 5.49779);
					xCord[8] = pos.getX() + v.getX();
					yCord[8] = pos.getY() + v.getY();
					
					v = new Vector(25.00, 6.10865);
					xCord[9] = pos.getX() + v.getX();
					yCord[9] = pos.getY() + v.getY();
					
					bounds.xpoints = getxCord();
					bounds.ypoints = getyCord();
					bounds.npoints = getNumPoints();
					
					break;
				case 2:
					v = new Vector(25.00, 0.087267);
					xCord[0] = pos.getX() + v.getX();
					yCord[0] = pos.getY() + v.getY();
					
					v = new Vector(30.00, 0.610865);
					xCord[1] = pos.getX() + v.getX();
					yCord[1] = pos.getY() + v.getY();
					
					v = new Vector(20.00, 1.22173);
					xCord[2] = pos.getX() + v.getX();
					yCord[2] = pos.getY() + v.getY();
					
					v = new Vector(35.00, 1.91986);
					xCord[3] = pos.getX() + v.getX();
					yCord[3] = pos.getY() + v.getY();
					
					v = new Vector(25.00 , 2.87979);
					xCord[4] = pos.getX() + v.getX();
					yCord[4] = pos.getY() + v.getY();
					
					v = new Vector(25.00, 3.75246);
					xCord[5] = pos.getX() + v.getX();
					yCord[5] = pos.getY() + v.getY();
					
					v = new Vector(35.00, 4.36332);
					xCord[6] = pos.getX() + v.getX();
					yCord[6] = pos.getY() + v.getY();
					
					v = new Vector(35.00, 5.14872);
					xCord[7] = pos.getX() + v.getX();
					yCord[7] = pos.getY() + v.getY();
					
					v = new Vector(15.00, 5.49779);
					xCord[8] = pos.getX() + v.getX();
					yCord[8] = pos.getY() + v.getY();
					
					v = new Vector(25.00, 6.10865);
					xCord[9] = pos.getX() + v.getX();
					yCord[9] = pos.getY() + v.getY();
					break;
			}
			
		}
	}
