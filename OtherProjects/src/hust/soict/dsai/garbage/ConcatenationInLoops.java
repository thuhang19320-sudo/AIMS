package hust.soict.dsai.garbage;
import java.util.Random;
public class ConcatenationInLoops {
    private static volatile int sink;
    public static void main(String[] args) {
        int n=args.length==0?65536:Integer.parseInt(args[0]);
        if(n<0)throw new IllegalArgumentException("Non-negative iterations required");
        Random r=new Random(123);long start=System.nanoTime();String s="";
        for(int i=0;i<n;i++)s+=r.nextInt(2);
        long plus=System.nanoTime()-start;
        r=new Random(123);start=System.nanoTime();StringBuffer buffer=new StringBuffer();
        for(int i=0;i<n;i++)buffer.append(r.nextInt(2));
        String buffered=buffer.toString();long bt=System.nanoTime()-start;
        r=new Random(123);start=System.nanoTime();StringBuilder builder=new StringBuilder();
        for(int i=0;i<n;i++)builder.append(r.nextInt(2));
        String built=builder.toString();long st=System.nanoTime()-start;
        if(!s.equals(buffered)||!s.equals(built))throw new AssertionError("Different contents");
        sink=s.hashCode();
        System.out.printf("iterations=%d; +=%.3f ms; StringBuffer=%.3f ms; StringBuilder=%.3f ms%n",n,plus/1e6,bt/1e6,st/1e6);
        System.out.println("PASS: identical results, length="+s.length());
    }
}
