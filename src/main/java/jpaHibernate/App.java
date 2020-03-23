package jpaHibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import jpaHibernate.interpreter.Interpreter;

import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Interpreter interpreter = context.getBean(Interpreter.class);

        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equals("stop")){
            interpreter.handle(input);
        }

    }

}
