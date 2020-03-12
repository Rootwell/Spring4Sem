package intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("intro");
        Interpreter interpreter = context.getBean(Interpreter.class);
        Scanner scanner = new Scanner(System.in);
        String ln;
        while (!(ln = scanner.nextLine()).startsWith("stop")) {
            interpreter.interpret(ln);
        }
    }
}
