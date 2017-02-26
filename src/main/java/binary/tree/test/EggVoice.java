package binary.tree.test;

import java.util.concurrent.Exchanger;

public class EggVoice extends Thread {
     Exchanger exchanger23 = new Exchanger();
    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
        {
            try{
                sleep(1000);

//                Saver.map2.add("SSSSSSSSS") ;
//                int k = (int)  MyExchanger.exchanger2.exchange(1);
//                System.out.println("232323!   k = " + k);
            }catch(InterruptedException e){
                System.out.println("232323!");
            }
//
            System.out.println("яйцо!");
        }
        //Слово «яйцо» сказано 5 раз
    }
}