package ru.cft.shift.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class FileWriter implements IWriter {
    private static final Logger log = LoggerFactory.getLogger(FileWriter.class);
    private java.io.FileWriter fileWriter;
    final String outputFileName = "FigureCharacteristic_result.txt";

    @Override
    public void WriteLine(String line){
        try {
            if (fileWriter == null) {
                fileWriter = new java.io.FileWriter(outputFileName);
            }
            fileWriter.write(line);
        } catch (IOException e) {
            log.error("Have some problem, when write result to file", e);
        }
    }

    @Override
    public void FinishWrite() {
        try {
            if (fileWriter != null){
                fileWriter.close();
                fileWriter = null;
            }
        } catch (IOException e) {
            log.error("Have some problem, when close the file", e);
        }
    }
}
