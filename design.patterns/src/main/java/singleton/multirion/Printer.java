package singleton.multirion;

import java.util.HashMap;

class Printer {
    private static int instanceCount = 0;

    private Printer() {
        instanceCount++;
        System.out.println("A total of " +  instanceCount + " instances created so far.");
    }

    private static HashMap<Subsystem, Printer> instances = new HashMap<>();

    public static Printer get(Subsystem subsystem) {
        if (instances.containsKey(subsystem)) {
            return instances.get(subsystem);
        }
        Printer printer = new Printer();
        instances.put(subsystem, printer);
        return printer;
    }
}