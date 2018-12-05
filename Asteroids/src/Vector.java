
public class Vector
	{
		double x;
		double y;
		double r;
		double o;
		
		public Vector(double x, double y) //Vectors always initialize in XY form
		{
			this.x = x;
			this.y = y;
			updateTypes(true);
		}
		
		
		
		public double getX()
			{
				return x;
			}
		public void setX(double x)
			{
				this.x = x;
				updateTypes(true);
			}
		public double getY()
			{
				return y;
			}
		public void setY(double y)
			{
				this.y = y;
				updateTypes(true);
			}
		public double getR()
			{
				return r;
			}
		public void setR(double r)
			{
				this.r = r;
				updateTypes(false);
			}
		public double getO()
			{
				return o;
			}
		public void setO(double o)
			{
				this.o = o;
				updateTypes(false);
			}
		private void updateTypes(boolean isXY)
		{
			if(isXY)
				{
					double theta = Math.atan((double)(y/x));
					double magnitude = Math.sqrt((Math.pow((double) x, 2)) + (Math.pow((double) y, 2)));
					setR(magnitude);
					setO(theta);
				}
			else
				{
					double newX = (Math.sin(o) * r);
					double newY = (Math.cos(o) * r);
					setX(newX);
					setY(newY);
				}
		}
	}
