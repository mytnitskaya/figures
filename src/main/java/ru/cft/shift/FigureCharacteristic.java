package ru.cft.shift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cft.shift.helper.FigureFileReader;
import ru.cft.shift.model.*;
import ru.cft.shift.writer.ConsoleWriter;
import ru.cft.shift.writer.FileWriter;
import ru.cft.shift.writer.IWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FigureCharacteristic {
    private static final Logger log = LoggerFactory.getLogger(FigureCharacteristic.class);
    final String outputFile = "-f";
    final String outputConsole = "-c";

    private boolean isConsoleOutput = false;
    private boolean isFileOutput = false;
    private String fileName;

    public FigureCharacteristic(String[] args) {
        ParseArg(args);
    }

    public void Run() {
        try {
            Map.Entry<FigureType, List<Double>> out = new FigureFileReader().ReadFigureFile(fileName);
            FigureBase figure = GetFigureObject(out.getKey(), out.getValue());
            ArrayList<IWriter> writers = GetWriter();
            figure.WriteResult(writers);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void ParseArg(String[] args) {
        final String fileExtension = ".txt";

        for (String arg : args) {
            if (arg.equals(outputConsole)) {
                isConsoleOutput = true;
                continue;
            }
            if (arg.equals(outputFile)) {
                isFileOutput = true;
                continue;
            }
            if (arg.endsWith(fileExtension)) {
                fileName = arg;
            }
        }
    }

    private FigureBase GetFigureObject(FigureType type, List<Double> params) throws Exception {
        return switch (type) {
                    case CIRCLE -> new Circle(params);
                    case RECTANGLE -> new Rectangle(params);
                    case TRIANGLE -> new Triangle(params);
                    default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    private ArrayList<IWriter> GetWriter() {
        ArrayList<IWriter> writers = new ArrayList<>();
        if (isConsoleOutput) {
            writers.add(new ConsoleWriter());
        }
        if (isFileOutput) {
            writers.add(new FileWriter());
        }
        return writers;
    }

}
