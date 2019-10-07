package LinearSearch;

public class KiwiJuice {
    public static void main(String[] args) {
        /*
        capacities = {14, 35, 86, 58, 25, 62}
        bottles = {6, 34, 27, 38, 9, 60}
        fromId = {1, 2, 4, 5, 3, 3, 1, 0}
        toId = {0, 1, 2, 4, 2, 5, 3, 1}
        Returns: {0, 14, 65, 35, 25, 35}
        */
        int [] capacities = new int[]{14, 35, 86, 58, 25, 62};
        int [] bottles = new int[]{6, 34, 27, 38, 9, 60};
        int [] fromId = new int[]{1, 2, 4, 5, 3, 3, 1, 0};
        int [] toId = new int[]{0, 1, 2, 4, 2, 5, 3, 1};

        bottles = thePouring(capacities, bottles, fromId, toId);

        for(int i=0; i<bottles.length; i++){
            System.out.print(String.format("%3d ",bottles[i]));
        }
    }
    public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId){

        int sum = 0;
        for (int i=0; i<fromId.length; i++){
            sum = bottles[fromId[i]]+bottles[toId[i]];
            bottles[toId[i]] = Math.min(capacities[toId[i]], sum);
            bottles[fromId[i]] = sum - bottles[toId[i]];
        }

        return bottles;
    }
}