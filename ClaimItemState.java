
public class ClaimItemState extends State{

	public ClaimItemState() {
		minutesRequiredForState = 1;
	}
	
	@Override
	public State timeElapsed(int minutes) {
		minutesElapsed = minutesElapsed + minutes;
		Simulation simulation = Simulation.instance();
		Shelf shelf = simulation.getShelf();
		IWarehouseFactory factory = simulation.getFactory();
		
		if(shelf.getItemCount()<=0)
		{
			if(minutesRequiredForState-minutesElapsed <= 0) {
				return factory.makeIdealState();
			}
			else
			{
				return null;
			}
		}
		else
		{
			shelf.claimItem();
			return 	factory.makeMoveToShelfState();
		}
	}
}

