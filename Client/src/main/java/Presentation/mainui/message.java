package Presentation.mainui;

public class message extends Thread{
	MainFrame frame;
	boolean stop;
	MessageWindow w;
	public message(/*MainFrame frame*/MessageWindow tip){
		//this.frame=frame;
		stop=false;
		w=tip;
		
	}
	public void run(){
	
		//MessageWindow w=MessageWindow.getInstance(frame);
		//w.testThread();
		while(!stop)
		{
			w.getNewMessage();
		 try {
			this.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		System.out.println("我结束了！");
	}
	
	public void startThread(){
		this.start();		
	}
	public void stopThead(){
		this.stop=true;
	}



}

