package toys;

public abstract class Toy implements IToy {
    private static final int INITIAL_HAPPINESS = 0;
    private static final int MAX_HAPPINESS = 100;
    private static final double INITIAL_WEAR = 0.0;

    private final int productCode;
    private final String name;
    private int happiness;
    private boolean retired;
    private double wear;

    /**
     * Constructs a Toy object with the specified product code and name.
     *
     * @param productCode the product code of the Toy
     * @param name        the name of the Toy
     */
    public Toy(int productCode, String name) {
        this.productCode = productCode;
        this.name = name;
        this.happiness = INITIAL_HAPPINESS;
        this.retired = false;
        this.wear = INITIAL_WEAR;
    }

    /**
     * Returns the product code of the Toy.
     *
     * @return the product code of the Toy
     */
    public int getProductCode() {
        return productCode;
    }

    /**
     * Returns the name of the Toy.
     *
     * @return the name of the Toy
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the happiness level of the Toy.
     *
     * @return the happiness level of the Toy
     */
    public int getHappiness() {
        return happiness;
    }

    /**
     * Returns a boolean value indicating whether the Toy is retired.
     *
     * @return true if the Toy is retired, false otherwise
     */
    public boolean isRetired() {
        return retired;
    }

    /**
     * Returns the wear level of the Toy.
     *
     * @return the wear level of the Toy
     */
    public double getWear() {
        return wear;
    }

    /**
     * Increases the wear level of the Toy by the specified amount.
     *
     * @param amount the amount to increase the wear level by
     */
    public void increaseWear(double amount) {
        wear += amount;
    }

    /**
     * Plays with the Toy for the specified time. Calls the specialPlay() method, increases happiness by time,
     * and checks if the Toy is retired.
     *
     * @param time the duration of playtime
     */
    public void play(int time) {
        System.out.println("PLAYING(" + time + "): " + this);
        specialPlay(time);
        happiness += time;

        if (happiness >= MAX_HAPPINESS) {
            retired = true;
            System.out.println("RETIRED: " + this);
        }
    }

    /**
     * Performs a special play action with the Toy for the specified time.
     *
     * @param time the duration of the special play action
     */
    public abstract void specialPlay(int time);

    /**
     * Returns a string representation of the Toy object.
     *
     * @return a string representation of the Toy object
     */
    public String toString() {
        return "Toy{PC:" + productCode + ", N:" + name + ", H:" + happiness +
                ", R:" + retired + ", W:" + wear + "}";
    }
}
