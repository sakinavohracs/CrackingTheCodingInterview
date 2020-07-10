package Moderate;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*


Solution with O(n*p) Time Complexity;
 */

public class MaxAliveYear {

    public static class Person{
        int birth;
        int death;

        Person(int birth, int death){
            this.birth = birth;
            this.death = death;
        }

        public int getBirth(){
            return birth;
        }

        public int getDeath(){
            return death;
        }

    }


    public static void main(String[] args) {
        Person p1 = new Person(1990,1995);
        Person p2 = new Person(1992,1998);
        Person p3 = new Person(1990,1998);
        Person p4 = new Person(1993,1998);
        Person p5 = new Person(1996,1998);
        Person p6 = new Person(1992,1998);


        Person[] persons = {p1,p2,p3,p4,p5,p6};
        System.out.println(getMaxAliveYear(persons));

    }

    public static int getMaxAliveYear(Person[] persons){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(Person person : persons){

            int birthyear = person.getBirth();

            int val = person.getDeath();

            for(int i=birthyear; i<=val;i++){
                int count =0;
                if(map.containsKey(i)){
                    count = map.get(i) + 1;
                    map.put(i,count);
                }else {
                     map.put(i,count);
                }
            }
        }

       int value =  Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        return value;

    }
}
