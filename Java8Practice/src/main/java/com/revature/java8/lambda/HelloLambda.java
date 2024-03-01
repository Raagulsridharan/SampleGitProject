package com.revature.java8.lambda;

public class HelloLambda {
    public static void main(String[] args) {
//        Hello hello = ()->"hello lambda";//()->{return "hello lambda";};
//        System.out.println(hello.SayHello());

//        Hello helloOneParam = firstName -> "hello "+firstName; //(String firstName)->{return "hello "+firstName;};
//        System.out.println(helloOneParam.SayHelloOneParam("Raagul"));

        Hello helloCalculator = (num1,num2,op)->{
            int result = 0;
            switch (op){
                case "+": result = num1+num2; break;
                case "-": result = num1-num2; break;
                case "*": result = num1*num2; break;
                case "/": result = num1/num2; break;
                default:
                    System.out.println("invalid operations");
            }
            return result;
        };
        System.out.println("Result : "+helloCalculator.calCulator(2,3,"+"));
    }
}