
public class Vector
	{
		double xr;
		double yo;
		boolean isXY;
		
		public Vector(double xr, double yo, boolean isXY)
		{
			this.xr = xr;
			this.yo = yo;
			this.isXY = isXY;
		}
		
		
		public double getXr()
			{
				return xr;
			}
		public void setXr(double xr)
			{
				this.xr = xr;
			}
		public double getYo()
			{
				return yo;
			}
		public void setYo(double yo)
			{
				this.yo = yo;
			}
		public boolean isXY()
			{
				return isXY;
			}
		public void setXY(boolean isXY)
			{
				this.isXY = isXY;
			}
		public void switchTypes()
		{
			if(isXY)
				{
					double theta = Math.atan((double)(yo/xr));
					double magnitude = Math.sqrt((Math.pow((double) xr, 2)) + (Math.pow((double) yo, 2)));
					setXr(magnitude);
					setYo(theta);
					setXY(false);
				}
			else
				{
					double newX = (Math.sin(yo) * xr);
					double newY = (Math.cos(yo) * xr);
					setXr(newX);
					setYo(newY);
					setXY(true);
				}
		}
	}
