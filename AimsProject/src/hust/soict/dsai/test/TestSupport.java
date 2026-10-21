package hust.soict.dsai.test;
import java.io.*;
public final class TestSupport {
    private TestSupport() {}
    public static void check(boolean ok, String msg) { if (!ok) throw new AssertionError(msg); }
    public static String capture(Runnable action) {
        PrintStream original=System.out;
        ByteArrayOutputStream bytes=new ByteArrayOutputStream();
        PrintStream replacement=new PrintStream(bytes);
        try { System.setOut(replacement); action.run(); }
        finally { System.setOut(original); replacement.close(); }
        return bytes.toString();
    }
}
