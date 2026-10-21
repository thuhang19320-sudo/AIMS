package hust.soict.dsai.garbage;
import java.io.IOException;
import java.nio.file.*;
/** Deliberately quadratic copying; use a bounded heap for experiments. */
public class GarbageCreator {
    public static String read(String file)throws IOException{
        byte[] bytes=Files.readAllBytes(Paths.get(file));String output="";
        for(byte value:bytes)output+=(char)(value&0xff);
        return output;
    }
    public static void main(String[] args)throws IOException{
        if(args.length!=1)throw new IllegalArgumentException("Usage: GarbageCreator <file>");
        long start=System.nanoTime();String s=read(args[0]);
        System.out.printf("GarbageCreator: bytes=%d hash=%d time=%.3f ms%n",s.length(),s.hashCode(),(System.nanoTime()-start)/1e6);
    }
}
