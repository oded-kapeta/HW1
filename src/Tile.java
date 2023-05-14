public class Tile {
    String tileNumber;

    public Tile(String number){
        this.tileNumber = number;
    }

    public String getTile(){
        return tileNumber;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tile)) {
            return false;
        }
        Tile tile = (Tile) other;
        return value == tile.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}