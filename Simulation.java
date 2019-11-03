import java.util.*;

public class Simulation
{
	private static Simulation theOneInstance = null;
	private IWarehouseFactory factory;
	private List<Object> robots;
	private int minutesToCompleteSimulation;
	private Shelf shelf;
	TimeSubject timeSubject;
	
	public Simulation()
	{
		robots = new ArrayList<Object>();
		minutesToCompleteSimulation = 0;
		shelf = new Shelf();
		timeSubject = TimeSubject.getInstance();
	}
	
	public static Simulation instance()
	{
		if (null == theOneInstance)
		{
			theOneInstance = new Simulation();
		}
		return theOneInstance;
	}
	
	public IWarehouseFactory getFactory()
	{
		return factory;
	}
	
	public Shelf getShelf()
	{
		return shelf;
	}
	
	public void build(Arguments args, IWarehouseFactory factory)
	{
		this.factory = factory;
		shelf.setItemCount(args.getShelfCount());
		int numberOfBatteryPack = args.getNumBatteryPacks();
		int packCapacity = args.getBatteryPackCapacity();
		int batteryCapacity = args.getDefaultBatteryCapacity();
		for(int numRobots=0; numRobots<args.getNumRobots(); numRobots++)
		{
			if(numberOfBatteryPack!=0)
			{
				numberOfBatteryPack--;
				IRobot robot = factory.makeRobotWithBatteryPack(batteryCapacity, packCapacity);
				robots.add(robot);
				timeSubject.attach((ITimerObserver) robot);
			}
			else
			{
				IRobot robot = factory.makeRobot(batteryCapacity);
				robots.add(robot);
				timeSubject.attach((ITimerObserver) robot);
			}
		}	
	}
	
	public int run()
	{
		System.out.println("Simulation begun!");
		boolean robotsStillWorking = true;
		while (robotsStillWorking)
		{			
			minutesToCompleteSimulation += 1;
			timeSubject.notify(1);
			robotsStillWorking = false;
			ListIterator<Object> iter = robots.listIterator();
			while (iter.hasNext())
			{
				IRobot robot = (IRobot)iter.next();
				if (robot.isWorking())
				{
					robotsStillWorking = true;
					break;
				}
			}
		}
		System.out.println("Simulation complete!");
		return minutesToCompleteSimulation;
	}
}

















