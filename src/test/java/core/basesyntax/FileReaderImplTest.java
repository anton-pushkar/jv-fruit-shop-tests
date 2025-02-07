package core.basesyntax;

import core.basesyntax.servises.FileReader;
import core.basesyntax.servises.impl.FileReaderImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileReaderImplTest {
    private static final String WRONG_PATH = "java/abcd.csv";
    private static final String CORRECT_PATH = "src/test/java/resources/inputTest.csv";
    private static final List<String> test = Arrays.asList(
            "b,banana,20", "b,apple,100", "s,banana,100","p,banana,13");

    private static FileReader fileReader;

    @BeforeClass
    public static void setUp() {
        fileReader = new FileReaderImpl();
    }

    @Test(expected = RuntimeException.class)
    public void readFromWrongPath_NotOk() {
        fileReader.readFromFile(WRONG_PATH);
    }

    @Test
    public void readCorrectPath_Ok() {
        List<String> readFromCorrectFile = fileReader.readFromFile(CORRECT_PATH);
        Assert.assertEquals(readFromCorrectFile, test);
    }
}
