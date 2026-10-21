package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import static hust.soict.dsai.test.TestSupport.*;
public class DiscTest {
    public static void main(String[] args) {
        int before=DigitalVideoDisc.getNbDigitalVideoDiscs();
        DigitalVideoDisc a=new DigitalVideoDisc("A");
        DigitalVideoDisc b=new DigitalVideoDisc("Animation","B",1f);
        DigitalVideoDisc c=new DigitalVideoDisc("Director","Drama","C",2f);
        DigitalVideoDisc d=new DigitalVideoDisc("D","Action","Other",90,3f);
        check(a.getId()==before+1 && b.getId()==before+2 && c.getId()==before+3 && d.getId()==before+4,"IDs");
        check(b.getTitle().equals("B") && b.getCategory().equals("Animation"),"Three-arg order");
        check(c.getTitle().equals("C") && c.getDirector().equals("Director"),"Four-arg order");
        check(d.getLength()==90 && d.getCost()==3,"Full constructor");
        a.setTitle("New title");check(a.getId()==before+1 && a.getTitle().equals("New title"),"Mutation");
        for(float cost:new float[]{-1f,Float.NaN,Float.POSITIVE_INFINITY}){
            try{new DigitalVideoDisc("Bad","","",0,cost);throw new AssertionError("Invalid cost");}
            catch(IllegalArgumentException expected){}
        }
        try{new DigitalVideoDisc(" ");throw new AssertionError("Blank title");}
        catch(IllegalArgumentException expected){}
        check(DigitalVideoDisc.getNbDigitalVideoDiscs()==before+4,"Counter increments once");
        check(d.toString().equals("DVD - D - Action - Other - 90: 3.00 $"),"toString");
        System.out.println("PASS: DiscTest");
    }
}
