import java.util.*;
public class Pokemon{
  private static final int MAX_DAMAGE = 10;
  private static final int MAX_LEVEL  = 100;

  private String dexNumber;
  private String name;
  private int level;
  private Random random;

  public Pokemon(String dexNumber, String name, int level)
    throws MinLevelException, MaxLevelException{

      this.dexNumber = dexNumber;
      this.name = name;
      if(level < 1){
        throw new MinLevelException(name);
        this.name = name;
      }
      else if(level > 100){
        throw new MaxLevelException(name);
        this.name = name; //????
      }
      else{
        this.level = level;
      }

      Random random = new Random();
  }

  public String getName(){
    return this.name;
  }

  public int getLevel(){
    return this.level;
  }

  public Random getRandom(){
    return this.random;
  }

  @Override
  public String toString(){
    return this.dexNumber;
  }

  public int attack(){
    return(random.nextInt(MAX_DAMAGE));
  }
}
