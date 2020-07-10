package Moderate;

import java.util.Arrays;

/*

Solution O(Log P)
 */

public class MaxYearAliveSmart {

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
        Person p5 = new Person(1996,1999);
        Person p6 = new Person(1992,1995);


        Person[] persons = {p1,p2,p3,p4,p5,p6};
        System.out.println(getMaxAliveYear(persons));

    }

    public static int getMaxAliveYear(Person[] persons){

        int[] birthYears = sortedYear(persons, true);
        int[] deathyears = sortedYear(persons, false);

        int birthIndex = 0;
        int deathIndex = 0;
        int currentlyAlive = 0;
        int maxAlive =0;
        int maxAliveYear = 1900;
        while( birthIndex < birthYears.length){
            if(birthYears[birthIndex] <= deathyears[deathIndex]){
                currentlyAlive ++;
                if(currentlyAlive > maxAlive) {
                    maxAlive = currentlyAlive;
                    maxAliveYear = birthYears[birthIndex];
                }
                birthIndex++;
            }
            else if(birthYears[birthIndex] > deathyears[deathIndex]){
                currentlyAlive--;
                deathIndex ++;
            }



        }



        return maxAliveYear;
    }

    public static int[] sortedYear(Person[] persons, boolean isBirth){


        int[] sortedYears = new int[persons.length];

        for(int i =0;i<persons.length; i++){
           sortedYears[i] = isBirth ? persons[i].birth : persons[i].death;
        }

        Arrays.sort(sortedYears);

        return sortedYears;
    }
}
