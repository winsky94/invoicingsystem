package Presentation.mainui;

class message extends Thread{
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
			System.out.println("哈哈哈");
		 try {
			this.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	
	}
	
	public void startThread(){
		this.start();		
	}
	public void stopThead(){
		this.stop=true;
	}



}
