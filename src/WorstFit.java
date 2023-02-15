import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;

public class WorstFit {
    protected ArrayList<Integer> input = new ArrayList<Integer>();
    protected ArrayList<Disk> disks = new ArrayList<Disk>();
    protected int total = 0;

    public WorstFit(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextInt()) input.add(scanner.nextInt());
            scanner.close();

            solve();
        } 
        catch (FileNotFoundException e) { System.out.println("File not found: " + filename); }
    }

    protected void solve() {
        for (int i : input) store(i);

        System.out.println(this);
    }

    protected void store(int input) {
        total += input;

        // try to put into disk
        for (Disk disk : disks) {
            if (disk.getAvailableStorage() >= input) {
                disk.add(input);
                Collections.sort(disks);
                return;
        }}

        // put in new disk
        disks.add(new Disk(input));
        Collections.sort(disks);
    }

    public String toString() {
        String output = new String(
            "Total size = " + total / 10000000.0 + " GB\n" +
            "Number of disks = " + disks.size() + "\n"
        );
        if (input.size() >= 100) return output.toString();

        for (Disk disk : disks) output += disk + "\n";

        return output;
}}