package com.github.helosantosdesousa.Counter.exercicio02;

public class LambdaStudies {
    public static void main(String[] args) {
        //1
       /* Multiply multiply = (a,b) ->a*b;

        int r = multiply.multiplication(5,4);
        System.out.println("Result: " + r);*/

        //2
       /* PrimeNumbers prime = n -> {
            if (n <= 1) return false;

            for (int i = 2; i < n; i++) {
                if (n % i == 0) return false;
            }

            return true;
        };

        System.out.println(prime.verify(11));
        System.out.println(prime.verify(12));
*/

        //3
        /*String word = "java";
        Transformer transform = (word1 -> word1.toUpperCase());
        System.out.println(transform.transform(word));*/

        //4
        Palindrome palindrome = string -> string.equals(new StringBuilder(string).reverse().toString());
        System.out.println(palindrome.verify("radar"));
        System.out.println(palindrome.verify("not"));
    }


}
