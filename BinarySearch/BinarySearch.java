public class BinarySearch implements Search {
    @Override
    public int search(int[] sortedValues, int value) {

        int start = 0, end = sortedValues.length - 1;
        int mid;
        while (true) {
            if (start > end)
                return -1;

            mid = (start + end) / 2;

            if (sortedValues[mid] == value){
                return mid;
            } else if (sortedValues[mid] > value){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }
}
