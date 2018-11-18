public class Test{
    	public static void main(String[] args){
		Person per1 = new Person();		
        per1.name="Joey";		
        Person per2 = new Person();		
        per2.name="Jashua";		
        per1.country="CHINA";		
        per1.printInformation();		
        per2.printInformation();        	        
    }
}
class Person{		
    String name;		
    static String country="USA";				
    public void printInformation(){			
        System.out.println("name:"+this.name+"国籍:"+this.country);		
    }
}

