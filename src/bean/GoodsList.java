package bean;

import java.util.ArrayList;
import java.util.List;

import bean.Good;

public class GoodsList {
	List<Good> goods=new ArrayList<Good>();
	public void addgoods(Good good) {
		goods.add(good);
	}
	public List<Good> getgoodlist() {
		return goods;
	}
	
}
