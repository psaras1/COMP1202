public class FizzBuzz{
	public static void main(String[] args){
		for(int i = 1;i<61;i++){
			if(i%3!=0 && i%5!=0){
				System.out.print(i); //print instead of println, so it doesn't go to new line
			}
			if(i%3==0){
				System.out.print("Fizz");
			}
			if(i%5==0){	
				System.out.print("Buzz");
			}
			System.out.println();
		}
	}
}