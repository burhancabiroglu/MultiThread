package multiThread;

public class Demo {

    public static int[][] result;
    public static void main(String[] args){



        MultiThread  test= new MultiThread("matris1.txt","matris2.txt");


        /*for (int i=0;i<test.getM1().length;i++){
          MultiThread  m= new MultiThread("matris1.txt","matris2.txt",i);
          m.start();
        }*/

        test.Compute();

        MultiThread.printMatris(Demo.result);



    }
}
