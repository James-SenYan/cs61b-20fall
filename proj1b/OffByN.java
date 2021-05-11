/**
 * @author Sen Yan
 * @create 2021-04-18-20:20
 */
public class OffByN implements CharacterComparator {
    private int diff;
    public OffByN(int N) {
        this.diff = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == diff;
    }
}
