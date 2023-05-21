public class Tile {
    private int value;
    /*
    HI,unfortunately our code is not solving as much games we want to , we check our functions and they are correct,
    the only problem is in function result in State Class, in the switch case when we put "break" in all the cases
    the code start "go crazy" and solve games that you not given , its like he random some games and solve them.
    right now there is no "break" in the DOWN case so its solve 3 games and get to unsolvable in game 4,
    it will be nice from you if you can consider our functions that we write , we sat on this work for a long time
    and did our best , we even go to a lot of office hours but we failed to fix this specific problem, thank you.
     */

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