
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
		public void setXSafe(double x)
		{
			this.x = x;
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
		public void setYSafe(double y)
		{
			this.y = y;
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
		public void setRSafe(double r)
		{
			this.r = r;
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
		public void setOSafe(double o)
		{
			this.o = o;
		}
		
		private void updateTypes(boolean isXY)
		{
			if(isXY)
				{
					double theta = Math.atan((double)(y/x));
					double magnitude = Math.sqrt((Math.pow((double) x, 2)) + (Math.pow((double) y, 2)));
					setRSafe(magnitude);
					setOSafe(theta);
				}
			else
				{
					double newX = (Math.sin(o) * r);
					double newY = (Math.cos(o) * r);
					setXSafe(newX);
					setYSafe(newY);
				}
		}
	}
