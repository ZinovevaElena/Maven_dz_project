package ru.netology.mavenproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    public void testSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertTrue(simpleTask.matches("Позвонить родителям"));//проверка названия задачи
        Assertions.assertTrue(simpleTask.matches("Позвонить"));//проверка одного слова в названии задачи
        Assertions.assertFalse(simpleTask.matches("Приложение НетоБанка"));// проверка поиска другого названия задачи
        Assertions.assertFalse(simpleTask.matches("позвонить родителям")); // проверка регистра
        Assertions.assertFalse(simpleTask.matches("_______")); // отсутствие названия
        Assertions.assertFalse(simpleTask.matches("родителю")); // другой падеж
    }

    @Test
    public void testEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Assertions.assertTrue(epic.matches("Молоко")); // проверка подзадачи
        Assertions.assertTrue(epic.matches("Яйца")); // проверка подзадачи
        Assertions.assertFalse(epic.matches("яйца")); // проверка регистра
        Assertions.assertFalse(epic.matches("Позвонить родителям")); //// проверка поиска другого названия подзадачи
    }

    @Test
    public void testMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertTrue(meeting.matches("Выкатка")); // проверка topic
        Assertions.assertTrue(meeting.matches("Приложение НетоБанка")); // провека project
        Assertions.assertFalse(meeting.matches("Выкатка 2й версии приложения")); // проверка другого названия
        Assertions.assertFalse(meeting.matches("приложение Нетобанка")); // проверка регистра
    }
}