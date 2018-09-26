package bean;

import bean.Good;

public class addgoodcar {
	private GoodCar goodCar=new GoodCar();
	private GoodsList goodList=goodCar.getGoodsList();
	public void addgood(Good good){
		goodList.getgoodlist().add(good);
	}
	public GoodsList getgoodlist() {
		return goodList;
	}
	public int getsumprice(GoodsList goodList) {
		int price=0,sumprice=0;
		for(int i = 0 ; i < goodList.getgoodlist().size() ; i++) {
			price=goodCar.getGoodsList().getgoodlist().get(i).getPrice()*goodCar.getGoodsList().getgoodlist().get(i).getNumber();
			sumprice+=price;
		}
		goodCar.setSumprice(sumprice);
		return goodCar.getSumprice();
	}
}
/*for(int i = 0 ; i < goods.size() ; i++) {
	if(goods.get(i).getName().equals(good.getName())){
		good.setNumber(good.getNumber()+1);
		goodCar.setSumprice(good.getPrice()*good.getNumber());
	}else {
		goods.add(good);
		good.setNumber(1);
		goodCar.setSumprice(good.getPrice());
	}*/