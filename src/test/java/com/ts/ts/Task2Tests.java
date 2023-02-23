package com.ts.ts;

import com.ts.ts.task2.HashTableOpenAdress;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import java.util.ArrayList;
import java.util.List;

public class Task2Tests {
    HashTableOpenAdress hashTableOpenAdress;
    @Before
    public void srartTest(){
        hashTableOpenAdress=new HashTableOpenAdress(29);
    }


    @Test
    @Tag("Проверка вставки")
    @DisplayName("Проверка вставки пустой строки")
    public void testEmptyStringInsertionCheck(){
        int result=hashTableOpenAdress.insert("");
        Assert.assertEquals(result, -1);
    }
    @Test
    @Tag("Проверка вставки")
    @DisplayName("Проверка вставки NULL")
    public void testNullInsertCheck(){
        int result=hashTableOpenAdress.insert(null);
        Assert.assertEquals(result, -1);
    }

    @Test
    @Tag("Проверка вставки")
    @DisplayName("Проверка вставки '1'")
    public void testPushOneValue1(){
        int result=hashTableOpenAdress.insert("1");
        Assert.assertEquals(result, 20);
    }
    @Test
    @Tag("Проверка вставки")
    @DisplayName("Проверка вставки 'asddsa'")
    public void testPushOneValue2(){
        int result=hashTableOpenAdress.insert("asddsa");
        Assert.assertEquals(result, 22);
    }
    @Test
    @Tag("Проверка вставки")
    @DisplayName("Проверка вставки 'asdas213'")
    public void testPushOneValue3(){
        int result=hashTableOpenAdress.insert("asdas213");
        Assert.assertEquals(result, 6);
    }
    @Test
    @Tag("Проверка вставки")
    @DisplayName("Проверка вставки 'asdadw2sda2'")
    public void testPushOneValue4(){
        int result=hashTableOpenAdress.insert("asdadw2sda2");
        Assert.assertEquals(result, 4);
    }
    @Test
    @Tag("Проверка вставки")
    @DisplayName("Проверка вставки '3dwq'")
    public void testPushOneValue5(){
        int result=hashTableOpenAdress.insert("3dwq");
        Assert.assertEquals(result, 20);
    }
    @Test
    @Tag("Проверка вставки")
    @DisplayName("Проверка вставки одинаковых значений")
    public void testСheckingForInsertionOfIdenticalValues(){
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        actual.add(20);
        actual.add(21);
        actual.add(22);
        actual.add(23);
        actual.add(24);
        actual.add(25);
        actual.add(26);
        actual.add(27);
        actual.add(28);
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("1"));
        Assert.assertEquals(expected, actual);
    }
    @Test
    @Tag("Проверка вставки")
    @DisplayName("Проверка вставки обьектов с одним HashCode с переходом в начало")
    public void testСheckingTheInsertionOfObjectsWithOneHashCodeWithTheTransitionToTheBeginning(){
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        actual.add(20);
        actual.add(21);
        actual.add(22);
        actual.add(23);
        actual.add(24);
        actual.add(25);
        actual.add(26);
        actual.add(27);
        actual.add(28);
        actual.add(0);
        actual.add(1);
        actual.add(2);
        expected.add(hashTableOpenAdress.insert("3dwq"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("3dwq"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("3dwq"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("3dwq"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("3dwq"));
        expected.add(hashTableOpenAdress.insert("1"));
        expected.add(hashTableOpenAdress.insert("3dwq"));
        expected.add(hashTableOpenAdress.insert("1"));
        Assert.assertEquals(expected, actual);
    }
    @Test
    @Tag("Проверка вставки")
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
        Assert.assertEquals(expected, actual);
    }
    @Test
    @Tag("Проверка удаления")
    @DisplayName("Проверка вставки пустой строки")
    public void testDellCLearString(){
        int result=hashTableOpenAdress.delete("");
        Assert.assertEquals(result, -1);
    }
    @Test
    @Tag("Проверка удаления")
    @DisplayName("Проверка вставки NULL")
    public void testDellNull(){
        int result=hashTableOpenAdress.delete(null);
        Assert.assertEquals(result, -1);
    }

    @Test
    @Tag("Проверка удаления")
    @DisplayName("Вставка и удаление единственного обьекта")
    public void  testInsertingAndDeletingSingleObject(){
        int actual=hashTableOpenAdress.insert("asdajksdjk");
        int expected=hashTableOpenAdress.delete("asdajksdjk");
        Assert.assertEquals(expected, actual);
    }
    @Test
    @Tag("Проверка удаления")
    @DisplayName("Удаление не существубщего обьекта")
    public void testDeletingNonExistentObject(){
        hashTableOpenAdress.insert("asdajksdjk");
        hashTableOpenAdress.insert("123312");
        hashTableOpenAdress.insert("123sd21312");
        hashTableOpenAdress.insert("asd");
        hashTableOpenAdress.insert("asd2");
        hashTableOpenAdress.insert("sadsad");
        hashTableOpenAdress.insert("123asd");
        hashTableOpenAdress.insert("asd21312edsa");
        hashTableOpenAdress.insert("asd12312fgas");
        hashTableOpenAdress.insert("sss");
        hashTableOpenAdress.insert("sssawss");
        hashTableOpenAdress.insert("sd");
        hashTableOpenAdress.insert("asdwq");
        hashTableOpenAdress.insert("sdqw2edas");
        hashTableOpenAdress.insert("asd");
        hashTableOpenAdress.insert("asd21");
        int expected=hashTableOpenAdress.delete("1");
        Assert.assertEquals(expected, -1);
    }
    @Test
    @Tag("Проверка удаления")
    @DisplayName("Уделение несуществующего обьекту, полностью заполненой таблицы")
    public void testAllocatingANonExistentObjectACompletelyFilledTable(){
        for(int i=0; i<29;i++){
            hashTableOpenAdress.insert(String.valueOf(i));
        }
        int expected=hashTableOpenAdress.delete("100");
        Assert.assertEquals(expected, -1);
    }
    @Test
    @Tag("Проверка удаления")
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
        Assert.assertEquals(expected, actual);
    }


    @Test
    @Tag("Проверка удаления")
    @DisplayName("Вставка в удаленную ячейку")
    public void testInsertionInAHotCell(){
        hashTableOpenAdress.insert("asdkasdk");
        int actual= hashTableOpenAdress.delete("asdkasdk");
        int expected=hashTableOpenAdress.insert("asdkasdk");
        Assert.assertEquals(expected, actual);
    }


    @Test
    @Tag("Проверка поиска")
    @DisplayName("Проверка поиска пустой строки")
    public void testFindCLearString(){
        int expected=hashTableOpenAdress.find("");
        Assert.assertEquals(expected, -1);
    }
    @Test
    @Tag("Проверка поиска")
    @DisplayName("Проверка поиска NULL")
    public void testFindNull(){
        int expected=hashTableOpenAdress.find(null);
        Assert.assertEquals(expected, -1);
    }

    @Test
    @Tag("Проверка поиска")
    @DisplayName("Проверка поиска в пустой таблице")
    public void testCheckingALookupInAnEmptyTable(){
        int expected=hashTableOpenAdress.find("sadasd");
        Assert.assertEquals(expected, -1);
    }
    @Test
    @Tag("Проверка поиска")
    @DisplayName("Проверка поиска в  таблице")
    public void testCheckingALookupInAnTable(){
        int actual=hashTableOpenAdress.insert("3");
        hashTableOpenAdress.insert("1");
        hashTableOpenAdress.insert("2");
        hashTableOpenAdress.insert("4");
        hashTableOpenAdress.insert("5");
        int expected=hashTableOpenAdress.find("3");
        Assert.assertEquals(expected, actual);
    }
    @Test
    @Tag("Проверка поиска")
    @DisplayName("Проверка поиска удаленного значения")
    public void testRemoteValueLookup(){
        int actual= -1;
        hashTableOpenAdress.insert("3");
        hashTableOpenAdress.insert("1");
        hashTableOpenAdress.insert("2");
        hashTableOpenAdress.insert("4");
        hashTableOpenAdress.insert("5");
        hashTableOpenAdress.delete("3");
        int expected=hashTableOpenAdress.find("3");
        Assert.assertEquals(expected, actual);
    }
    @Test
    @Tag("Проверка поиска")
    @DisplayName("Проверка поиска несуществующего значения в полной таблице")
    public void testValidationOfSearchingForANonExistentValueInTheFullTable(){
        int actual= -1;
        for (int i=0;i<29;i++){
            hashTableOpenAdress.insert(String.valueOf(i)+"test");
        }
        int expected=hashTableOpenAdress.find("asdasd");
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Tag("Проверка поиска")
    @DisplayName("Проверка поиска значения в полной таблице")
    public void testValidationOfSearchingForExistentValueInTheFullTable(){
        int actual= 1;
        for (int i=0;i<29;i++){
            hashTableOpenAdress.insert(i+"test");
        }
        int expected=hashTableOpenAdress.find("1test");
        Assert.assertEquals(expected, actual);
    }


    @Test
    @Tag("Проверка поиска удаления добавления")
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
        Assert.assertEquals(expected, actual);
    }

}
