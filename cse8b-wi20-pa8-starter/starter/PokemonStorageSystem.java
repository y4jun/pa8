public class PokemonStorageSystem{
  private static final int MAX_BOXES = 8;
  private static final int MAX_ITEMS = 30;

  private static final String OUT_OF_BOUNDS_EXCEPTION = "Box: %d, Pos: %d";

  private List<Box<T>> storage;
  private T partyMember;

  public PokemonStorageSystem(){
    storage = new ArrayList<T>(MAX_BOXES);
    for(Box<T> x : storage){
      x = Box(MAX_ITEMS);
    }
  }

  public void setPartyMember(T partyMember){
    this.partyMember = partyMember;
  }

  public void deposit(T newPokemon) throws NoStorageSpaceException{
    for(Box<T> x : storage){
      if(deposit(newPokemon)){
        return;
      }
      else{
        throw NoStorageSpaceException;
      }
    }
  }

  public T release(int box, int pos) throws OutOfBoundsException{
    if(box > 0 && box < MAX_BOXES && pos > 0 && pos < MAX_ITEMS){
      Position x = storage.get(box).get(pos);
      Pokemon y = x.pokemon;
      x.pokemon = null;
      return y;
    }
    else{
      throw OutOfBoundsException;
      return String.format(OUT_OF_BOUNDS_EXCEPTION, box, pos);
    }
  }

  public void move(int boxFrom, int posFrom, int boxTo, int posTo)
    throws OutOfBoundsException{
      if(!(boxFrom > 0 && boxFrom < MAX_BOXES && posFrom > 0
      && posFrom < MAX_ITEMS)){
        return String.format(OUT_OF_BOUNDS_EXCEPTION, boxFrom, posFrom);
      }
      if(!(boxTo > 0 && boxTo < MAX_BOXES && posTo > 0
      && posTo < MAX_ITEMS)){
        return String.format(OUT_OF_BOUNDS_EXCEPTION, boxTo, posTo);
      }
      else{
        Pokemon x = storage.get(boxFrom).get(posFrom).pokemon;
        Pokemon xx = storage.get(boxTo).get(posTo).pokemon;
        Position y = storage.get(boxFrom).get(posFrom);
        Position yy = storage.get(boxTo).get(posTo);
        y.pokemon = x;
        yy.pokemon = xx;
      }
    }

  public String getBox(int boxNumber) throws OutOfBoundsException{
    if(!(boxNumber > 0 && boxNumber < 8)){
      return String.format(OUT_OF_BOUNDS_EXCEPTION, boxNumber, 0);
    }
    else{
      storage.get(boxNumber).toString();
    }
  }

}
