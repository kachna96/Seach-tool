package cz.muni.fi.pb162.find.impl.actions;

import cz.muni.fi.pb162.find.ApplicationOptions;
import cz.muni.fi.pb162.find.actions.FilterAction;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.impl.filters.FileContentFilter;
import cz.muni.fi.pb162.find.impl.filters.FileNameFilter;
import cz.muni.fi.pb162.find.impl.filters.MaxSizeFilter;
import cz.muni.fi.pb162.find.impl.filters.MinSizeFilter;
import java.util.List;

/**
 * Class for filtering entries based by given application options
 * @author xkacmar (445721)
 * @version 1.0
 */
public class FilterActionImpl implements FilterAction {

    private ApplicationOptions options;

    /**
     * Save application options
     * @param options - application options
     */
    public FilterActionImpl(ApplicationOptions options){
        if(options == null){
            throw new IllegalArgumentException("ApplicationOptions cannot be null.");
        }
        this.options = options;
    }

    @Override
    public List<SearchEntry> filter(List<SearchEntry> entries) {
        if(options.getNameRegex() != null){
            FileNameFilter fileNameFilter = new FileNameFilter(entries, options.getNameRegex());
            entries.retainAll(fileNameFilter.filtered());
        }
        if(options.getTextRegex() != null){
            FileContentFilter fileContentFilter = new FileContentFilter(entries, options.getTextRegex());
            entries.retainAll(fileContentFilter.filtered());
        }
        if(options.getSizeMax() != null){
            MaxSizeFilter maxSizeFilter = new MaxSizeFilter(entries, options.getSizeMax());
            entries.retainAll(maxSizeFilter.filtered());
        }
        if(options.getSizeMin() != null){
            MinSizeFilter minSizeFilter = new MinSizeFilter(entries, options.getSizeMin());
            entries.retainAll(minSizeFilter.filtered());
        }
        return entries;
    }
}
