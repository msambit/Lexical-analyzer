/*Lexical Analyzer-Sambit-M*/
import java.util.*;  
import java.io.*;
class LexicalAnalyzer
{
	
	public static void main(String args[])
	{  
	    Scanner sc=new Scanner(System.in);
		
		//Input variables
		int i;
		int CSymbol=2;             //Accounts for Symbols
		int CLiteral=2;            //Accounts for Literals
		boolean b=false;
		String input;
		String output="\n";
		String TERMINATOR_STRING = ",,";
		String commentstart=" ";
		String commentend=" ";
		
		Hashtable<Integer,String> Keyword=new Hashtable<Integer,String>();  //Keyword Hashtable
  
		Keyword.put(1,"int");  
		Keyword.put(2,"float");  
		Keyword.put(3,"double");  
		Keyword.put(4,"char");
		Keyword.put(5,"void");
		
		Hashtable<Integer,String> Operator=new Hashtable<Integer,String>(); //Operator Hashtable 
		  
		Operator.put(1,"["); 
		Operator.put(2,"]");		
		Operator.put(3,"{");  
		Operator.put(4,"}"); 
		Operator.put(5,"(");
		Operator.put(6,")");
		Operator.put(7,"+");
		Operator.put(8,"-");
		Operator.put(9,"*");
		Operator.put(10,"/");
		Operator.put(11,"%");
		Operator.put(12,"=");		
		
				
		Hashtable<Integer,String> Pref=new Hashtable<Integer,String>();     //Pref Hashtable
		  
		Pref.put(1,"main");  
		Pref.put(2,"scanf");  
		Pref.put(3,"printf");  
		Pref.put(4,"sqrt"); 
				
		Hashtable<Integer,String> SpecialSymbol=new Hashtable<Integer,String>();  //Pref SpecialSymbol
		  
		SpecialSymbol.put(1,":");  
		SpecialSymbol.put(2,";");  
		SpecialSymbol.put(3,",");  
		SpecialSymbol.put(4,"\""); 
				
		Hashtable<Integer,String> Symbol=new Hashtable<Integer,String>(); 		 //Symbol Hashtable
				
		Hashtable<Integer,String> Literal=new Hashtable<Integer,String>();  	 //Literal Hashtable
		
		
        System.out.println("Enter your String:(Enter \",,\" to end input string)\n");
        
        
        while (!(input = sc.nextLine()).equals(TERMINATOR_STRING))
		{	
		
		StringTokenizer st=new StringTokenizer(input,"=,+,-,*,/,[,],{,},(,),%,,,;,:,\",<,>,^,?, ,",true);
		
		while(st.hasMoreTokens())
		{
			String s=st.nextToken();
			
			b=true;
			
			if(s.equals("/"))
			{
				
				String x= st.nextToken();
				
				if(x.equals("*"))
				{
					for(i=0;i<100;i++)
				    {
						 String sx=st.nextToken();
						 if(sx.equals("*"))
						 {
							 String v=st.nextToken();							 
							 if(v.equals("/"))
							 break;
						 }
                     			 
				    }
					b=false;
					continue;				
				}
				else
				{
				  output+="Operator#10";
				  s=x;
				}
			}
			
			if(s==" ")
			{
				b=false;
			}
			if(s=="\n")
			{
				b=false;
			}
			
			
			
			
			if(b)
			for(i=1;i<=Keyword.size();i++)
			{
			if(s.equals(Keyword.get(i)))
			{
				output+="Keyword#"+i+" ";
				b=false;
				break;
			}
			}
			
			if(b)
			for(i=1;i<=Operator.size();i++)
			{
			if(s.equals(Operator.get(i)))
			{
				output+="Operator#"+i+" ";
				b=false;
				break;
			}
			}
			
			if(b)
			for(i=1;i<=Pref.size();i++)
			{
			if(s.equals(Pref.get(i)))
			{
				output+="Pref#"+i+" ";
				b=false;
				break;
			}
			}
			for(i=1;i<=SpecialSymbol.size();i++)
			{
			if(s.equals(SpecialSymbol.get(i)))
			{
				output+="SpecialSymbol#"+i+" ";
				b=false;
				break;
			}
			}
			
			if(b)
			if(Character.isLetter(s.charAt(0)))
			{
            if(Symbol.isEmpty())
            {
				Symbol.put(1,s);
				output+="Symbol#"+1+" ";
				b=false;
				
				
			}  				
			else if(!Symbol.isEmpty())
			{
				for(i=1;i<=Symbol.size();i++)
				{
				if(s.equals(Symbol.get(i)))
				{
					output+="Symbol#"+i+" ";
					b=false;
				    break;
				}
				}
				if(i>Symbol.size())
				{
					Symbol.put(CSymbol,s);
				    output+="Symbol#"+CSymbol+" ";
					CSymbol++;
					b=false;
				    
				}				
			}
			}
			if(b)
			if(Character.isDigit(s.charAt(0)))
			{
            if(Literal.isEmpty())
            {
				Literal.put(1,s);
				output+="Literal#"+1+" ";
				b=false;
				
				
			}  				
			else if(!Literal.isEmpty())
			{
				for(i=1;i<=Literal.size();i++)
				{
				if(s.equals(Literal.get(i)))
				{
					output+="Literal#"+i+" ";
					b=false;
				    break;
				}
				}
				if(i>Literal.size())
				{
					Literal.put(CLiteral,s);
				    output+="Literal#"+CLiteral+" ";
					CLiteral++;
					b=false;
				    
				}				
			}
			}
		     commentstart=s;	
		}
		
		output+="\n\n";
		}
		System.out.println("Output:\n");
		System.out.println("----------------------------------------------------------------------------------------------------");
	    System.out.println(output);
		System.out.println("----------------------------------------------------------------------------------------------------");

		
		System.out.println();
        System.out.println("Keyword Hashtable");
        for(i=1;i<=Keyword.size();i++)
		{
			System.out.println( +i+ " : "+Keyword.get(i));
		}
		System.out.println();
        System.out.println("Operator Hashtable");
        for(i=1;i<=Operator.size();i++)
		{
			System.out.println( +i+ " : "+Operator.get(i));
		}
		System.out.println();
        System.out.println("Pref Hashtable");
        for(i=1;i<=Pref.size();i++)
		{
			System.out.println( +i+ " : "+Pref.get(i));
		}
		System.out.println();
        System.out.println("SpecialSymbol Hashtable");
        for(i=1;i<=SpecialSymbol.size();i++)
		{
			System.out.println( +i+ " : "+SpecialSymbol.get(i));
		}
		System.out.println();
        System.out.println("Symbol Hashtable");
        for(i=1;i<=Symbol.size();i++)
		{
			System.out.println( +i+ " : "+Symbol.get(i));
		}
		System.out.println();
        System.out.println("Literal Hashtable");
        for(i=1;i<=Literal.size();i++)
		{
			System.out.println( +i+ " : "+Literal.get(i));
		}		
	}  
} 