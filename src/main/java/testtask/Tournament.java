package testtask;

public class Tournament {
    public int numberOfGames(int x) {
        int count = 0;
        while (x > 1) {
            if(x % 2 == 0){
                count = count + x / 2;
                x = x / 2;
            }else{
                count = count + x / 2;
                x = x / 2 + 1;
            }
        }
        return count;
    }
}
