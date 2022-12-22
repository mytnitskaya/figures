package ru.cft.shift.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cft.shift.model.FigureType;

import java.io.File;
import java.util.*;

public class FigureFileReader {

    private static final Logger log = LoggerFactory.getLogger(FigureFileReader.class);

    public AbstractMap.SimpleEntry<FigureType, List<Double>> ReadFigureFile(String fileName)
            throws Exception {
        File myObj = new File(fileName);
        Scanner scanner = new Scanner(myObj);
        if (!scanner.hasNext()) {
            log.error("No first line (with figure type) in file");
            throw new NoSuchElementException();
        }
        String firstLine = scanner.nextLine();
        var figureType = GetFigureType(firstLine);
        if (!scanner.hasNext()) {
            log.error("No second line (with figure parameters) in file");
            throw new NoSuchElementException();
        }
        String parametersLine = scanner.nextLine();
        List<Double> parameters = GetParamsArray(parametersLine);

        scanner.close();
        return new AbstractMap.SimpleEntry<>(figureType, parameters);
    }

    private FigureType GetFigureType(String type) throws Exception {
        return switch (type) {
            case "CIRCLE" -> FigureType.CIRCLE;
            case "RECTANGLE" -> FigureType.RECTANGLE;
            case "TRIANGLE" -> FigureType.TRIANGLE;
            default -> throw new Exception("Wrong figure name");
        };
    }

    private List<Double> GetParamsArray(String line) {
        String[] splitLine = line.split("\\s+");
        List<Double> parameters = new ArrayList<>();
        for (String element : splitLine) {
            try {
                parameters.add(Double.parseDouble(element));
            } catch (Exception e) {
                log.error("Wrong format of figure parameter", e);
            }
        }
        return parameters;
    }
}
