package toys;

public class Robot extends BatteryPowered {
    private static int productCodeCounter = 400; // Starting product code for Robot
    private static final int INITIAL_SPEED = 0;
    private static final int FLY_SPEED = 25;
    private static final int RUN_SPEED = 10;

    private final boolean flying;
    private int distance;

    /**
     * Constructs a Robot object with the specified name, number of batteries, and flying capability.
     *
     * @param name         the name of the Robot
     * @param numBatteries the number of batteries required for the Robot
     * @param flying       indicates whether the Robot is capable of flying
     */
    public Robot(String name, int numBatteries, boolean flying) {
        super(generateProductCode(), name, numBatteries);
        this.flying = flying;
        this.distance = INITIAL_SPEED;
    }

    /**
     * Generates a unique product code for the Robot starting from 400.
     *
     * @return the generated product code
     */
    private static int generateProductCode() {
        return productCodeCounter++;
    }

    /**
     * Returns a boolean value indicating whether the Robot is capable of flying.
     *
     * @return true if the Robot can fly, false otherwise
     */
    public boolean isFlying() {
        return flying;
    }

    /**
     * Returns the distance traveled by the Robot.
     *
     * @return the distance traveled by the Robot
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Performs a special play action with the Robot for the specified time.
     * If the Robot is flying, it increases the distance traveled and prints a message indicating flying.
     * If the Robot is not flying, it increases the distance traveled and prints a message indicating running.
     * Uses batteries for the specified time and increases wear.
     *
     * @param time the duration of the special play action
     */
    @Override
    public void specialPlay(int time) {
        if (flying) {
            int distanceIncrease = time * FLY_SPEED;
            distance += distanceIncrease;
            System.out.println("\t" + getName() + " is flying around with total distance: " + distance);
            increaseWear(FLY_SPEED);
        } else {
            int distanceIncrease = time * RUN_SPEED;
            distance += distanceIncrease;
            System.out.println("\t" + getName() + " is running around with total distance: " + distance);
            increaseWear(RUN_SPEED);
        }

        useBatteries(time);
    }

    /**
     * Returns a string representation of the Robot object.
     *
     * @return a string representation of the Robot object
     */
    @Override
    public String toString() {
        return super.toString() + ", Robot{F:" + flying + ", D:" + distance + "}";
    }
}
