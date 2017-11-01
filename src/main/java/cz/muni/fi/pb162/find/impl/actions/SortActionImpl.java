package cz.muni.fi.pb162.find.impl.actions;

import cz.muni.fi.pb162.find.ApplicationOptions;
import cz.muni.fi.pb162.find.actions.SortAction;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.impl.comparators.FileExtensionComparator;
import cz.muni.fi.pb162.find.impl.comparators.FileNameComparator;
import cz.muni.fi.pb162.find.impl.comparators.FilePathComparator;
import cz.muni.fi.pb162.find.impl.comparators.FileSizeComparator;

import java.util.List;

/**
 * Class for sorting entries by given order
 * @author xkacmar (445721)
 * @version 1.0
 */
public class SortActionImpl implements SortAction {

    private ApplicationOptions options;

    /**
     * Save application options
     * @param options - application options
     */
    public SortActionImpl(ApplicationOptions options){
        if(options == null){
            throw new IllegalArgumentException("ApplicationOptions cannot be null.");
        }
        this.options = options;
    }

    // https://en.wikipedia.org/wiki/Sorting_algorithm#Stability
    @Override
    public List<SearchEntry> sorted(List<SearchEntry> entries) {
        for (int i = options.getSort().length() - 1; i >= 0; i--){
            switch (options.getSort().charAt(i)){
                case 'f': //sort by path
                    entries.sort(new FilePathComparator());
                    break;
                case 's': //sort by size
                    entries.sort(new FileSizeComparator(null));
                    break;
                case 'e': //sort by extension
                    entries.sort(new FileExtensionComparator(null));
                    break;
                case 'n': //sort by filename
                    entries.sort(new FileNameComparator(null));
                    break;
                default:
                    System.out.println("Wrong argument.");
                    break;
            }
        }
        return entries;
    }
}
