import java.io.*;

/**
  Driver class for The Dating Game programming assignment.
  @author Jon Sorenson
*/
public class DateMain
{
  public static void main(String [] args) throws IOException
  {
    Interface d = new DateClass();
    d.set(1,27,2019,0);  // sets the date to Sunday, January 27th, 2019
    while(d.getYear()<3000)
    {
      d.tomorrow();
      // un-comment the next line to help with debugging
     // System.out.println(d);
    }
    // at this point, d represents January 1, 3000
    System.out.println(d);
  }
}