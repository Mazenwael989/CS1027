//Mazen Baioumy
import java.util.Arrays;
import java.util.Stack;

public class MakeFractal { 
private final static int NOT_FOUND=-1;
private String alphaNumeric;
private String computedFractal;
private String initialAxion;
private Integer index,numSymbols,n,size; 
private String[] symbols;
private String[] rules;
private Integer charsPerLine=60;

public MakeFractal(String[] symbols,Integer numSymbols,
                   String initialAxion,String[] rules,Integer n) {
this.numSymbols=numSymbols;
this.symbols=new String[this.numSymbols];
this.rules=new String[this.numSymbols];
for(int i=0;i<this.numSymbols;i++) {
   this.symbols[i]=symbols[i];
   this.rules[i]=rules[i];
   }
this.computedFractal=initialAxion; 
this.n=n;
}

public String buildFractal() {
System.out.println("In buildFractal\n");
System.out.println("Symbol Table");
for(int i=0;i<numSymbols;i++) {
    System.out.println("symbol(" + i + ")=" + symbols[i] + 
                       "   rule(" + i +")=" + rules[i] + "\n");
}

StackADT<String> sStack = new LinkedStack<String>();

//This method uses a stack to perform the iterations to build the final complex fractal string
for (int it = 1; it<= this.n; it++) {
	
	for (int j = 0; j<this.computedFractal.length(); j++) {
		String q = this.computedFractal.substring(j, j+1);
		
		for (int i = 0; i <symbols.length; i++) {
			if (q.equals(symbols[i])) {
				sStack.push(rules[i]);
				break;
			
			}
			
			else if (i == (symbols.length - 1)) {
				sStack.push(q);
			
			}	
		}
	}
	this.computedFractal = "";
	
	while (!sStack.isEmpty()) {
		String pop = sStack.pop();
		computedFractal = pop + computedFractal; 
	} 
}

return computedFractal;
}


// Return the index of the character in symbols 
// or -1 if it is not there
public Integer in(String alphaNumeric,String[] symbols) {
for(int i=0;i<symbols.length;i++)
    {
    if(alphaNumeric.equals(symbols[i])) return(i);
    }
return(NOT_FOUND);
}

// Pretty print the computed fractal
public void prettyPrint() {
String str=computedFractal;
size=str.length();
System.out.println("\nPretty print the final fractal (60 characters per line)\n");
System.out.println("-------------------------------------------------------\n");
while(charsPerLine < size) {
    // print out substrings of str of length charsPerLine
    System.out.println(str.substring(0,charsPerLine-1));
    str=str.substring(charsPerLine,size);
    size=str.length();
} 
// print last bit of str
System.out.println(str);
}

} // MakeFractal
