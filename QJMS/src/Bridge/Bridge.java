package Bridge;

 interface MediaPlayInter {

    void mediaPlay();

}




 class MPEGPlay implements  MediaPlayInter {

   @Override
   public void mediaPlay() {
       System.out.print("MPEG格式视频");
       System.out.println("");
   }
}




 class RmvbPlay implements MediaPlayInter {

   @Override
   public void mediaPlay() {
       System.out.print("Rmvb格式视频");
       System.out.println("");
   }
}




 class WmvPlay implements MediaPlayInter {

   @Override
   public void mediaPlay() {
       System.out.print("Wmv格式视频");
       System.out.println("");
   }
}

 
 class AVIPlay implements MediaPlayInter {

	   @Override
	   public void mediaPlay() {
	       System.out.print("AVI格式视频");
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
       System.out.print("当前操作系统:Linux.开始调用播放器启动播放");
       mediaPlayInter.mediaPlay();
   }
}

 
 class UnixPlamForm extends AbstractPlamForm {

	   @Override
	   public void play() {
	       System.out.print("当前操作系统:Unix.开始调用播放器启动播放");
	       mediaPlayInter.mediaPlay();
	   }
	}
 
 
 
 class WindowsPlamForm extends AbstractPlamForm {
   public void play() {
       System.out.print("当前操作系统:Windows.开始调用播放器启动播放");
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
