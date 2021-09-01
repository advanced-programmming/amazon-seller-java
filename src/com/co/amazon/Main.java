package com.co.amazon;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int transactionCount = scanner.nextInt();
        List<String> items = new ArrayList<>();

        for(int i = 0; i < transactionCount; i++){
            items.add(scanner.next());
        }

        List<String> result = groupTransactions(items);
        for(String index : result){
            System.out.println(index);
        }
    }

    public static List<String> groupTransactions(List<String> transactions){
        List<String> result = new ArrayList<>();
        Map<String, Integer> transactionCount = new TreeMap<>();

        for(String index : transactions){
            if(transactionCount.containsKey(index)){
                int count = transactionCount.get(index);
                count++;
                transactionCount.replace(index, count);
            }else{
                transactionCount.put(index, 1);
            }
        }

        for(Map.Entry<String, Integer> index : transactionCount.entrySet()){
            StringBuilder value = new StringBuilder(index.getKey()).append(" ").append(index.getValue());
            result.add(value.toString());
        }


        return result;
    }
}
