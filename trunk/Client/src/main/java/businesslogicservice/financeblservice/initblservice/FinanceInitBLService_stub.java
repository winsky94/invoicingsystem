package businesslogicservice.financeblservice.initblservice;

import java.util.ArrayList;

import vo.BeginInfoVO;

public class FinanceInitBLService_stub implements FinanceInitBLService{

	public int initInfo(BeginInfoVO vo) {
		System.out.println("Initial stock success!");
		return 0;
	}


	public BeginInfoVO getInfo(String time) {
		System.out.println("Show beginInformation success!");
		return new BeginInfoVO();
	}


	@Override
	public int initInfo(String time, BeginInfoVO po) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getCurrentTime() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<BeginInfoVO> showAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setTime(String s) {
		// TODO Auto-generated method stub
		
	}
}
