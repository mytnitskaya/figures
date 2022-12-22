package ru.cft.shift.model;

import java.util.List;

public class Triangle extends FigureBase {
    private double lengthA;
    private double lengthB;
    private double lengthC;

    public Triangle(List<Double> params) throws Exception {
        super(params);
    }

    @Override
    protected void InitFigure(List<Double> params) throws Exception {
        if ((long) params.size() != 3) {
            throw new Exception("Incorrect parameters count for figure: " + GetName());
        }
        this.lengthA = params.get(0);
        this.lengthB = params.get(1);
        this.lengthC = params.get(2);
    }

    @Override
    protected String GetName() {
        return "Triangle";
    }

    @Override
    protected String GetArea() {
        double halfPerimeter = (lengthA + lengthB + lengthC) / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - lengthA) * (halfPerimeter - lengthB) * (halfPerimeter - lengthC));
        return area + " " + super.areaUnitName;
    }

    @Override
    protected String GetPerimeter() {
        double perimeter = lengthA + lengthB + lengthC;
        return perimeter + " " + super.unitName;
    }

    @Override
    protected String GetCustom() {
        double angleA = Math.toDegrees(GetAngle(lengthA, lengthB, lengthC));
        double angleB = Math.toDegrees(GetAngle(lengthB, lengthA, lengthC));
        double angleC = Math.toDegrees(GetAngle(lengthC, lengthA, lengthB));
        String degreeUnitName = "degrees";
        String outputA = "Side length: " + lengthA + " " + super.unitName + ", opposite angle: "
                + angleA + " " + degreeUnitName + "\n";
        String outputB = "Side length: " + lengthB + " " + super.unitName + ", opposite angle: "
                + angleB + " " + degreeUnitName + "\n";
        String outputC = "Side length: " + lengthC + " " + super.unitName + ", opposite angle: "
                + angleC + " " + degreeUnitName + "\n";
        return outputA + outputB + outputC;
    }

    private double GetAngle(double oppositeSideLength, double secondLength, double thirdLength) {
        return Math.acos((Math.pow(secondLength, 2) + Math.pow(thirdLength, 2) - Math.pow(oppositeSideLength, 2))
                / (2 * secondLength * thirdLength));
    }
}

