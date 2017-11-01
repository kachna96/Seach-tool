package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;

/**
 * Class for filtering files by their filename
 * @author xkacmar (445721)
 * @version 1.0
 */
public class FileNameFilter extends BasicFilter {

    private String regex;

    /**
     * Filter entries by file name
     * @param entry - list of entries
     * @param regex - desired file name
     */
    public FileNameFilter(List<SearchEntry> entry, String regex){
        super(entry);
        if(regex != null){
            this.regex = regex;
        }
    }

    @Override
    public boolean filter(SearchEntry path) {
        return path != null && path.getFileName().toString().matches(regex);
    }
}
