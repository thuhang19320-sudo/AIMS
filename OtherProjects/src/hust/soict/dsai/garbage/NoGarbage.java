package hust.soict.dsai.garbage;
import java.io.*;
import java.nio.file.*;
/** Linear-time buffered version; allocations still exist. */
public class NoGarbage {
    public static String read(String file)throws IOException{
        StringBuffer output=new StringBuffer();byte[] chunk=new byte[8192];
        try(InputStream input=Files.newInputStream(Paths.get(file))){
            int count;while((count=input.read(chunk))!=-1)
                for(int i=0;i<count;i++)output.append((char)(chunk[i]&0xff));
        }
        return output.toString();
    }
    public static void main(String[] args)throws IOException{
        if(args.length!=1)throw new IllegalArgumentException("Usage: NoGarbage <file>");
        long start=System.nanoTime();String s=read(args[0]);
        System.out.printf("NoGarbage: bytes=%d hash=%d time=%.3f ms%n",s.length(),s.hashCode(),(System.nanoTime()-start)/1e6);
    }
}
