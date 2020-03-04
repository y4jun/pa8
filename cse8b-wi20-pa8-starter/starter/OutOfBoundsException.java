public class OutOfBoundsException extends Exception{
  private static final String EXCEPT_MSG = "Out of bounds: %s\n";
  private String errorLocation;

  public OutOfBoundsException(String loc){
    errorLocation = super(EXCEPT_MSG, loc);
  }

  @Override
  public String toString(){
    System.out.println(String.format(EXCEPT_MSG, errorLocation));
  }


}
