package bean;

public class GoodCar {
	private int sumprice=0;
	private GoodsList  goodsList=new GoodsList();
	public int getSumprice() {
		return sumprice;
	}
	public void setSumprice(int sumprice) {
		this.sumprice = sumprice;
	}
	public GoodsList getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(GoodsList goodsList) {	
		this.goodsList = goodsList;
	}
	
}
