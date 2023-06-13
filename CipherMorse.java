/**Zawiera kodowanie na podstawie kodu Morse'a*/
public class CipherMorse extends Cipher{
    private final char[] literki;
    private final String[] mors;
    public CipherMorse() {
        literki= new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'w', 'v', 'x', 'y', 'z'};
        mors= new String[]{".- ", "-... ", "-.-. ", "-.. ",  ". ", "..-. ", "--. ",  ".... ", ".. ", ".--- ", "-.- ",  ".-.. ", "-- ",   "-. ",   "--- ", ".--. ", "--.- ", ".-. ", "... ", "- ", "..- ", "...- ", ".-- ", "-..- ", "-.-- ", "--.. "};
    }
    @Override
    public String encode(String s){
        StringBuilder outp= new StringBuilder();

        for(int i=0; i<s.length(); i++){
            boolean a=true;
            for(int j=0; j<this.literki.length && a;j++){
                if(s.charAt(i)==this.literki[j]||(int)s.charAt(i)==(int)this.literki[j]-32){
                    outp.append(this.mors[j]);
                    a=false;
                }
            }//sprawdza czy dany znak w stringu byl jedna z podstawowych liter
	     //i jesli nie byl nie szyfruje znaku
            if(a){outp.append(s.charAt(i));}
        }
        return outp.toString();
    }
}

