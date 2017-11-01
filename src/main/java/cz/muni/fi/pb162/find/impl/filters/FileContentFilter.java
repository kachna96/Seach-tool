package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * Class for filtering files by their content
 * @author xkacmar (445721)
 * @version 1.0
 */
public class FileContentFilter extends BasicFilter {

    private String regex;

    /**
     * Filter entries by content of each file
     * @param entry - list of entries
     * @param regex - desired content
     */
    public FileContentFilter(List<SearchEntry> entry, String regex){
        super(entry);
        if(regex != null){
            this.regex = regex;
        }
    }

    @Override
    public boolean filter(SearchEntry path) {
        if(path == null){
            return false;
        }
        try{
            String content = new String(Files.readAllBytes(path.getPath()));
            return content.matches(regex);
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
