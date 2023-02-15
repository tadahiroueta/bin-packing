import java.util.Collections;

public class WorstFitDecreasing extends WorstFit {
    public WorstFitDecreasing(String filename) {
        super(filename);
    }

    @Override
    protected void solve() {
        Collections.sort(input, Collections.reverseOrder());
        super.solve();
    }
}
