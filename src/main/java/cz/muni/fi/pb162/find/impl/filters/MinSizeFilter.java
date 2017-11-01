package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;

/**
 * Class for filtering files below required size
 * @author xkacmar (445721)
 * @version 1.0
 */
public class MinSizeFilter extends BasicFilter {

    private long minSize;

    /**
     * Filter files below minimum size
     * @param entry - List of entries
     * @param minSize - minimum size
     */
    public MinSizeFilter(List<SearchEntry> entry, long minSize){
        super(entry);
        if(minSize >= 0) {
            this.minSize = minSize;
        }
    }

    @Override
    public boolean filter(SearchEntry path) {
        return path != null && path.getSize() >= minSize;
    }
}
