package it.example;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dpescatore
 */
public class Flattener {
  

    /**Flatten integers arrays, even nested ones. 
     * @param  toFlat  the input Object array to flat
     * @return         an array of integer flattened.
     * @throws  an exception if the input array contains different types than integer or integer arrays
     * */
    public static Integer[] flat(Object[] toFlat) throws Exception {
        List<Integer> flattenedList = recursiveFlatten(toFlat, new ArrayList<Integer>());
        return flattenedList.toArray(new Integer[flattenedList.size()]);
      }

     /**Private Flatten integers arrays, even nested ones. 
     * @param  toFlat  the input Object array to flat
     * @param  flattened a list to fill with integers as utils.
     * @return         an array of integer flattened.
     * @throws  an exception if the input array contains different types than integer or integer arrays
     * */
      private static List<Integer> recursiveFlatten(Object[] toFlat, List<Integer> flattened) throws Exception {
       for (Object element : toFlat) {
            if (element instanceof Object[]) {
                Flattener.recursiveFlatten((Object[]) element, flattened);
            } else if (element instanceof Integer) {
                flattened.add((Integer) element);
            } else {
                throw new Exception("Current element is neither an integer nor array");
            }
        }

        return flattened;

    }
}