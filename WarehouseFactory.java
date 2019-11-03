
public class WarehouseFactory implements IWarehouseFactory
{
	@Override
	public IBattery makeBattery(int capacity)
	{
		return new Battery(capacity);
	}

	@Override
	public IRobot makeRobot(int batteryCapacity)
	{
		IBattery battery = makeBattery(batteryCapacity);
		// TODO: Robots start in the IdleState, instantiate that here.
		State startState = makeIdealState();
		return new Robot(battery, startState);
	}
	
	public IRobot makeRobotWithBatteryPack(int batteryCapacity, int packCapacity)
	{
		IBattery battery = makeBattery(batteryCapacity);
		IBattery batteryWithBatteryPack = new BatteryWithBatteryPack((Battery) battery, packCapacity);
		State startState = makeIdealState();
		// TODO: Implement the Decorator pattern, and use it to decorate a regular
		//       battery with a battery pack, and create a robot with the battery pack.
		return new Robot(batteryWithBatteryPack,startState);
	}

	@Override
	public IdleState makeIdealState() {
		return new IdleState();
	}

	@Override
	public ClaimItemState makeClaimItemState() {
		return new ClaimItemState();
	}

	@Override
	public FinishedState makeFinishedState() {
		return new FinishedState();
	}

	@Override
	public TakeItemState makeTakeItemState() {
		return new TakeItemState();
	}

	@Override
	public MoveToShelfState makeMoveToShelfState() {
		return new MoveToShelfState();
	}

	@Override
	public MoveToTruckState makeMoveToTruckState() {
		return new MoveToTruckState();
	}

	@Override
	public LoadTruckState makeLoadTruckState() {
		return new LoadTruckState();
	}

	@Override
	public RechargeState makeRechargeState(State previousState,IBattery battery) {
		return new RechargeState(previousState,battery);
	}


}
