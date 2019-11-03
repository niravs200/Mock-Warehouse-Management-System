
public class LoadTruckState extends State{

	public LoadTruckState() {
		minutesRequiredForState = 5;
	}
	
	@Override
	public State timeElapsed(int minutes) {
		minutesElapsed = minutesElapsed + minutes;
		Simulation simulation = Simulation.instance();
		IWarehouseFactory factory = simulation.getFactory();
		if(minutesRequiredForState-minutesElapsed <= 0)
		{
			return factory.makeIdealState();
		}
		else
		{
			return null;
		}
	}

}
