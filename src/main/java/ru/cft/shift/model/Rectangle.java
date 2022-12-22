package ru.cft.shift.model;

import java.util.List;

public class Rectangle extends FigureBase {
    private double lengthA;
    private double lengthB;

    public Rectangle(List<Double> params) throws Exception {
        super(params);
    }

    @Override
    protected void InitFigure(List<Double> params) throws Exception {
        if ((long) params.size() != 2) {
            throw new Exception("Incorrect parameters count for figure: " + GetName());
        }
        this.lengthA = params.get(0);
        this.lengthB = params.get(1);
    }

    @Override
    protected String GetName() {
        return "Rectangle";
    }

    @Override
    protected String GetArea() {
        double area = lengthA * lengthB;
        return area + " " + super.areaUnitName;
    }

    @Override
    protected String GetPerimeter() {
        double perimeter = 2.0 * (lengthA + lengthB);
        return perimeter + " " + super.unitName;
    }

    @Override
    protected String GetCustom() {
        double length = Math.max(lengthA, lengthB);
        double width = Math.min(lengthA, lengthB);
        String outputDiagonal = "Diagonal: " + GetDiagonal() + " " + super.unitName + "\n";
        String outputLength = "Length: " + length + " " + super.unitName + "\n";
        String outputWidth = "Width: " + width + " " + super.unitName + "\n";
        return outputDiagonal + outputLength + outputWidth;
    }

    private double GetDiagonal() {
        return Math.sqrt(lengthA * lengthA + lengthB * lengthB);
    }

}
