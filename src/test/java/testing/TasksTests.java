package testing;

import org.junit.Assert;
import org.junit.Test;
import solutions.SolutionsInterface;
import solutions.SolutionsInterfaceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class TasksTests {
    private static final SolutionsInterface SOLVER = new SolutionsInterfaceImpl();
    private static final List<TextSample> EMAIL_TEXT_SAMPLES = new ArrayList<>();
    private static final List<TextSample> URL_TEXT_SAMPLES = new ArrayList<>();
    private static final List<TextSample> IP_ADDRESSES_TEXT_SAMPLES = new ArrayList<>();

    static {
        EMAIL_TEXT_SAMPLES.add(new TextSample("godMihovel@gmail.com", new ArrayList<String>() {
            {
                add("godMihovel@gmail.com");
            }
        }
        ));
        EMAIL_TEXT_SAMPLES.add(new TextSample("godMihovel@gmail.com  ", new ArrayList<String>() {
            {
                add("godMihovel@gmail.com");
            }
        }
        ));
        EMAIL_TEXT_SAMPLES.add(new TextSample("godMihovel@gmail.  ", new ArrayList<>()));

        URL_TEXT_SAMPLES.add(new TextSample("", new ArrayList<>()));

        IP_ADDRESSES_TEXT_SAMPLES.add(new TextSample("192.168.1.1", new ArrayList<String>() {
            {
                add("192.168.1.1");
            }
        }));
        IP_ADDRESSES_TEXT_SAMPLES.add(new TextSample("9999.02.233.9", new ArrayList<>()));
        IP_ADDRESSES_TEXT_SAMPLES.add(new TextSample("999.023.255.12", new ArrayList<>()));
        IP_ADDRESSES_TEXT_SAMPLES.add(new TextSample("  172.16.254.1", new ArrayList<String>() {
            {
                add("172.16.254.1");
            }
        }));
    }

    @Test
    public void testTask1Easy() {
        EMAIL_TEXT_SAMPLES.forEach(textSample -> Assert.assertThat(SOLVER.firstTaskEasy(textSample.getText()),
                is(textSample.getExpectedResult())));
    }

    @Test
    public void testTask1Medium() {
        EMAIL_TEXT_SAMPLES.forEach(textSample -> Assert.assertThat(SOLVER.firstTaskMedium(textSample.getText()),
                is(textSample.getExpectedResult())));
    }

    @Test
    public void testTask1Hard() {
        EMAIL_TEXT_SAMPLES.forEach(textSample -> Assert.assertThat(SOLVER.firstTaskHard(textSample.getText()),
                is(textSample.getExpectedResult())));
    }

    @Test
    public void testTask2Easy() {
        URL_TEXT_SAMPLES.forEach(textSample -> Assert.assertThat(SOLVER.secondTaskEasy(textSample.getText()),
                is(textSample.getExpectedResult())));
    }

    @Test
    public void testTask2Hard() {
        URL_TEXT_SAMPLES.forEach(textSample -> Assert.assertThat(SOLVER.secondTaskHard(textSample.getText()),
                is(textSample.getExpectedResult())));
    }

    @Test
    public void testTask3Easy() {
        IP_ADDRESSES_TEXT_SAMPLES.forEach(textSample -> Assert.assertThat(SOLVER.thirdTask(textSample.getText()),
                is(textSample.getExpectedResult())));
    }
}
