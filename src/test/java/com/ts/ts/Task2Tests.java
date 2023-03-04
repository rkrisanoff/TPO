package com.ts.ts;

import com.ts.ts.task2.HashTableOpenAdress;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class Task2Tests {
    HashTableOpenAdress hashTableOpenAdress;
    @BeforeEach
    public  void srartTest(){
        hashTableOpenAdress=new HashTableOpenAdress(29);
    }


    @Test
    @Tag("InsertionCheck")
    @DisplayName("Проверка вставкипустой строки")
    public void testEmptyStringInsertionCheck(){
        int result=hashTableOpenAdress.insert("");
        Assertions.assertEquals(result, -1);
    }
    @Test
    @Tag("InsertionCheck")
    @DisplayName("Проверка вставкиNULL")
    public void testNullInsertCheck(){
        int result=hashTableOpenAdress.insert(null);
        Assertions.assertEquals(result, -1);
    }

    @Test
    @Tag("InsertionCheck")
    @DisplayName("Проверка вставки'1'")
    public void testPushOneValue1(){
        int result=hashTableOpenAdress.insert("1");
        Assertions.assertEquals(result, 20);
    }
    @Test
    @Tag("InsertionCheck")
    @DisplayName("Проверка вставки'asddsa'")
    public void testPushOneValue2(){
        int result=hashTableOpenAdress.insert("asddsa");
        Assertions.assertEquals(result, 22);
    }
    @Test
    @Tag("InsertionCheck")
    @DisplayName("Проверка вставки'asdas213'")
    public void testPushOneValue3(){
        int result=hashTableOpenAdress.insert("asdas213");
        Assertions.assertEquals(result, 6);
    }
    @Test
    @Tag("InsertionCheck")
    @DisplayName("Проверка вставки'asdadw2sda2'")
    public void testPushOneValue4(){
        int result=hashTableOpenAdress.insert("asdadw2sda2");
        Assertions.assertEquals(result, 4);
    }
    @Test
    @Tag("InsertionCheck")
    @DisplayName("Проверка вставки'3dwq'")
    public void testPushOneValue5(){
        int result=hashTableOpenAdress.insert("3dwq");
        Assertions.assertEquals(result, 20);
    }
    @Test
    @Tag("InsertionCheck")
    @DisplayName("Проверка вставки одинаковых  значений")
    public void testСheckingForInsertionOfIdenticalValues(){
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        for(int i=20;i<=28;i++){
            actual.add(i);
            expected.add(hashTableOpenAdress.insert("1"));
        }
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @Tag("InsertionCheck")
    @DisplayName("Проверка вставки объектов с одним HashCode с переходом в начало")
    public void testСheckingTheInsertionOfObjectsWithOneHashCodeWithTheTransitionToTheBeginning(){
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        for(int i=20;i<=31;i++){
            actual.add(i%29);
            if(i%2==0){
                expected.add(hashTableOpenAdress.insert("3dwq"));
            }else{
                expected.add(hashTableOpenAdress.insert("1"));
            }
        }
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @Tag("InsertionCheck")
    @DisplayName("Проверка полной вставки")
    public void testFullInsertCheck(){
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        for(int i=0;i<=29;i++){
            expected.add(hashTableOpenAdress.insert(String.valueOf(i)));
        }
        actual.add(19);
        actual.add(20);
        actual.add(21);
        actual.add(22);
        actual.add(23);
        actual.add(24);
        actual.add(25);
        actual.add(26);
        actual.add(27);
        actual.add(28);
        actual.add(5);
        actual.add(0);
        actual.add(8);
        actual.add(1);
        actual.add(11);
        actual.add(2);
        actual.add(14);
        actual.add(3);
        actual.add(17);
        actual.add(4);
        actual.add(6);
        actual.add(7);
        actual.add(9);
        actual.add(10);
        actual.add(12);
        actual.add(13);
        actual.add(15);
        actual.add(16);
        actual.add(18);
        actual.add(-1);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @Tag("DeletionCheck")
    @DisplayName("Проверка удаления пустой строки")
    public void testDellCLearString(){
        int result=hashTableOpenAdress.delete("");
        Assertions.assertEquals(result, -1);
    }
    @Test
    @Tag("DeletionCheck")
    @DisplayName("Проверка уделения NULL")
    public void testDellNull(){
        int result=hashTableOpenAdress.delete(null);
        Assertions.assertEquals(result, -1);
    }

    @Test
    @Tag("DeletionCheck")
    @DisplayName("Вставка и удаление единственного обьекта")
    public void  testInsertingAndDeletingSingleObject(){
        int actual=hashTableOpenAdress.insert("asdajksdjk");
        int expected=hashTableOpenAdress.delete("asdajksdjk");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @Tag("DeletionCheck")
    @DisplayName("Удаление не существующего обьекта")
    public void testDeletingNonExistentObject(){
        for(int i=0;i<=12;i++){
            hashTableOpenAdress.insert("asdajksdjk-"+i*23);
        }
        int expected=hashTableOpenAdress.delete("1");
        Assertions.assertEquals(expected, -1);
    }
    @Test
    @Tag("DeletionCheck")
    @DisplayName("Уделение несуществующего обьекта, полностью заполненой таблицы")
    public void testAllocatingANonExistentObjectACompletelyFilledTable(){
        for(int i=0; i<29;i++){
            hashTableOpenAdress.insert(String.valueOf(i));
        }
        int expected=hashTableOpenAdress.delete("100");
        Assertions.assertEquals(expected, -1);
    }
    @Test
    @Tag("DeletionCheck")
    @DisplayName("Удаление подряд расположеных одинаковых элементов")
    public void testRemovingContiguousIdenticalElements(){
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        for(int i=0; i<29;i++){
            actual.add(hashTableOpenAdress.insert("aasdw"));
        }
        for(int i=0; i<29;i++){
            expected.add(hashTableOpenAdress.delete("aasdw"));
        }
        Assertions.assertEquals(expected, actual);
    }


    @Test
    @Tag("DeletionCheck")
    @DisplayName("Вставка в удаленную ячейку")
    public void testInsertionInAHotCell(){
        hashTableOpenAdress.insert("asdkasdk");
        int actual= hashTableOpenAdress.delete("asdkasdk");
        int expected=hashTableOpenAdress.insert("asdkasdk");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    @Tag("SearchValidation")
    @DisplayName("Проверка поиска пустой строки")
    public void testFindCLearString(){
        int expected=hashTableOpenAdress.find("");
        Assertions.assertEquals(expected, -1);
    }
    @Test
    @Tag("SearchValidation")
    @DisplayName("Проверка поиска NULL")
    public void testFindNull(){
        int expected=hashTableOpenAdress.find(null);
        Assertions.assertEquals(expected, -1);
    }

    @Test
    @Tag("SearchValidation")
    @DisplayName("Проверка поиска в пустой таблице")
    public void testCheckingALookupInAnEmptyTable(){
        int expected=hashTableOpenAdress.find("sadasd");
        Assertions.assertEquals(expected, -1);
    }
    @Test
    @Tag("SearchValidation")
    @DisplayName("Проверка поиска в  таблице")
    public void testCheckingALookupInAnTable(){
        int actual=hashTableOpenAdress.insert("3");
        hashTableOpenAdress.insert("1");
        hashTableOpenAdress.insert("2");
        hashTableOpenAdress.insert("4");
        hashTableOpenAdress.insert("5");
        int expected=hashTableOpenAdress.find("3");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @Tag("SearchValidation")
    @DisplayName("Проверка поиска удаленного значения")
    public void testRemoteValueLookup(){
        hashTableOpenAdress.insert("3");
        hashTableOpenAdress.insert("1");
        hashTableOpenAdress.insert("2");
        hashTableOpenAdress.insert("4");
        hashTableOpenAdress.insert("5");
        hashTableOpenAdress.delete("3");
        int expected=hashTableOpenAdress.find("3");
        Assertions.assertEquals(expected, -1);
    }
    @Test
    @Tag("SearchValidation")
    @DisplayName("Проверка поиска несуществующего значения в полной таблице")
    public void testValidationOfSearchingForANonExistentValueInTheFullTable(){
        for (int i=0;i<29;i++){
            hashTableOpenAdress.insert(i+"test");
        }
        int expected=hashTableOpenAdress.find("asdasd");
        Assertions.assertEquals(expected, -1);
    }

    @Test
    @Tag("SearchValidation")
    @DisplayName("Проверка поиска значения в полной таблице")
    public void testValidationOfSearchingForExistentValueInTheFullTable(){
        for (int i=0;i<29;i++){
            hashTableOpenAdress.insert(i+"test");
        }
        int expected=hashTableOpenAdress.find("1test");
        Assertions.assertEquals(expected, 1);
    }


    @Test
    @Tag("SearchAndDelete")
    @DisplayName("Полное добавление в таблицу, полный поиск в таблице, полное удаление, полный поиск")
    public void testfullAddToTableFullTableLookupFullDeleteFullLookup(){
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        for (int i=0;i<29;i++){
            actual.add(hashTableOpenAdress.insert(i+"test"));
        }
        for (int i=0;i<29;i++){
            expected.add(hashTableOpenAdress.find(i+"test"));
        }
        for (int i:expected) {
            actual.add(i);
        }
        for (int i=0;i<29;i++){
            expected.add(hashTableOpenAdress.delete(i+"test"));
        }
        for (int i=0;i<29;i++){
            actual.add(-1);
        }
        for (int i=0;i<29;i++){
            expected.add(hashTableOpenAdress.find(i+"test"));
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Tag("findHash")
    @DisplayName("Проверка на строку в 1 элемент")
    public void testFindHashInputLength1(){
        long expected=hashTableOpenAdress.findHash("a");
        Assertions.assertEquals(expected, 97);
    }

    @Test
    @Tag("findHash")
    @DisplayName("Проверка на строку в 10 элемент")
    public void testFindHashInputLength10(){
        long expected=hashTableOpenAdress.findHash("awedwsderw");
        Assertions.assertEquals(expected, 2752359633l);
    }
    @Test
    @Tag("findHash")
    @DisplayName("Проверка на строку в 0 элемент")
    public void testFindHashInputLength0(){
        long expected=hashTableOpenAdress.findHash("");
        Assertions.assertEquals(expected, 0);
    }
    @Test
    @Tag("findHash")
    @DisplayName("Проверка на строку в 20 элемент")
    public void testFindHashInputLength20(){
        long expected=hashTableOpenAdress.findHash("awedwsderwswqasderfg");
        Assertions.assertEquals(expected, 3971067089l);
    }
    @Test
    @Tag("findHash")
    @DisplayName("Проверка на строку 0 элементов")
    public void testFindHashInputLength20(){
        long expected=hashTableOpenAdress.findHash("awedwsderwswqasderfg");
        Assertions.assertEquals(expected, 3971067089l);
    }
    @Test
    @Tag("findHash")
    @DisplayName("Проверка на строку в 5 элементов из чисел")
    public void testFindHashInputLength5ForNumber(){
        long expected=hashTableOpenAdress.findHash("24125");
        Assertions.assertEquals(expected, 3691634);
    }
    @Test
    @Tag("hashToPlace")
    @DisplayName("Проверка хеш больше количества мест")
    public void testHashToPlace(){
        long expected=hashTableOpenAdress.findHash("24125");
        Assertions.assertEquals(expected, 3691634);
    }
    @Test
    @Tag("hashToPlace")
    @DisplayName("Проверка хеш меньше количества мест")
    public void testHashToPlace(){
        long expected=hashTableOpenAdress.findHash("24125");
        Assertions.assertEquals(expected, 3691634);
    }
    @Test
    @Tag("hashToPlace")
    @DisplayName("Проверка хеш раынй 0 ")
    public void testHashToPlace(){
        long expected=hashTableOpenAdress.findHash("24125");
        Assertions.assertEquals(expected, 3691634);
    }


}
