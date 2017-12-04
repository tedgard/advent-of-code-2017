package utils;


import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class PuzzleInputReader {

    public List<String> readInputForPuzzle(String filename) {

        Path path;
        try {
            path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        } catch (Exception e) {
            log.error("Error while trying to open the file {}", filename, e);
            return null;
        }

        List<String> fileContent = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(path);
            lines.forEach(fileContent::add);
            lines.close();
        } catch (Exception e) {
            log.error("Error while reading the file {} ", filename, e);
        }

        log.info("Content size of {} : {} lines ", filename, fileContent.size());
        return fileContent;
    }
}
