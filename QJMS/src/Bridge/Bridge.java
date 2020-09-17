package Bridge;

 interface MediaPlayInter {

    void mediaPlay();

}




 class MPEGPlay implements  MediaPlayInter {

   @Override
   public void mediaPlay() {
       System.out.print("MPEG��ʽ��Ƶ");
       System.out.println("");
   }
}




 class RmvbPlay implements MediaPlayInter {

   @Override
   public void mediaPlay() {
       System.out.print("Rmvb��ʽ��Ƶ");
       System.out.println("");
   }
}




 class WmvPlay implements MediaPlayInter {

   @Override
   public void mediaPlay() {
       System.out.print("Wmv��ʽ��Ƶ");
       System.out.println("");
   }
}

 
 class AVIPlay implements MediaPlayInter {

	   @Override
	   public void mediaPlay() {
	       System.out.print("AVI��ʽ��Ƶ");
	       System.out.println("");
	   }
	}
 
 


 abstract class AbstractPlamForm {
   MediaPlayInter mediaPlayInter ;
   public void setMediaPlayInter(MediaPlayInter mediaPlayInter){
       this.mediaPlayInter = mediaPlayInter ;
   }
   public abstract void play();

}


 class LinuxPlamForm extends AbstractPlamForm {
   @Override
   public void play() {
       System.out.print("��ǰ����ϵͳ:Linux.��ʼ���ò�������������");
       mediaPlayInter.mediaPlay();
   }
}

 
 class UnixPlamForm extends AbstractPlamForm {

	   @Override
	   public void play() {
	       System.out.print("��ǰ����ϵͳ:Unix.��ʼ���ò�������������");
	       mediaPlayInter.mediaPlay();
	   }
	}
 
 
 
 class WindowsPlamForm extends AbstractPlamForm {
   public void play() {
       System.out.print("��ǰ����ϵͳ:Windows.��ʼ���ò�������������");
       mediaPlayInter.mediaPlay();
   }
}


public class Bridge {

   public static void main(String[] args) {
       AbstractPlamForm windows = new WindowsPlamForm();
       windows.setMediaPlayInter(new AVIPlay());
       windows.play();
       System.out.println("");
       
       
       AbstractPlamForm Unix = new UnixPlamForm();
       Unix.setMediaPlayInter(new RmvbPlay());
       Unix.play();
       System.out.println("");
       
       
       AbstractPlamForm linux = new LinuxPlamForm();
       linux.setMediaPlayInter(new WmvPlay());
       linux.play();

   }
}
