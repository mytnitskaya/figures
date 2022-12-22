package ru.cft.shift.writer;

import java.io.IOException;

public interface IWriter {
    void WriteLine(String line) throws IOException;

    void FinishWrite();
}
