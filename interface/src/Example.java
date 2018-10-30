interface A {
    double PI=3.14;
    void doubleArea();
}
interface B{
    void setColor(String c);
}
interface C extends A,B {
    void volume();
}
abstract class tmp implements C{
    public void doubleArea(){};
    public void setColor(String c){};
    public void volume(){};
}
class Cylinder extends tmp{
    private double PI=3.14;
    private double radius;
    private double height;
    private String color;
    public void doubleArea(double radius){
        this.radius=radius;
        System.out.println("radius is "+(radius*PI));
    }
    public void setColor(String c){
        this.color=c;
        System.out.println("color is "+color);
    }
    public void volume(double radius,double height){
        this.height=height;
        this.radius=radius;
        System.out.println("volume is "+(radius*height*PI));	}
}
class Example{
    public static void main(String []args){
        Cylinder cyl1=new Cylinder();
        cyl1.doubleArea(3.00);
        cyl1.setColor("原谅绿");
        cyl1.volume(3.00,3.00);
    }
}
