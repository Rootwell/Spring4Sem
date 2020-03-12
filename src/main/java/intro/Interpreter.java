package intro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Interpreter {
    @Autowired
    Container container;

    public void interpret(String command) {
        String commands[] = command.split(" ");
        switch (commands[0]) {
            case "add":
                container.add(commands[1]);
                break;
            case "out":
                container.out();
                break;
        }
    }
}
