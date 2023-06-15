package toys;

public class RCCar extends BatteryPowered {
    private static int productCodeCounter = 300; // Starting product code for RCCar
    private static final int STARTING_SPEED = 10;
    private static final int SPEED_INCREASE = 5;

    private int speed;

    /**
     * Constructs an RCCar object with the specified name and number of batteries.
     *
     * @param name         the name of the RCCar
     * @param numBatteries the number of batteries required for the RCCar
     */
    public RCCar(String name, int numBatteries) {
        super(generateProductCode(), name, numBatteries);
        this.speed = STARTING_SPEED;
    }

    /**
     * Generates a unique product code for the RCCar starting from 300.
     *
     * @return the generated product code
     */
    private static int generateProductCode() {
        return productCodeCounter++;
    }

    /**
     * Returns the speed of the RCCar.
     *
     * @return the speed of the RCCar
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Performs a special play action with the RCCar for the specified time.
     * Prints a message indicating the RCCar racing at its current speed.
     * Uses batteries, increases wear, and increases the speed of the RCCar.
     *
     * @param time the duration of the special play action
     */
    @Override
    public void specialPlay(int time) {
        System.out.print("\t" + getName() + " races around at " + speed + "mph!\n");
        useBatteries(time);
        increaseWear(speed);
        speed += SPEED_INCREASE;
    }

    /**
     * Returns a string representation of the RCCar object.
     *
     * @return a string representation of the RCCar object
     */
    @Override
    public String toString() {
        return super.toString() + ", RCCar{S:" + speed + "}";
    }
}
