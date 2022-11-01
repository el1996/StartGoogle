package Visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorMain {

    public static void main(String[] args) {
        List<Resource> resources = new ArrayList<>();
        resources.add(new User(1, "Elchanan", "gjdsu"));
        resources.add(new Asset(2, "Dan", 2.5));
        resources.add(new Group(3, 10));

        ExportToJsonVisitor exportToJsonVisitor = new ExportToJsonVisitor();
        for (Resource resource : resources) {
            resource.accept(exportToJsonVisitor);
        }
    }
}
