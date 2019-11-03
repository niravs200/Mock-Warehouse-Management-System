public class Robot implements IRobot, ITimerObserver
{
	private IBattery battery;
	private State state;
	Simulation simulation;
	IWarehouseFactory factory;
	
	public Robot(IBattery battery, State startState)
	{
		this.battery = battery;
		state = startState;
		simulation = Simulation.instance();
		factory = simulation.getFactory();
	}

	@Override
	public void timeElapsed(int minutes)
	{
		State transitionState = state.timeElapsed(minutes);
		if (transitionState != null)
		{
			if (battery.hasEnoughPowerForMinutes(transitionState.getChargeRequiredForState()))
			{
				battery.drain(transitionState.getChargeRequiredForState());
				state = transitionState;
			}
			else
			{
				state = factory.makeRechargeState(transitionState,battery);
				// TODO: You must implement your recharge state transition logic here.
			}
		}
	}
	
	@Override
	public boolean isWorking()
	{
		return !state.isFinished();
	}
}
