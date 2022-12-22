package ru.cft.shift.writer;

public class ConsoleWriter implements IWriter {
    @Override
    public void WriteLine(String line) {
        System.out.print(line);
    }

    @Override
    public void FinishWrite() {

    }
}
