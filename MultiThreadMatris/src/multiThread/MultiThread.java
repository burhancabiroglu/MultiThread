package multiThread;

import java.io.*;

public class MultiThread extends Thread {


    private String s1name;
    private String s2name;
    private int[][] m1;
    private int[][] m2;
    private int[][] result;
    int[][] a;
    int satir=0;



    public MultiThread(String s1,String s2){
        m1=fileInputToMatrix(s1);
        s1name=s1;
        s2name=s2;
        System.out.println("");
        m2=fileInputToMatrix(s2);

        System.out.println("");
    }
    public MultiThread(String s1,String s2,int satir){
        m1=fileInputToMatrix(s1);
        s1name=s1;
        s2name=s2;
        System.out.println("");
        this.satir=satir;





        m2=fileInputToMatrix(s2);

        System.out.println("");




        
        if(Demo.result==null){
            System.out.println("içi ilk kez dolduruluyor");
            System.out.println();
            System.out.println("1. matris ;\n");
            printMatris(m1);

            Demo.result=new int[m1.length][m2[0].length];
            System.out.println("2. matris ;\n");
            printMatris(m2);
        }
        else{
            System.out.println("içi dolu");
            System.out.println();
        }

    }



    private  int[][] fileInputToMatrix(String sFile) {

        try
        {
            BufferedReader f=new BufferedReader(new FileReader(sFile));
            String deneme;

            int satir=0;
            int sutun=0;
            while ((deneme=f.readLine())!=null){

                satir++;

                String[] say=deneme.split(" ");
                sutun=say.length;


            }
            BufferedReader bf=new BufferedReader(new FileReader(sFile));
            int[][] m= new int[satir][sutun];
            String s;
            int i=0;
            while ((s=bf.readLine())!=null){

                String[] spt=s.split(" ");
                for(int j=0;j<spt.length;j++){
                    m[i][j]=Integer.parseInt(spt[j]);

                }
                i++;
            }

            result=m;


        }
        catch (Exception e){
            System.out.println("bir hata meydana geldi");
        }

        return result;

    }





    @Override
    public synchronized void run(){


        if(m1[0].length==m2.length){



            RowMultiplication(satir);


        }
        else{
            System.out.println("Verilen matrislerin çarpımı hatalı olur.Zira satır ve sütun sayısı uymuyor...");
        }




    }

    public void Compute(){

        for(int i=0;i<m1.length;i++){
            MultiThread g1=new MultiThread(s1name,s2name,i);
            g1.start();

        }


    }
/*    public synchronized void  ComputeMultiplaticon(){



        for(int s=0;s<m1.length;s++){
            System.out.println(s+"compute içindeki satır numarası");



        }

        printMatris(a);
    }

*/
    public static void printMatris(int[][] result){
        for (int i = 0; i < result.length; i++) {


            for (int j = 0; j < result[0].length; j++) {


                System.out.print(String.format("%3s",result[i][j]));


            }

            System.out.println();


        }
    }
    public void copyrow(){
        for (int i=0;i<m1.length;i++){
            Demo.result[satir][i]=result[satir][i];
        }
    }

    public synchronized void  RowMultiplication(int n) {




            for(int k=0;k<m2[0].length;k++){
                for(int j=0;j<m2.length;j++){
                    Demo.result[n][k]+=m1[n][j]*m2[j][k];
                }
            }




    }
    public int[][] getResult(){
        return result;
    }



    public int[][] getM1() {
        return m1;
    }

    public void setM1(int[][] m1) {
        this.m1 = m1;
    }

    public int[][] getM2() {
        return m2;
    }

    public void setM2(int[][] m2) {
        this.m2 = m2;
    }
}
