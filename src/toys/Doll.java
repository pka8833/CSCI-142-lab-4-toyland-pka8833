package toys;

public class Doll extends Toy {
    private static int nextProductCode = 200;
    private final Color hairColor;
    private final int age;
    private final String speak;

    /**
     * Constructs a Doll object with the specified name, hair color, age, and speech.
     *
     * @param name      the name of the doll
     * @param hairColor the hair color of the doll
     * @param age       the age of the doll
     * @param speak     the speech of the doll
     */
    public Doll(String name, Color hairColor, int age, String speak) {
        super(nextProductCode++, name);
        this.hairColor = hairColor;
        this.age = age;
        this.speak = speak;
    }

    /**
     * Returns the hair color of the doll.
     *
     * @return the hair color of the doll
     */
    public Color getHairColor() {
        return hairColor;
    }

    /**
     * Returns the age of the doll.
     *
     * @return the age of the doll
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the speech of the doll.
     *
     * @return the speech of the doll
     */
    public String getSpeak() {
        return speak;
    }

    /**
     * Performs a special play action by the doll for the specified time.
     * Prints a message indicating the action and increases the wear of the doll based on its age.
     *
     * @param time the duration of the special play action
     */
    @Override
    public void specialPlay(int time) {
        System.out.println("\t" + getName() + " brushes their " + hairColor + " hair and says, \"" + speak + "\"");
        increaseWear(age);
    }

    /**
     * Returns a string representation of the Doll object.
     *
     * @return a string representation of the Doll object
     */
    @Override
    public String toString() {
        return super.toString() + ", Doll{HC:" + hairColor + ", A:" + age + ", S:" + speak + "}";
    }
}
