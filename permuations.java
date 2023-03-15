import java.lang.reflect.GenericArrayType;

public class permuations {
    static int[] values = new int[3];
    static int s;
   public static void main(String[] args) {
        values[0] = 1;
        values[1] = 2;
        values[2] = 3;
       GetPerm(values, s);
   }
   private static void GetPerm (int[] values, int s) {
       if (values.length - 1 == s) {
           for (int i = 0; i < values.length; i ++)
               System.out.print(" " + values[i]);
                System.out.println();
           return;
       }

       for (int i = s; i < values.length; i ++) {
           swap(values, s, i);
           GetPerm(values, s + 1);
           swap(values, s, i);
       }
   }
   private static void swap(int [] values, int s, int k) {
       int temp = values[s];
       values[s] = values[k];
       values[k] = temp;
   }
}
