package binary.tree.test;

public class TestC {

    public static void main(String args[]) {{
        EggVoice mAnotherOpinion = new EggVoice();
            System.out.println("Спор начат...");
            mAnotherOpinion.start();

            for(int i = 0; i < 5; i++) {
//                try{

//                    int k = (int) MyExchanger.exchanger2.exchange(0);
//                    Saver.map2.get(0);
                    System.out.println("курица! = ");
//                    Saver.map2.remove(0);
//                }catch(InterruptedException e){
                    System.out.println("sdvdsvds!");
//                }

                System.out.println("курица!");
            }

            if(mAnotherOpinion.isAlive()) {
                try{
                    mAnotherOpinion.join();
                }catch(InterruptedException e){}

                System.out.println("Первым появилось яйцо!");
            }
            else {
                System.out.println("Первой появилась курица!");
            }
            System.out.println("Спор закончен!");
        }
    }
}
