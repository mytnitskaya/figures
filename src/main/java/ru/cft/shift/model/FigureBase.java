package ru.cft.shift.model;

import ru.cft.shift.writer.IWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class FigureBase {
    protected final String unitName = "cm";
    protected final String areaUnitName = "cm2";

    public FigureBase(List<Double> params) throws Exception {
        InitFigure(params);
    }

    protected abstract void InitFigure(List<Double> params) throws Exception;

    protected abstract String GetName();

    protected abstract String GetArea();

    protected abstract String GetPerimeter();

    protected abstract String GetCustom();

    public void WriteResult(ArrayList<IWriter> writers) throws IOException {
        for (IWriter writer : writers) {
            writer.WriteLine("Figure type: " + GetName() + "\n");
            writer.WriteLine("Area: " + GetArea() + "\n");
            writer.WriteLine("Perimeter: " + GetPerimeter() + "\n");
            writer.WriteLine(GetCustom());

            writer.FinishWrite();
        }
    }
}
