package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;

/**
 * Class for filtering files above required size
 * @author xkacmar (445721)
 * @version 1.0
 */
public class MaxSizeFilter extends BasicFilter {

    private long maxSize;

    /**
     * Filter entries above maximum size
     * @param entry - list of entries
     * @param maxSize - maximum size
     */
    public MaxSizeFilter(List<SearchEntry> entry, long maxSize){
        super(entry);
        if(maxSize >= 0){
            this.maxSize = maxSize;
        }
    }

    @Override
    public boolean filter(SearchEntry path) {
        return path != null && path.getSize() <= maxSize;
    }
}
