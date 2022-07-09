package thread;

import java.util.Scanner;
public class GetNumberThread extends Thread {
public String number;
private static String[] digit = new String[]
{"zero","one","two","three","four","five","six","seven","eight","nine"};
public void run() {
Scanner s = new Scanner(System.in);
System.out.println("Enter number with more than 4 digits: ");
number = s.next();
for(char c : number.toCharArray()) {
if(c<48||c>57) {
System.out.println("Invalid inputs");
break;
}
System.out.print(digit[((int)c-48)]+" ");
}
System.out.print("\n");
}
}


package thread;

import java.util.Scanner;
public class GetStringThread extends Thread {
public String string;
public static String vowels = "aeiou";
public void run() {
Scanner s = new Scanner(System.in);
System.out.println("Enter a string: ");
string = s.next();
int x = 0;
for(char c : string.toCharArray())
for(char ch : vowels.toCharArray())
if(c==ch) x++;
System.out.print(x+" vowels present\n");
}
}


package thread;

public class InputThreads {
public static void main(String[] args) throws InterruptedException {
GetStringThread getStringThread;
GetNumberThread getNumberThread;
getNumberThread = new GetNumberThread();
getStringThread = new GetStringThread();
//getNumberThread.start();
getStringThread.start();
Thread.sleep(100);
//getStringThread.start();
getNumberThread.start();
}
}

