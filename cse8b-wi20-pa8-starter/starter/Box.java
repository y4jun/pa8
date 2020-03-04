import java.util.*;
public class Box<B> {
  private static final String BORDER     = "---------------------";
  private static final String DIVIDER    = "|";
  private static final String NEW_LINE   = "\n";
  private static final String EMPTY_POS  = "   ";
  private static final int MAX_ELEM_LINE = 5;
  private static final String OUT_OF_BOUNDS_EXCEPTION = "Index: %s";

  private List<Position<T>> boxElements;
  private int maxSize;

  public Box(int maxSize){
    this.maxSize = maxSize;
    boxElements = new ArrayList<T>(maxSize);
    for(int x = 0; x < maxSize; i++){
      boxElements.add(new Position(null));
    }
    //???
  }

  @Override
  public String toString() {
    int counter = 0;

    StringBuilder boxPrintout = new StringBuilder();
    boxPrintout.append(BORDER);

    // Iterate through each element, print 5 at most on a line
    for(Position<T> element : boxElements) {
        if(counter == 0) {
            boxPrintout.append(NEW_LINE);
            boxPrintout.append(DIVIDER);
        }

        // Print EMPTY_POS if the spot is free (null)
        T pokemon = element.getPokemon();
        if(element.isOpen()) {
            boxPrintout.append(EMPTY_POS);
        } else {
            boxPrintout.append(pokemon.toString());
        }
        boxPrintout.append(DIVIDER);

        counter++;

        // Used so we only have 5 elements at most on a line
        if(counter == MAX_ELEM_LINE) {
            boxPrintout.append(NEW_LINE);
            boxPrintout.append(BORDER);
            counter = 0;
        }
    }
    boxPrintout.append(NEW_LINE);

    return boxPrintout.toString();
  }

  public boolean deposit(T newPokemon){
    for(T x : boxElements){
      if(x.isopen()){
        setPokemon(newPokemon);
        //at this position??
        return true;
      }
      else{
        return false;
      }
    }
  }

  public Position<T> getPositionAtIndex(int index) throws OutOfBoundsException{
    if(index < 0 || index == maxSize){
      throw OutOfBoundsException;
      return String.format(OUT_OF_BOUNDS_EXCEPTION,index);
      //???and pass in the String constant OUT_OF_BOUNDS_EXCEPTION with the index.
    }
    else{
      return boxElements.get(index);//????the Position at index.
    }
  }
}
