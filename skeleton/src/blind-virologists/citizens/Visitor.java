package citizens;

import map.*;

public interface Visitor {
    public void visit(Laboratory lab);

    public void visit(Warehouse warehouse);

    public void visit(Empty empty);

    public void visit(Shelter shelter);
}
