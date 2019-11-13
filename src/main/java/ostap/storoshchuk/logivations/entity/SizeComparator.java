package ostap.storoshchuk.logivations.entity;

import java.util.Comparator;

public class SizeComparator implements Comparator<Case> {
    @Override
    public int compare(Case o1, Case o2) {
        return (int) (o1.volume() - o2.volume());
    }
}
