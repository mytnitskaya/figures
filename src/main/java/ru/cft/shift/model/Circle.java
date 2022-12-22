package ru.cft.shift.model;

import java.util.List;

public class Circle extends FigureBase {
    private double radius;

    public Circle(List<Double> params) throws Exception {
        super(params);
    }

    @Override
    protected void InitFigure(List<Double> params) throws Exception {
        if ((long) params.size() != 1) {
            throw new Exception("Incorrect parameters count for figure: " + GetName());
        }
        this.radius = params.get(0);
    }

    @Override
    protected String GetName() {
        return "Circle";
    }

    @Override
    protected String GetArea() {
        double area = Math.PI * radius * radius;
        return area + " " + super.areaUnitName;
    }

    @Override
    protected String GetPerimeter() {
        double perimeter = 2 * Math.PI * radius;
        return perimeter + " " + super.unitName;
    }

    @Override
    protected String GetCustom() {
        String outputRadius = "Radius: " + " " + radius + " " + super.unitName + "\n";
        String outputDiameter = "Diameter: " + " " + GetDiameter() + " " + super.unitName + "\n";
        return outputRadius + outputDiameter;
    }

    private double GetDiameter() {
        return 2 * radius;
    }
}
