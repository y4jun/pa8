public class Squirtle extends Pokemon{
  private static final String NAME       = "Squirtle";
  private static final String DEX_NUMBER = "007";
  private static final int INITIAL_LEVEL = 5;

  public Squirtle() throws MinLevelException, MaxLevelException{
    super(DEX_NUMBER,NAME,INITIAL_LEVEL);
  }

  @Override
  public int attack(){
    int[] intArr = {3,8};
    int random = new Random().nextInt(intArr.length);
    return intArr[random];
  }
}
