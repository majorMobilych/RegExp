package solutions;

import java.util.List;

public interface SolutionsInterface {

    /**
     * Watch first task;
     */
    List<String> firstTaskEasy(String text);

    List<String> firstTaskMedium(String text);

    List<String> firstTaskHard(String text);

    /**
     * Watch second task;
     */
    List<String> secondTaskEasy(String text);

    List<String> secondTaskHard(String text);

    /**
     * Watch third task;
     */
    List<String> thirdTaskEasy(String text);

    List<String> thirdTaskHard(String text);
}
