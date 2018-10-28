/*套餐，用建造者模式*/
public class KFCPackage {

	//定义餐品价格
	protected double price;
	//定义餐品数量
	protected int num;
	//定义套餐种类
	protected String kind;
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public  String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void printFood() {
		System.out.println(kind+"\t 单价:"+price+"\t 数量："+num);
	}
}