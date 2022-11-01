package Visitor;

import com.google.gson.Gson;

public class ExportToJsonVisitor implements Visitor {

    Gson gson = new Gson();

    @Override
    public void visit(User user) {
        System.out.println(gson.toJson(user));
    }

    @Override
    public void visit(Asset asset) {
        System.out.println(gson.toJson(asset));
    }

    @Override
    public void visit(Group group) {
        System.out.println(gson.toJson(group));
    }
}
