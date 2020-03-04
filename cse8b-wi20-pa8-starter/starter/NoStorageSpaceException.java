public class NoStorageSpaceException extends Exception{
  private static final String EXCEPT_MSG = "No storage left\n";

  public NoStorageSpaceException(){
    super(EXCEPT_MSG);
  }

  @Override
  public String toString(){
    System.out.println(EXCEPT_MSG);
  }


}
