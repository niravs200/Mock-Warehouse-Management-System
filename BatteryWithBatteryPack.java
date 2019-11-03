
public class BatteryWithBatteryPack extends BatteryDecorator{

	private int batteryPackCapacity;
	private int batteryPackCharge;
	
	public BatteryWithBatteryPack(Battery battery,int batteryPackCapacity) {
		super(battery);
		this.batteryPackCapacity = batteryPackCapacity;
		batteryPackCharge = batteryPackCapacity;
	}

	@Override
	public boolean hasEnoughPowerForMinutes(int minutes) {
		int batteryCharge = battery.getCharge();
		int totalCharge = batteryCharge + batteryPackCharge;
		if (totalCharge - minutes >= 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isFullyCharged() {
		if(batteryPackCharge == batteryPackCapacity && battery.isFullyCharged())
		{
			return true;
		}
		return false;
	}

	@Override
	public void drain(int minutes) {
		for(int i=0;i<minutes;i++)
		{
			if(batteryPackCharge>0)
			{
				batteryPackCharge -= 1;
				batteryPackCharge = Math.max(batteryPackCharge, 0);
			}
			else
			{
				battery.drain(1);
			}
		}
	}

	@Override
	public void recharge(int minutes) {
		for(int i=0;i<minutes;i++)
		{
			if(!battery.isFullyCharged())
			{
				battery.recharge(1);	
			}
			else
			{
				batteryPackCharge += 2;
				batteryPackCharge = Math.min(batteryPackCapacity, batteryPackCharge);
			}
		}
	}

}
