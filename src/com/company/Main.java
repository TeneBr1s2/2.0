// Султанов Марат 10мб
package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.RandomAccess;

public class Main {
    public static void sortind(RandomAccessFile d, int[] ind) throws IOException {
        // hfjke
        int k,t,x,y;
        d.seek(0);//переход в начало файла
        for(int i=0; i<ind.length-1; i++){//основной цикл сортировки, проходящий последовательно через все элементы массива
            d.seek(ind[i]);x=d.read();//чтение элемента в файле под номером "i" и его запись в "х"
            k=i;
            for(int j=i+1; j<ind.length; j++){
                d.seek(ind[j]);y=d.read();//чтение элемента в файле под номером "j" и его запись в "y"
                if(y<x){k=j;x=y;}//если "выбранный" элемент меньше, то маркер(к) переносится на выбр элемент
            }
            t=ind[k];ind[k]=ind[i];ind[i]=t;//замена ячейки с маркером "к" на ячейку "i" = swap.
        }
        for (var i=0; i<ind.length; i++){System.out.printf("%4d", ind[i]);}//вывод отсортированного массива индексов
    }
    public static void main(String[] args) throws IOException {//+ возможность работы с файлом(при возникновении ошибок,например, отсутсвие нужного файла)
        RandomAccessFile d=new RandomAccessFile("1.dat","rw");//объявление фаила с доступом к любому байту в "любой момент"
        var ind=new int[20];//массив для инд-ов
        d.setLength(ind.length);//длина файла=длине массива
        for (var i=0; i<ind.length; i++){ind[i]=i;System.out.printf("%4d",i);}//массив от 0 до 19 + вывод
        System.out.println();//след строка
        for (var i=0; i<ind.length; i++)
            d.write((int) Math.round(65+Math.random()*25));//запись случайного числа от 65 до 90 в фаил. 20 симв.
        d.seek(0);//переход в начало файла
        for (var i=0; i<ind.length; i++) System.out.printf("%4d",d.read());//чтетие и вывод содержимого файла
        System.out.println();//след строка
        sortind(d , ind);//применение внешней сорт на данной файле с данным массивом индесков
        System.out.println();//след строка
        for (var i=0; i<ind.length; i++){d.seek(ind[i]);System.out.printf("%4d",d.read());}//вывод содержимого файла по отсортированному массиву
        System.out.println();
        d.close();
        pp[] p = new pp[20];
        for( int i=0; i<p.length; i++){
            p[i]= new pp(String.valueOf(i), (int)(Math.random()*20));
            System.out.println(p[i].c);
        }
    }
}
class pp{
    char[] n=new char[10];
    int c;
    pp(String N, int C){
        for(int i=0; i<N.length();i++) n[i]=N.charAt(i);
        c=C;
        System.out.println(n.length);
    }
}