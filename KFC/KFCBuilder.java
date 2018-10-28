public abstract class KFCBuilder {

	protected final KfcPackage kfcpackage = new KfcPackage();
	
	//套餐的种类
	public void setKind(String kind) {
		this.kfcpackage.setKind(kind);
	}
	
	//套餐的价格
	public void setPrice(double price) {
		this.kfcpackage.setPrice(price);
	}
	
	//套餐的数量
	public void setNum(int num) {
		this.kfcpackage.setNum(num);
	}
	
	//构造一个完整的套餐
	public abstract KfcPackage getKfcPackage();
}