package hust.soict.dsai.garbage;
import java.nio.file.*;
public class GarbageTest {
    public static void main(String[] args)throws Exception{
        Path file=Files.createTempFile("aims-garbage-",".bin");
        try{
            for(int size:new int[]{0,256,8193}){
                byte[] data=new byte[size];for(int i=0;i<size;i++)data[i]=(byte)i;
                Files.write(file,data);
                String slow=GarbageCreator.read(file.toString()),fast=NoGarbage.read(file.toString());
                if(!slow.equals(fast)||fast.length()!=size)throw new AssertionError("Mismatch");
                for(int i=0;i<size;i++)if(fast.charAt(i)!=(data[i]&0xff))throw new AssertionError("Byte mapping");
            }
        }finally{Files.deleteIfExists(file);}
        System.out.println("PASS: GarbageTest (empty, binary, multi-chunk)");
    }
}
