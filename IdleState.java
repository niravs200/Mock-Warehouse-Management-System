
public class IdleState extends State{

	public IdleState() {
		minutesRequiredForState = 0;
	}
	
	@Override
	public State timeElapsed(int minutes) {
		Simulation simulation = Simulation.instance();
		Shelf shelf = simulation.getShelf();
		IWarehouseFactory factory = simulation.getFactory();
		if(shelf.getItemCount()>0)
		{
			return factory.makeClaimItemState();
		}
		else
		{
			return factory.makeFinishedState();
		}
	}
}
