
public abstract class BatteryDecorator implements IBattery{
	
	protected Battery battery;
	
	public BatteryDecorator(Battery battery)
	{
		this.battery = battery;
	}


	public abstract boolean hasEnoughPowerForMinutes(int minutes);
	public abstract boolean isFullyCharged();
	public abstract void drain(int minutes);
	public abstract void recharge(int minutes);}
