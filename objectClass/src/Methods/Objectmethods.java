package Methods;

public class Objectmethods
{

  public String toString()
  {
    return "Objectmethods []";
  }

  public static void main(String[] args)
  {

   ToString toString = new ToString(10, "string");
   System.out.println(toString);
  }

}

class ToString
{
  @Override
  public String toString()
  {
    return "ToString [val=" + val + ", name=" + name + "]";
  }
  int val;
  String name;
  ToString(int val, String name)  
  {
    this.val = val;
    this.name = name;
  }
}
