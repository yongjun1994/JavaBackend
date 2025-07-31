package user;

public class IfTest {
   public static void main(String[] args) {
      int num = 7;
      if(num > 10){
         System.out.println("10보다 큽니다");
      }else if(10 > num && num > 3){
         System.out.println("3보다 크고 10보다 작습니다");
      }else if(num > 2 && num > 0){
         System.out.println("0보다 크고 2보다 작습니다");
      }else{
         System.out.println("0보다 작습니다");
      }
      System.out.println("출력끝");
      
   }
}
