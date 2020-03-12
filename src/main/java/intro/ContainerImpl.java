package intro;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ContainerImpl {
    Set<String> setOfNames;

    public void add(String name) {
        setOfNames.add(name);
    }

    public void out() {
        setOfNames.forEach(System.out::println);
    }
}
