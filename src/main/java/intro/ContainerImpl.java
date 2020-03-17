package intro;

import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class ContainerImpl implements Container {
    Set<String> setOfNames;

    public ContainerImpl(){
        setOfNames = new LinkedHashSet<>();
    }
    public void add(String name) {
        setOfNames.add(name);
    }

    public void out() {
        setOfNames.forEach(System.out::println);
    }
}
