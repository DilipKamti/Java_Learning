package java_02_oops.practice;

import java.util.HashSet;
import java.util.Objects;

class withoutEqualhashCode{
    int id;
    String name;

    public withoutEqualhashCode(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class withEqualHashCode{
    int id;
    String name;

    public withEqualHashCode(int id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        withEqualHashCode obj= (withEqualHashCode) o;
        return Objects.equals(id, obj.id) && Objects.equals(name, obj.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name);
    }

}

public class EqualHashcodeExample {

    public static void main(String[] args){

        System.out.println(" ====== Example without overriding equals and hashCode: ====== ");

        withoutEqualhashCode wehc1= new withoutEqualhashCode(1, "John");
        withoutEqualhashCode wehc2= new withoutEqualhashCode(1, "John");

        HashSet<withoutEqualhashCode> set1= new HashSet<>();
        set1.add(wehc1);
        set1.add(wehc2); // wehc2 will be added to the set because equals and hashCode are not overridden, so it treats wehc1 and wehc2 as different objects

        System.out.println(wehc1==wehc2); // false, because they are different objects in memory
        System.out.println(wehc1.equals(wehc2)); // false, because equals is not overridden, so it behaves like '=='
        System.out.println(wehc1.hashCode()); // different hash codes for wehc1 and wehc2, because hashCode is not overridden
        System.out.println(wehc2.hashCode());
        System.out.println(set1.size()); // 2, because both wehc1 and wehc2 are treated as different objects in the HashSet

        System.out.println(" ====== Example with overriding equals and hashCode: ====== ");

        withEqualHashCode wehc3= new withEqualHashCode(1, "John");
        withEqualHashCode wehc4= new withEqualHashCode(1, "John");

        HashSet<withEqualHashCode> set2= new HashSet<>();
        set2.add(wehc3);
        set2.add(wehc4); // wehc4 will not be added to the set because equals and hashCode are overridden, so it treats wehc3 and wehc4 as the same object

        System.out.println(wehc3==wehc4); // false, because they are different objects in memory
        System.out.println(wehc3.equals(wehc4)); // true, because equals is overridden to compare the content of the objects, so it returns true for wehc3 and wehc4
        System.out.println(wehc3.hashCode()); // same hash code for wehc3 and wehc4, because hashCode is overridden to generate the same hash code for objects with the same content
        System.out.println(wehc4.hashCode());        System.out.println(set2.size()); // 1, because wehc3 and wehc4 are treated as the same object in the HashSet due to the overridden equals and hashCode methods


    }
}
