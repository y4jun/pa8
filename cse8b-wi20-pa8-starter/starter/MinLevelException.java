public class MinLevelException extends Exception{
  private static final String EXCEPT_MSG = "%s can't be less than level 1!\n";
  private String pokemonName;

  public MinLevelException(String name){
    super(String.format(EXCEPT_MSG, name));
    pokemonName = name;
  }

  @Override
  public String toString(){
    System.out.println(String.format(EXCEPT_MSG, pokemonName));
  }


}
