
import javax.tools.*;
import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.*;
import java.lang.reflect.*;
public class CompileAndTest {
    public static void main(String[] args) throws Exception {
        JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
        Map<String,ByteArrayOutputStream> compiled=new HashMap<>();
        StandardJavaFileManager standard=compiler.getStandardFileManager(null,null,null);
        JavaFileManager manager=new ForwardingJavaFileManager<StandardJavaFileManager>(standard){
            @Override public JavaFileObject getJavaFileForOutput(Location location,String name,JavaFileObject.Kind kind,FileObject sibling){
                return new SimpleJavaFileObject(URI.create("mem:///"+name.replace('.','/')+kind.extension),kind){
                    @Override public OutputStream openOutputStream(){
                        ByteArrayOutputStream output=new ByteArrayOutputStream();compiled.put(name,output);return output;
                    }
                };
            }
        };
        List<File> sources=new ArrayList<>();
        for(String dir:new String[]{"AimsProject/src","OtherProjects/src"})
            try(java.util.stream.Stream<Path> paths=Files.walk(Paths.get(args[0],dir))){
                paths.filter(p->p.toString().endsWith(".java")).forEach(p->sources.add(p.toFile()));
            }
        boolean ok=compiler.getTask(null,manager,null,Arrays.asList("--release","8","-encoding","UTF-8","-Xlint:all,-options"),null,
            standard.getJavaFileObjectsFromFiles(sources)).call();
        if(!ok)throw new AssertionError("Compilation failed");
        System.out.println("PASS: compiled "+sources.size()+" Java sources targeting Java 8 (in-memory class output)");
        ClassLoader loader=new ClassLoader(){
            @Override protected Class<?> findClass(String name)throws ClassNotFoundException{
                ByteArrayOutputStream b=compiled.get(name);if(b==null)throw new ClassNotFoundException(name);
                byte[] bytes=b.toByteArray();return defineClass(name,bytes,0,bytes.length);
            }
        };
        for(String test:new String[]{"hust.soict.dsai.test.cart.CartTest","hust.soict.dsai.test.store.StoreTest",
            "hust.soict.dsai.test.disc.DiscTest","hust.soict.dsai.test.disc.TestPassingParameter",
            "hust.soict.dsai.garbage.GarbageTest","hust.soict.dsai.aims.Aims"}){
            try{loader.loadClass(test).getMethod("main",String[].class).invoke(null,(Object)new String[0]);}
            catch(InvocationTargetException ex){throw new RuntimeException(test,ex.getCause());}
        }
        loader.loadClass("hust.soict.dsai.garbage.ConcatenationInLoops").getMethod("main",String[].class)
            .invoke(null,(Object)new String[]{"12000"});
        manager.close();
    }
}
