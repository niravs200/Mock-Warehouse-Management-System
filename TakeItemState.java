
public class TakeItemState extends State{
	public TakeItemState() {
		minutesRequiredForState = 2;
	}
	
	@Override
	public State timeElapsed(int minutes) {
		minutesElapsed = minutesElapsed + minutes;
		Simulation simulation = Simulation.instance();
		IWarehouseFactory factory = simulation.getFactory();
		if(minutesRequiredForState-minutesElapsed <= 0)
		{
			return factory.makeMoveToTruckState();
		}
		else
		{
			return null;
		}
	}

}
