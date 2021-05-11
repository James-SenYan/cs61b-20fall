import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sen Yan
 * @create 2021-04-26-20:52
 * different algorithm to sort
 */
public class Sort {
    public static List<Integer> mergeSort(List<Integer> list){
        if (list.size() == 1){
            return list;
        }
        int mid = list.size() / 2;
        List<Integer> list1 = list.subList(0, mid);
        List<Integer> list2 = list.subList(mid, list.size());
        List<Integer> leftHalf = mergeSort(list1);
        List<Integer> rightHalf = mergeSort(list2);
        return merge(leftHalf, rightHalf);
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2){
        ArrayList<Integer> returnList = new ArrayList<>();
        while (list1.size() > 0 && list2.size() > 0){
            int p = list1.get(0);
            int q = list2.get(0);
            if (p < q){
                returnList.add(p);
                list1 = list1.subList(1, list1.size());
            }else{
                returnList.add(q);
                list2 = list2.subList(1, list2.size());
            }
        }
        if (list1.size() == 0){
            returnList.addAll(list2);
        }else{
            returnList.addAll(list1);
        }
        return returnList;
    }

    public static void main(String[] args) {
        List<Integer> mess = Arrays.asList(5, 3, 7, 4, 34, 65, 4, 34, 22, 44, 86, 2);
        System.out.println("sort the list below");
        for (Integer item : mess){
            System.out.print(item + " ");
        }
        System.out.println();
        List<Integer> after = mergeSort(mess);
        System.out.println("merged sort : ");
        for (Integer item : after){
            System.out.print(item + " ");
        }
        System.out.println("\n***************");

        List<Integer> list1 = Arrays.asList(2, 3, 3, 4, 8);
        List<Integer> list2 = Arrays.asList(1, 1, 4, 45);
        List<Integer> merge = merge(list1, list2);
        for (Integer x : merge){
            System.out.print(x + " ");
        }


    }
}
