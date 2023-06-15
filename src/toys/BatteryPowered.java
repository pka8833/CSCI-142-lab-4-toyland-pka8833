package toys;

public abstract class BatteryPowered extends Toy {
    private static final int FULLY_CHARGED = 100;
    private static final int DEPLETED = 0;

    private int batteryLevel;
    private final int numBatteries;

    /**
     * Constructs a BatteryPowered object with the specified product code, name, and number of batteries.
     *
     * @param productCode  the product code of the battery-powered toy
     * @param name         the name of the battery-powered toy
     * @param numBatteries the number of batteries required for the toy
     */
    public BatteryPowered(int productCode, String name, int numBatteries) {
        super(productCode, name);
        this.batteryLevel = FULLY_CHARGED;
        this.numBatteries = numBatteries;
    }

    /**
     * Returns the current battery level of the battery-powered toy.
     *
     * @return the battery level of the battery-powered toy
     */
    public int getBatteryLevel() {
        return batteryLevel;
    }

    /**
     * Returns the number of batteries required for the battery-powered toy.
     *
     * @return the number of batteries required for the toy
     */
    public int getNumBatteries() {
        return numBatteries;
    }

    /**
     * Uses the batteries of the toy for the specified time.
     * Decreases the battery level based on the usage and checks if the battery is depleted.
     * If depleted, recharge the batteries.
     *
     * @param time the duration of battery usage
     */
    public void useBatteries(int time) {
        int totalBatteryUsage = time + numBatteries;
        batteryLevel -= totalBatteryUsage;

        if (batteryLevel <= DEPLETED) {
            batteryLevel = DEPLETED;
            System.out.println("\tDEPLETED:" + this);
            recharge();
        }
    }

    /**
     * Recharges the batteries of the battery-powered toy to the full capacity.
     */
    private void recharge() {
        batteryLevel = FULLY_CHARGED;
        System.out.println("\tRECHARGED:" + this);
    }

    /**
     * Returns a string representation of the BatteryPowered object.
     *
     * @return a string representation of the BatteryPowered object
     */
    @Override
    public String toString() {
        return super.toString() + ", BatteryPowered{BL:" + batteryLevel + ", NB:" + numBatteries + "}";
    }
}
