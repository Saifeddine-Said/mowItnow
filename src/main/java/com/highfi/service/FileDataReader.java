package com.highfi.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader {


    /**
     * get data from file
     *
     * @param fileUrl
     * @return list of lines
     */
    public static List<String> parseDataFile(String fileUrl) {

        List<String> lines = new ArrayList<>();
        Path path = Paths.get(fileUrl);

        if (path != null && path.toFile().isFile()) {
            try {
                lines = Files.readAllLines(path, Charset.defaultCharset());
            } catch (IOException e) {
                //TODO TO BE REPLACED BY LOGGER
                System.err.println("An error occurred while parsing file data");

            }
        }
        return lines;
    }
}
