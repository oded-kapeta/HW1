public class Tile {
    private int value;

    /**
     * constructor to Tile
     * @param number
     */
    public Tile(int number){
        this.value = number;
    }

    /**
     * return the integer value of the tile
     * @return
     */
    public int getTileNumber(){
        return value;
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