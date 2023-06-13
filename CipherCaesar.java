/**Zawiera kodowanie na podstawie szyfru cezara**/
public class CipherCaesar extends Cipher{
private final int przesuniecie;
    public CipherCaesar() {
        this.przesuniecie=4;
    }
    @Override
    public String encode(String s){
        StringBuilder outp= new StringBuilder();
    for(int i=0; i<s.length(); i++){
        int a=(int)s.charAt(i);
        if(Character.isLetter(s.charAt(i))){
            a+=this.przesuniecie;
            if((Character.isLowerCase(s.charAt(i))&&a>122)||(Character.isUpperCase(s.charAt(i))&&a>90)){
                a-=26;
            }
        }
        outp.append((char)a);
    }

        return outp.toString();
    }
}
