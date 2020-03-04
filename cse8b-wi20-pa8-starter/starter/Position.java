public class Position<T> {
  private T pokemon;

  public Position(T pokemon){
    this.pokemon = pokemon;
  }

  public T getPokemon(){
    return pokemon;
  }

  public void setPokemon(T newPokemon){
    pokemon = newPokemon;
  }

  public boolean isOpen(){
    if(pokemon == null){
      return false;
    }
    else{
      return true;
    }
  }
}
