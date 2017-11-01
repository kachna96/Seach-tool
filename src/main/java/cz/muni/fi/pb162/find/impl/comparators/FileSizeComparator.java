package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * Class for comparing two SearchEntry object based on their size
 * @author xkacmar (445721)
 * @version 1.0
 */
public class FileSizeComparator implements BasicComparator {

    private BasicComparator nextComparator;

    /**
     * Use next comparator if necessary
     * @param nextComparator - next comparator
     */
    public FileSizeComparator(BasicComparator nextComparator){
        this.nextComparator = nextComparator;
    }

    @Override
    public BasicComparator getNextComparator() {
        return nextComparator;
    }

    @Override
    public int compare(SearchEntry o1, SearchEntry o2) {
        if(o1 == null || o2 == null){
            return (o1 == null) ? -1 : 1;
        }
        if(o1.getSize() < o2.getSize()){
            return -1;
        }
        if(o1.getSize() > o2.getSize()){
            return 1;
        }
        return 0;
    }
}
