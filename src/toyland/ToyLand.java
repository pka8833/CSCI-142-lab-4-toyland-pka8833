package toyland;

import toys.IToy;
import toys.ToyFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The main program is run on the command line with a toy file:
 * <p>
 * $ java ToyLand filename
 * <p>
 * 1. The toys are read into the file into a list of active toys.
 * 2. The toys are played with a random amount of time.  While
 *       active, each one gets put on the back of the active toy list.
 *      When they retire after reaching maximum happiness, they
 *      move to a list of retired toys.
 * 3. Some statistics are displayed about the running of the simulation
 *      and the toys that were played with.
 *
 * @author RIT CS
 * @author PHILLIP ATTEA
 */
public class ToyLand {
    /** Seed the random number generator for generating random minutes of play time */
    private final static int RANDOM_SEED = 42;
    /** The minimum amount of time a toy is played with in a single play time */
    private final static int MIN_TIME = 20;
    /** The maximum amount of time a toy is played with in a single play time */
    private final static int MAX_TIME = 50;

    /** The active toys */
    private final ArrayList<IToy> activeToys;
    /** The retired toys */
    private final ArrayList<IToy> retiredToys;

    /** The seeded random number generator */
    private static final Random rng = new Random(RANDOM_SEED);

    /** Generate the next random time in the range MIN_TIME to MAX_TIME */
    public static int getRandomTime() {
        return rng.nextInt(MAX_TIME - MIN_TIME) + MIN_TIME;
    }

    /**
     * Read the toys in from filename and store in the active toy list.
     *
     * @param filename the toy filename
     */
    public ToyLand(String filename) {
        this.activeToys = new ArrayList<>();
        this.retiredToys = new ArrayList<>();
        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNextLine()) {
                // the specific kind of toys is created in the factory
                this.activeToys.add(ToyFactory.makeToy(in.nextLine()));
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error opening toy file: " + filename);
        } // <3 Jim
    }

    /**
     * Play with the toys until they are all retired.
     * <p>
     * 1. Remove the toy from the front of the active toys
     * 2. Generate the next random time and play the toy for that amount
     * 3. If the toy is not retired, add it to the back of the active toy list,
     *    otherwise add it to the back of the retired toys
     */
    public void playTime() {
        while (!activeToys.isEmpty()) {
            IToy toy = activeToys.remove(0);
            int playTime = getRandomTime();
            toy.play(playTime);
            if (!toy.isRetired()) {
                activeToys.add(toy);
            } else {
                retiredToys.add(toy);
            }
        }
    }

    /**
     * Generate the following statistics about the simulation that was just run.
     * <p>
     * For each retired toy, print the final happiness and wear of the toy.
     * Print the total number of toys
     * Print the total happiness of all toys
     * Print the average wear of all toys
     */
    public void displayStatistics() {
        System.out.println("Retired toys:");
        for (IToy toy : retiredToys) {
            System.out.println("Toy happiness: " + toy.getHappiness() + ", Toy wear: " + toy.getWear());
        }

        int totalToys = activeToys.size() + retiredToys.size();
        System.out.println("Total number of toys: " + totalToys);

        int totalHappiness = 0;
        double totalWear = 0;
        for (IToy toy : activeToys) {
            totalHappiness += toy.getHappiness();
            totalWear += toy.getWear();
        }
        for (IToy toy : retiredToys) {
            totalHappiness += toy.getHappiness();
            totalWear += toy.getWear();
        }
        double averageWear = totalWear / totalToys;

        System.out.println("Total happiness of all toys: " + totalHappiness);
        System.out.println("Average wear of all toys: " + averageWear);
    }

    /**
     * The main program requires the toy data file be provided.  It then
     * loads the toys, plays with them, and displays some final statistics.
     *
     * @param args command line arguments (the filename)
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ToyLand toy-file");
        } else {
            ToyLand toyLand = new ToyLand(args[0]);
            toyLand.playTime();
            toyLand.displayStatistics();
        }
    }
}
