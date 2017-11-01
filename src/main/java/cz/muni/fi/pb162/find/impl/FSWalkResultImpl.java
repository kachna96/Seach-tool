package cz.muni.fi.pb162.find.impl;

import cz.muni.fi.pb162.find.ApplicationOptions;
import cz.muni.fi.pb162.find.filesystem.FSWalkResult;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Class for handling file traversing
 * @author xkacmar (445721)
 * @version 1.0
 */
public class FSWalkResultImpl extends FSWalkResult {

    private List<SearchEntry> dirList = new ArrayList<>();
    private List<SearchEntry> fileList = new ArrayList<>();

    /**
     * Send Application Options to parent
     * @param options - options
     */
    public FSWalkResultImpl(ApplicationOptions options){
        super(options);
    }

    @Override
    public List<SearchEntry> getDirectories() {
        return Collections.unmodifiableList(dirList);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc)
            throws IOException {
        Objects.requireNonNull(dir);
        if (exc != null) {
            throw exc;
        }
        SearchEntry entry = new SearchEntry() {
            @Override
            public Types getType() {
                return Types.DIR;
            }
        };
        entry.setPath(dir);
        entry.setSize(Files.walk(dir).mapToLong( p -> p.toFile().length() ).sum());
        dirList.add(entry);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public List<SearchEntry> getFiles() {
        return Collections.unmodifiableList(fileList);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        Objects.requireNonNull(file);
        Objects.requireNonNull(attrs);
        SearchEntry entry = new SearchEntry() {
            @Override
            public Types getType() {
                return Types.FILE;
            }
        };
        entry.setPath(file);
        entry.setSize(Files.size(file));
        fileList.add(entry);
        return FileVisitResult.CONTINUE;
    }
}
