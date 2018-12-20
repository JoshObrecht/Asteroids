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
	
		public Polygon getAstBounds()
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
			
			v = new Vector(((Math.random()*50)+50), angle+(Math.random()*0.523599));
			xCord[0] = pos.getX() + v.getX();
			yCord[0] = pos.getY() + v.getY();
					
			v = new Vector(((Math.random()*50)+50), angle+((Math.random()*0.523601)+0.523599));
			xCord[1] = pos.getX() + v.getX();
			yCord[1] = pos.getY() + v.getY();
					
			v = new Vector(((Math.random()*50)+50), angle+((Math.random()*0.5236)+1.0472));
			xCord[2] = pos.getX() + v.getX();
			yCord[2] = pos.getY() + v.getY();
					
			v = new Vector(((Math.random()*50)+50), angle+((Math.random()*.78539)+1.5708));
			xCord[3] = pos.getX() + v.getX();
			yCord[3] = pos.getY() + v.getY();
					
			v = new Vector(((Math.random()*50)+50), angle+((Math.random()*.78539)+2.35619));
			xCord[4] = pos.getX() + v.getX();
			yCord[4] = pos.getY() + v.getY();
					
			v = new Vector(((Math.random()*50)+50), angle+((Math.random()*.5236)+3.14159));
			xCord[5] = pos.getX() + v.getX();
			yCord[5] = pos.getY() + v.getY();
					
			v = new Vector(((Math.random()*50)+50), angle+((Math.random()*.5236)+3.66519));
			xCord[6] = pos.getX() + v.getX();
			yCord[6] = pos.getY() + v.getY();
					
			v = new Vector(((Math.random()*50)+50), angle+((Math.random()*.5236)+4.18879));
			xCord[7] = pos.getX() + v.getX();
			yCord[7] = pos.getY() + v.getY();
					
			v = new Vector(((Math.random()*50)+50), ((Math.random()*.7854)+4.71239));
			xCord[8] = pos.getX() + v.getX();
			yCord[8] = pos.getY() + v.getY();
					
			v = new Vector(((Math.random()*50)+50), ((Math.random()*.7854)+5.49779));
			xCord[9] = pos.getX() + v.getX();
			yCord[9] = pos.getY() + v.getY();
		
			
		}
	}
