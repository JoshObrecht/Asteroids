
public class Bullet extends SpaceObject
	{

	public Bullet(double angle, int x, int y, double speed)
		{
			super(angle);
			pos = new Vector(0,0);
			pos.setX(x);
			pos.setY(y);
			vel = new Vector(10.00 + speed, angle);
			path = new Path(pos, vel.getR(), angle);
		}

	protected void updatePoints()
		{
			// TODO Auto-generated method stub
			
		}

	}
