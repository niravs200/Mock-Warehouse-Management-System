import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TimeSubject {
	
	private static TimeSubject timeSubject = null;
	private List<ITimerObserver> robots = new ArrayList<ITimerObserver>();
	
	public static TimeSubject getInstance() {
		if(timeSubject == null)
		{
			timeSubject = new TimeSubject();
		}
		return timeSubject;
	}
	
	public void attach(ITimerObserver robot)
	{
		robots.add(robot);
	}
	
	public void detach(ITimerObserver robot)
	{
		robots.remove(robot);
	}

	public void notify(int minutes) {
		ListIterator<ITimerObserver> iter = robots.listIterator();
		while(iter.hasNext())
		{
			iter.next().timeElapsed(minutes);
		}
	}
	
}
 