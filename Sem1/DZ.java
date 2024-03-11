//mip24 2024/03/11

package Sem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

// Напишите программу, которая использует Stream API для обработки списка чисел. 
// Программа должна вывести на экран среднее значение всех четных чисел в списке.
public class DZ{
    public static void main(String[] args) {
        Random rnd = new Random();
        List<Integer> list = new ArrayList<>();
        int maxSiezeOfArray = 100;

        for(int i = 0; i < maxSiezeOfArray; i++){
            list.add(rnd.nextInt(1000));
        }

        System.out.println(list);
        System.out.println();

        final int[] counters = new int[6];
        /* 
            0 - количество всех чисел
            1 - сумма всех чисел
            2 - количество четных чисел
            3 - сумма всех четных чисел
            4 - количество не четных чисел
            5 - сумма не четных чисел
        */

        //Сперва перебором через цикл
        for(Integer num: list){
            counters[0]++;
            counters[1] += num;
            if(num % 2 == 0){
                counters[2]++;
                counters[3] += num;
            } else {
                counters[4]++;
                counters[5] += num;
            }
        }
        System.out.println("Циклом:");
        printResult(counters);


        //Обнуляем счетчики
        for(int i = 0; i < counters.length; i++){
            counters[i] = 0;
        }

        //Теперь стримом
        counters[0] = list.size();
        list.stream().forEach(num -> counters[1] += num);

        counters[2] = (int) list.stream().filter(num -> num % 2 == 0).count();
        list.stream().filter(num -> num % 2 == 0).forEach(num -> counters[3] += num);

        counters[4] = counters[0] - counters[2];
        counters[5] = counters[1] - counters[3];
        
        System.out.println();
        System.out.println("Стримом:");
        printResult(counters);


    }

    public static void printResult(int[] counters){
        float averageTotal = (counters[1]*100/counters[0])/100;
        float averageEven = (counters[3]*100/counters[2])/100;
        float averageOdd = (counters[5]*100/counters[4])/100;
        StringBuffer result = new StringBuffer("Сумма, колиечтво, среднее.");
        result.append(String.format("\nДля всех    : %d; %d; %.2f", counters[1], counters[0], averageTotal));
        result.append(String.format("\nДля четных  : %d; %d; %.2f", counters[3], counters[2], averageEven));
        result.append(String.format("\nДля нечетных: %d; %d; %.2f", counters[5], counters[4], averageOdd));

        System.out.println(result.toString());
    }
}