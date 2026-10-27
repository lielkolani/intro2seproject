package edu.starter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class StarterTest {
 @Test void clampingIsCorrect(){assertEquals(10,Checks.within(12,0,10));}
 @Test void missingNumberIsRejected(){assertEquals(-1,ConsoleChoice.read(new java.util.Scanner("abc\n"),1,4));}
}
