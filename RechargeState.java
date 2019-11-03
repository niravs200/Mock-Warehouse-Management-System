
public class RechargeState extends State{

	State previousState;
	IBattery battery;
	
	public RechargeState(State previouState,IBattery battery) {
		this.previousState = previouState;
		this.battery = battery;
		minutesRequiredForState = 0;
	}

	@Override
	public State timeElapsed(int minutes) {
		battery.recharge(minutes);
		if(battery.isFullyCharged())
		{
			return previousState;
		}
		else
		{
			
			return null;
		}
	}
}
