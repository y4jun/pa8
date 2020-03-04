public class Charmander extends Pokemon{
  private static final String NAME       = "Charmander";
  private static final String DEX_NUMBER = "004";
  private static final int INITIAL_LEVEL = 5;
  private static final int ATT_DAMAGE = 5;


  public Charmander() throws MinLevelException, MaxLevelException{
    super(DEX_NUMBER,NAME,INITIAL_LEVEL);
  }

  @Override
  public int attack(){
    return ATT_DAMAGE;
  }
}
