package sum;

public class NewTest {


    public String reverseString(String str){

        if(str.length() == 1){
            return str;
        } else {
           String  reverse = str.charAt(str.length()-1)
                    +reverseString(str.substring(0,str.length()-1));
            return reverse;
        }
    }

    public static void main(String a[]){
        NewTest srr = new NewTest();
        System.out.println("Result: "+srr.reverseString("Java2novice"));
    }
}
