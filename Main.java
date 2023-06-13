
public class Main {

	public static void main(String[] args){

Cipher morse=new CipherMorse();
Cipher cezar=new CipherCaesar();
String s1="aA sS dddd ,.903 xyz";
String s2="aA+dfghjkl 90 xyz";
String s3=morse.encode(s1);
String s4=cezar.encode(s2);
System.out.println(s1+s3+s2+s4);

	}
}
