import java.util.*;
/** 
 @ author Steven Nirenberg
 */
 
 public class Campers implements Comparable
 {
	 int count;
     // data members
     String name;
     int age;
     String gender;

     // constructor
     /**
     Standard constructor
     @param n name of camper
     @param a age of camper
     @param g camper's gender
     */
    public Campers(String n, int a, String g)
    {
        name=n; age=a; gender=g;
        count++;
    }
    
    public Campers(Scanner cin)
    {
        name=cin.next();
        age=cin.nextInt();
        gender=cin.next();
        count++;
    }
    public String toString()
	{
	return " Name: "+name+"\n"+
           " Age: "+ age +"\n"+
		   " Gender: "+gender+"\n";
    }
	
    public String getName() {return name;}
    public int getAge() {return age;}
    public String getGender() {return gender;} 

    public int compareTo(Object y)
    {
        if(y instanceof Campers)
        {
            Campers c=(Campers)y;
            return name.compareTo(c.getName());
            /*
			if( name < f.getName ) return -1;
			if( name == f.getName() ) return 0;
			if( name > f.getName() ) return 1;
            */
        }
        else 
        {
			System.out.println("Error - this person does not exist!");
			System.exit(0);
			return 0;
		}
    }
 }