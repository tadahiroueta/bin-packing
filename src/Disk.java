import java.util.ArrayList;

public class Disk implements Comparable<Disk> {
    private static final int SIZE = 1000000;
    private static int latestId = 0;

    private ArrayList<Integer> data = new ArrayList<Integer>();
    private int availableStorage = SIZE;
    private int id = latestId++;

    public Disk(int input) {add(input);}

    public void add(int value) { 
        data.add(value);
        availableStorage -= value;
    }

    public void remove(Integer value) { 
        data.remove(value);
        availableStorage += value; 
    }
    
    public ArrayList<Integer> getData() { return data; }

    public int getAvailableStorage() { return availableStorage; }

    public int compareTo(Disk other) {
        return other.availableStorage - availableStorage;
    }

    @Override
    public String toString() {
        String output = new String(id + " " + availableStorage + ": " );
        for (int value : data) output += value + " ";
        return output.trim();
    }
}