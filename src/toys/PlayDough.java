package toys;

public class PlayDough extends Toy {
    private final Color color;
    private static int productCodeCounter = 100;
    private static final double WEAR_MULTIPLIER = 0.05;

    /**
     * Constructs a PlayDough object with the specified name and color.
     *
     * @param name  the name of the PlayDough
     * @param color the color of the PlayDough
     */
    public PlayDough(String name, Color color) {
        super(generateProductCode(), name);
        this.color = color;
    }

    /**
     * Returns the color of the PlayDough.
     *
     * @return the color of the PlayDough
     */
    public Color getColor() {
        return color;
    }

    /**
     * Performs a special play action with the PlayDough.
     * Prints a message indicating arts and crafting with the PlayDough's color and name.
     */
    public void specialPlay() {
        System.out.println("\tArts and crafting with " + color + " " + getName());
    }

    /**
     * Performs a special play action with the PlayDough for the specified time.
     * Calls the specialPlay() method and increase the wear of the PlayDough based on the time and wear multiplier.
     *
     * @param time the duration of the special play action
     */
    public void specialPlay(int time) {
        specialPlay();
        increaseWear(WEAR_MULTIPLIER * time);
    }

    /**
     * Returns a string representation of the PlayDough object.
     *
     * @return a string representation of the PlayDough object
     */
    @Override
    public String toString() {
        return super.toString() + ", PlayDough{C:" + color + "}";
    }

    /**
     * Generates a unique product code for the PlayDough.
     *
     * @return the generated product code
     */
    private static int generateProductCode() {
        int productCode = productCodeCounter;
        productCodeCounter++;
        return productCode;
    }
}
