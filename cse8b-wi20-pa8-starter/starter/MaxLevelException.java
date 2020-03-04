public class MaxLevelException extends Exception{
  private static final String EXCEPT_MSG = "%s can't be greater than level 100!\n";
  private String pokemonName;

  public MaxLevelException(String name){
    super(String.format(EXCEPT_MSG, name));
    pokemonName = name;
  }

  @Override
  public String toString(){
    return String.format(EXCEPT_MSG, pokemonName);
  }


}
