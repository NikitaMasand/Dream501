package GarbageCollection;
/*
Island of Isolation:

Object 1 references Object 2 and Object 2 references Object 1.
Neither Object 1 nor Object 2 is referenced by any other object.
That’s an island of isolation.
Basically, an island of isolation is a group of objects that reference each other
but they are not referenced by any active object in the application. Strictly speaking,
even a single unreferenced object is an island of isolation too.
 */
public class IslandsOfIsolation {
    IslandsOfIsolation i;
    public static void main(String[] args) {
        IslandsOfIsolation i1 = new IslandsOfIsolation();
        IslandsOfIsolation i2 = new IslandsOfIsolation();
        i1.i = i2;
        i2.i = i1;
        i1=null;
        i2=null;
        System.gc();
    }
    @Override
    protected void finalize() throws Throwable{
        System.out.println("finalize called...");
    }
}
