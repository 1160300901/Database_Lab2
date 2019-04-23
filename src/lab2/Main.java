package lab2;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        gen_data("data.txt");

    }

    /**
     * ����������ݣ�2s
     * @param path
     */
    public static void gen_data(String path) {
        long begin = System.currentTimeMillis();
        System.out.println("��ʼ���������");
        try {
            BufferedWriter output=new BufferedWriter(new FileWriter(path));   

            int A=0;
            String B=randomString();
//            ArrayList<Integer> listA=new ArrayList<>();
            SecureRandom random = new SecureRandom();
            for(int i=0;i<1000000;i++) {

                A=random.nextInt(1000000);
//                boolean flag=listA.contains(A);
//                while(flag) {
//                    A=random.nextInt(1000000);
//                    flag=listA.contains(A);
//                    
//                }
//                listA.add(A);
//                System.out.println(A);
                B=randomString();
                output.write(A+" "+B+"\n");
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Use Time: " + (end - begin) / 1000.0+"s");

    }

    /**
     * �������6λ�ַ���
     * Math.random��[0.0,1.0),���ڵ���0����С��1�ĸ�����ֵ
     *   0-9  .48-57
     *   A-Z 65-90 
     *   a-z 97-122
     * @return
     */
    public static String randomString() {
        String result = "";
        for (int i = 0; i < 6; i++){
            int intVal = (int) (Math.random() * 26 + 97);
            result = result + (char) intVal;
        }
        return result;
    }
    
}
