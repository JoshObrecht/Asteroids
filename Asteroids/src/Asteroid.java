import java.awt.Polygon;
public class Asteroid extends SpaceObject
	{
		private double[] magnitudes;
		private double[] angles;
		private int size1;
		private int size2;
		
	public Asteroid(double angle, int s1, int s2, Vector v)
		{
			super(angle);
			pos = v;
			xCord = new int[10];
			yCord = new int[10];
			magnitudes = new double[10];
			angles = new double[10];
			bounds = new Polygon();
			vel = new Vector(2.00, angle);
			rotationSpeed = 0.03;
			size1=s1;
			size2=s2;
			createPoints();
		}
		
		protected void createPoints()
		{
			Vector v;
			
			v = new Vector(((Math.random()*size1)+size2), angle+(Math.random()*0.523599));
			xCord[0] = pos.getX() + v.getX();
			yCord[0] = pos.getY() + v.getY();
			magnitudes[0] = v.getR();
			angles[0] = v.getO();
					
			v = new Vector(((Math.random()*size1)+size2), angle+((Math.random()*0.523601)+0.523599));
			xCord[1] = pos.getX() + v.getX();
			yCord[1] = pos.getY() + v.getY();
			magnitudes[1] = v.getR();
			angles[1] = v.getO();
					
			v = new Vector(((Math.random()*size1)+size2), angle+((Math.random()*0.5236)+1.0472));
			xCord[2] = pos.getX() + v.getX();
			yCord[2] = pos.getY() + v.getY();
			magnitudes[2] = v.getR();
			angles[2] = v.getO();
					
			v = new Vector(((Math.random()*size1)+size2), angle+((Math.random()*.78539)+1.5708));
			xCord[3] = pos.getX() + v.getX();
			yCord[3] = pos.getY() + v.getY();
			magnitudes[3] = v.getR();
			angles[3] = v.getO();
					
			v = new Vector(((Math.random()*size1)+size2), angle+((Math.random()*.78539)+2.35619));
			xCord[4] = pos.getX() + v.getX();
			yCord[4] = pos.getY() + v.getY();
			magnitudes[4] = v.getR();
			angles[4] = v.getO();
					
			v = new Vector(((Math.random()*size1)+size2), angle+((Math.random()*.5236)+3.14159));
			xCord[5] = pos.getX() + v.getX();
			yCord[5] = pos.getY() + v.getY();
			magnitudes[5] = v.getR();
			angles[5] = v.getO();
					
			v = new Vector(((Math.random()*size1)+size2), angle+((Math.random()*.5236)+3.66519));
			xCord[6] = pos.getX() + v.getX();
			yCord[6] = pos.getY() + v.getY();
			magnitudes[6] = v.getR();
			angles[6] = v.getO();
					
			v = new Vector(((Math.random()*size1)+size2), angle+((Math.random()*.5236)+4.18879));
			xCord[7] = pos.getX() + v.getX();
			yCord[7] = pos.getY() + v.getY();
			magnitudes[7] = v.getR();
			angles[7] = v.getO();
					
			v = new Vector(((Math.random()*size1)+size2), angle+((Math.random()*.7854)+4.71239));
			xCord[8] = pos.getX() + v.getX();
			yCord[8] = pos.getY() + v.getY();
			magnitudes[8] = v.getR();
			angles[8] = v.getO();
					
			v = new Vector(((Math.random()*size1)+size2), angle+((Math.random()*.7854)+5.49779));
			xCord[9] = pos.getX() + v.getX();
			yCord[9] = pos.getY() + v.getY();
			magnitudes[9] = v.getR();
			angles[9] = v.getO();
			
			bounds = new Polygon(xCord, yCord, xCord.length);
			
		}
		protected void updatePoints()
		{
			Vector v;

			v = new Vector(magnitudes[0], angle + angles[0]);
			xCord[0] = pos.getX() + v.getX();
			yCord[0] = pos.getY() + v.getY();
					
			v = new Vector(magnitudes[1], angle + angles[1]);
			xCord[1] = pos.getX() + v.getX();
			yCord[1] = pos.getY() + v.getY();
					
			v = new Vector(magnitudes[2], angle + angles[2]);
			xCord[2] = pos.getX() + v.getX();
			yCord[2] = pos.getY() + v.getY();
					
			v = new Vector(magnitudes[3], angle + angles[3]);
			xCord[3] = pos.getX() + v.getX();
			yCord[3] = pos.getY() + v.getY();
					
			v = new Vector(magnitudes[4], angle + angles[4]);
			xCord[4] = pos.getX() + v.getX();
			yCord[4] = pos.getY() + v.getY();
					
			v = new Vector(magnitudes[5], angle + angles[5]);
			xCord[5] = pos.getX() + v.getX();
			yCord[5] = pos.getY() + v.getY();
					
			v = new Vector(magnitudes[6], angle + angles[6]);
			xCord[6] = pos.getX() + v.getX();
			yCord[6] = pos.getY() + v.getY();
					
			v = new Vector(magnitudes[7], angle + angles[7]);
			xCord[7] = pos.getX() + v.getX();
			yCord[7] = pos.getY() + v.getY();
					
			v = new Vector(magnitudes[8], angle + angles[8]);
			xCord[8] = pos.getX() + v.getX();
			yCord[8] = pos.getY() + v.getY();
					
			v = new Vector(magnitudes[9], angle + angles[9]);
			xCord[9] = pos.getX() + v.getX();
			yCord[9] = pos.getY() + v.getY();
			
			bounds = new Polygon(xCord, yCord, xCord.length);
		}
		public void tick()
		{
			super.tick();
			for(int i = 0; i < angles.length; i++)
				{
					angles[i] += rotationSpeed;
				}
		}

		public int getSize1()
			{
				return size1;
			}

		public void setSize1(int size1)
			{
				this.size1 = size1;
			}

		public int getSize2()
			{
				return size2;
			}

		public void setSize2(int size2)
			{
				this.size2 = size2;
			}

		
	}
