import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void simpleTaskMatchesTrueTest() {
        Task simpleTask = new SimpleTask(1, "Сходить в магазин");

        boolean actual = simpleTask.matches("магазин");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskMatchesFalseTest() {
        Task simpleTask = new SimpleTask(2, "Сходить в магазин");

        boolean actual = simpleTask.matches("позаонить");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicMatchesTrueTest() {
        String[] subtasks = {"Булка", "Молоко", "Сыр", "Корм для кошки"};
        Task epic = new Epic(3, subtasks);

        boolean actual = epic.matches("Корм");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicMatchesFalseTest() {
        String[] subtasks = {"Булка", "Молоко", "Сыр", "Корм для кошки"};
        Task epic = new Epic(4, subtasks);

        boolean actual = epic.matches("Кефир");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingMatchesTopicTrueTest() {
        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Выкатка");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingMatchesProjectTrueTest() {
        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Приложение");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingMatchesFalseTest() {
        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("вторник");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
}
