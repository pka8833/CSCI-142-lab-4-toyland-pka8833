package toys;

public class ActionFigure extends Doll {
    private static final Color HAIR_COLOR = Color.ORANGE;
    private static final int MIN_ENERGY_LEVEL = 1;

    private int energyLevel;

    /**
     * Constructs an ActionFigure object with the specified name, age, and speech.
     *
     * @param name  the name of the action figure
     * @param age   the age of the action figure
     * @param speak the speech of the action figure
     */
    public ActionFigure(String name, int age, String speak) {
        super(name, HAIR_COLOR, age, speak);
        this.energyLevel = MIN_ENERGY_LEVEL;
    }

    /**
     * Returns the energy level of the action figure.
     *
     * @return the energy level of the action figure
     */
    public int getEnergyLevel() {
        return energyLevel;
    }

    /**
     * Performs a special play action by the action figure for the specified time.
     * Increases the energy level and invokes the special method of the superclass.
     *
     * @param time the duration of the special play action
     */
    public void specialPlay(int time) {
        System.out.println("\t" + getName() + " kung foo chops with " + (energyLevel * time) + " energy!");
        energyLevel++;
        super.specialPlay(time);
    }

    /**
     * Returns a string representation of the ActionFigure object.
     *
     * @return a string representation of the ActionFigure object
     */
    @Override
    public String toString() {
        return super.toString() + ", " + getClass().getSimpleName() + "{E:" + getEnergyLevel() + "}";
    }
}
