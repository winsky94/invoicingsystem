package Presentation.mainui;

class message extends Thread{
	MainFrame frame;
	boolean stop;
	public message(/*MainFrame frame*/){
		//this.frame=frame;
		stop=false;
		
	}
	public void run(){
	
		//MessageWindow w=MessageWindow.getInstance(frame);
		//w.testThread();
		while(!stop)
		{System.out.println("哈哈哈");
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

public static void main(String[] args) {
	message m=new message();
	m.startThread();
	
}

}

