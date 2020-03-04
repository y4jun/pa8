public class Bulbasaur extends Pokemon{
  private static final String NAME       = "Bulbasaur";
  private static final String DEX_NUMBER = "001";
  private static final int INITIAL_LEVEL = 5;

  public Bulbasaur() throws MinLevelException, MaxLevelException{
    super(DEX_NUMBER,NAME,INITIAL_LEVEL);
  }

  @Override
  public int attack(){
    int[] intArr = {0,6,10};
    int random = new Random().nextInt(intArr.length);
    return intArr[random];
  }
}
