package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * Class for comparing two objects based on their extension
 * @author xkacmar (445721)
 * @version 1.0
 */
public class FileExtensionComparator implements BasicComparator {

    private BasicComparator nextComparator;

    /**
     * Use next comparator if necessary
     * @param nextComparator - next comparator
     */
    public FileExtensionComparator(BasicComparator nextComparator){
        this.nextComparator = nextComparator;
    }

    @Override
    public BasicComparator getNextComparator() {
        return nextComparator ;
    }

    @Override
    public int compare(SearchEntry o1, SearchEntry o2) {
        if(o1 == null || o2 == null){
            return (o1 == null) ? -1 : 1;
        }
        String s1 = o1.getFileName().toString();
        String s2 = o2.getFileName().toString();
        final int s1Dot = s1.lastIndexOf('.');
        final int s2Dot = s2.lastIndexOf('.');
        if ((s1Dot == -1) == (s2Dot == -1)) {
            s1 = s1.substring(s1Dot + 1);
            s2 = s2.substring(s2Dot + 1);
            return s1.compareTo(s2);
        } else if (s1Dot == -1) {
            return -1;
        } else {
            return 1;
        }
    }
}
