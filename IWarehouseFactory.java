public interface IWarehouseFactory
{
	// Robots and batteries
	public IBattery makeBattery(int capacity);
	public IRobot makeRobot(int batteryCapacity);
	public IRobot makeRobotWithBatteryPack(int batteryCapacity, int packCapacity);
	// States
	// .. You must complete the interface with methods to instantiate your state objects.
	
	public IdleState makeIdealState();
	public ClaimItemState makeClaimItemState();
	public FinishedState makeFinishedState();
	public TakeItemState makeTakeItemState();
	public MoveToShelfState makeMoveToShelfState();
	public MoveToTruckState makeMoveToTruckState();
	public LoadTruckState makeLoadTruckState();
	RechargeState makeRechargeState(State previousState,IBattery battery);
}
