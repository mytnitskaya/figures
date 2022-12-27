package ru.cft.shift;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.cft.shift.model.Circle;
import ru.cft.shift.model.Rectangle;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FigureCharacteristicTest {

    @Test
    @DisplayName("Throws Exception if count of Circle parameters > 1")
    void add_throwsException_ifCircleParamsCountMoreThanOne(){
        List<Double> params = Arrays.asList(5.0, 6.0);
        assertThrows(Exception.class, ()-> new Circle(params));
    }

    @Test
    @DisplayName("Throws Exception if count of Circle parameters < 1")
    void add_throwsException_ifCircleParamsCountLessThanOne(){
        List<Double> params = Arrays.asList();
        assertThrows(Exception.class, ()-> new Circle(params));
    }

    @Test
    @DisplayName("Throws Exception if count of Rectangle parameters > 2")
    void add_throwsException_ifRectangleParamsCountMoreThanTwo(){
        List<Double> params = Arrays.asList(5.0, 6.0, 7.5);
        assertThrows(Exception.class, ()-> new Rectangle(params));
    }

    @Test
    @DisplayName("Throws Exception if count of Rectangle parameters < 2")
    void add_throwsException_ifRectangleParamsCountLessThanTwo(){
        List<Double> params = Arrays.asList(0.5);
        assertThrows(Exception.class, ()-> new Rectangle(params));
    }

    @Test
    @DisplayName("Throws Exception if count of Triangle parameters > 3")
    void add_throwsException_ifTriangleParamsCountMoreThanThree(){
        List<Double> params = Arrays.asList(5.0, 6.0, 7.5, 0.2);
        assertThrows(Exception.class, ()-> new Rectangle(params));
    }

    @Test
    @DisplayName("Throws Exception if count of Triangle parameters < 3")
    void add_throwsException_ifTriangleParamsCountLessThanThree(){
        List<Double> params = Arrays.asList(0.5);
        assertThrows(Exception.class, ()-> new Rectangle(params));
    }
}
