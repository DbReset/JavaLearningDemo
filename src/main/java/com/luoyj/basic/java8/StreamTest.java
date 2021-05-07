package com.luoyj.basic.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*java8新特性
 stream 使用
  可方便的进行流处理更简洁方便
* */
public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        System.out.println(strings);
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        System.out.println(filtered);
    }


}
