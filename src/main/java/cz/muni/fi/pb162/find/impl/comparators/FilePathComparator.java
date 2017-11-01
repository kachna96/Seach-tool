package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * Class for comparing two objects based on their path
 * @author xkacmar (445721)
 * @version 1.0
 */
public class FilePathComparator implements BasicComparator {

    @Override
    public BasicComparator getNextComparator() {
        return null;
    }

    @Override
    public int compare(SearchEntry o1, SearchEntry o2) {
        if(o1 == null || o2 == null){
            return (o1 == null) ? -1 : 1;
        }
        return o1.getPath().compareTo(o2.getPath());
    }
}
