
public class Vector
	{
		int x;
		int y;
		int r;
		double o;
		boolean isXY;
		
		public Vector(int x, int y)
		{
			this.x = x;
			this.y = y;
			isXY = true;
		}
		public Vector(int r, double o)
		{
			this.r = r;
			this.o = o;
			isXY = false;
		}
		
		public Vector switchTypes()
		{
			if(isXY)
				{
					double theta = Math.atan((double)(y/x));
					int magnitude = (int) Math.sqrt((Math.pow((double) x, 2)) + (Math.pow((double) x, 2)));
					return new Vector(magnitude, theta);
				}
			else
				{
					int newX = 0;
					int newY = 0;
					return new Vector(newX, newY);
				}
		}
	}
