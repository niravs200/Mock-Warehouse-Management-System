
public class MoveToTruckState extends State{

	public MoveToTruckState() {
		minutesRequiredForState = 4;
	}
	
	@Override
	public State timeElapsed(int minutes) {
		minutesElapsed = minutesElapsed + minutes;
		Simulation simulation = Simulation.instance();
		IWarehouseFactory factory = simulation.getFactory();
		if(minutesRequiredForState-minutesElapsed <= 0)
		{
			return factory.makeLoadTruckState();
		}
		else
		{
			return null;
		}
	}

}
