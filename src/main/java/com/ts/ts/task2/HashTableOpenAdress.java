package com.ts.ts.task2;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class HashTableOpenAdress<T>{
    private Object[] elementData;
    private static final int DEFAULT_CAPACITY=16;


    public HashTableOpenAdress(){
        elementData=new Object[DEFAULT_CAPACITY];
        Arrays.fill(elementData,StatusElement.CLEAR);
    }

    public HashTableOpenAdress(int capacity){
        elementData=new Object[capacity];
        Arrays.fill(elementData,StatusElement.CLEAR);
    }

    private int findPosition(Object e){
        return Math.abs(e.hashCode()%elementData.length);
    }
    private boolean canPutElement(int i){
        if(elementData[i] instanceof StatusElement) {
                return true;
        }else {
            return false;
        }
    }
    private int findClearPosition(int position){
        for(int i=position;i<elementData.length;i++){
            if(canPutElement(i)){
                return i;
            }
        }
        for(int i=0; i<position;i++){
            if(canPutElement(i)){
                return i;
            }
        }
        return -1;
    }
    private int setPosition(Object e, int position){
        int positionForSet=findClearPosition(position);
        if(positionForSet!=-1){
            elementData[positionForSet]=e;
        }
        return positionForSet;
    }


    private boolean checkPositionOnClear(int position){
        try {
            if(StatusElement.valueOf(elementData[position].toString())==StatusElement.CLEAR){
                return true;
            }
            return false;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    private int findPositionWithElement(Object e,int startPosition){
        for(int i=startPosition;i<elementData.length;i++){
            if(e.equals(elementData[i])){
                return i;
            }else{
                if(checkPositionOnClear(i)){
                    return -1;
                }
            }
        }
        for(int i=0; i<startPosition;i++){
            if(e.equals(elementData[i])){
                return i;
            }else{
                if(checkPositionOnClear(i)){
                    return -1;
                }
            }
        }
        return -1;

    }
    private int clearPositionWithElement(Object e){
        int positionForClear=findPositionWithElement(e,findPosition(e));
        if(positionForClear!=-1){
            elementData[positionForClear]=StatusElement.DELETE;
        }
        return positionForClear;

    }
    //Интерфейсы для взаимодествия
    /**
     * Очищает елемент в массиве, с данным значением
     *
     * @param e Элемент, котоырй необходимо удалить
     * @return  Возвращает номмер элемента в массиве, который был очищен, в случае,
     *          если удалить не получилось, возвращает -1
     */
    public int delete(T e){

        if(e!=null){
            return clearPositionWithElement(e);
        }
        return -1;
    }
    /**
     * Ищен данный элемент в массиве
     *
     * @param e Элемент, котоырй необходимо найти
     * @return  Возвращает номмер элемента в массиве, где находится элемент, в случае,
     *          если найти не получилось, возвращает -1
     */
    public int find(T e){
        if(e!=null){
            return findPositionWithElement(e,findPosition(e));
        }
        return -1;
    }
    /**
     * Добавляет данный элемент в массив
     *
     * @param e Элемент, котоырй необходимо добавить
     * @return  Возвращает номмер элемента в массиве, куда был вставлен элемент, в случае,
     *          если вставить элемент не получилось, возвращает -1
     */
    public int insert(T e){
        if(e!=null){
            return setPosition(e,findPosition(e));
        }
        return -1;

    }




}
