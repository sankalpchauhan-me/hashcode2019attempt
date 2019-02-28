import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main8 {

public static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}
 
		public int readInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public double readDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, readInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, readInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
 
		public long readLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public String next() {
			return readString();
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}


   class Photo{
	   int type,size;
	   String tags[]=new String[101];
	   Photo(int type,int size,String[] tags){
		   this.type=type;
		   this.size=size;
		   this.tags=tags;
	   }
   }


   
   int n;
   Photo ph[]=new Photo[100001];
   ArrayList<? extends Photo> score(int mask){
	   long hor,count=0,score=0;
	   ArrayList ans=new ArrayList();
	   for(int i=0;i<n;i++){
		   if((mask & 1<<i)==0){
			   if(ph[i].type==0){
				   ArrayList al=score(mask | 1<<i);
				    if(al!=null && !al.isEmpty()) {
				    	int sc=fin(ph[i].tags,al.get(al.size()-1).tags);
				    	if(sc+Long.parseLong(al.get(0).toString())>score){
				    		score=sc+Long.parseLong(al.get(0).toString());
				    		ans=al;
				    		ans.add(ph[i]);
				    	}
				    }
			   }
			   else{
				   if(count==1){
					   ArrayList al=score(mask | 1<<i);
					    if(al!=null && !al.isEmpty()) {
					    	int sc=fin(ph[i].tags,al.get(al.size()-1).tags);
					    	if(sc+Long.parseLong(al.get(0).toString())>score){
					    		score=sc+Long.parseLong(al.get(0).toString());
					    		ans=al;
					    		ans.add(ph[i]);
					    	}
					    }
				   }
				   else
					   count++;
			   }
		   }
	   }
	   ans.set(0, score);
	   return ans;
   }
	    public static void main(String[] args) {
	       InputReader sc = new InputReader(System.in);
	      Main8 sol =new Main8();
	       sol.n=sc.readInt();
	      for(int i=0;i<sol.n;i++){
	    	 String types=sc.readString();
	    	 int type;
	    	 if(types.equals("H"))
	    		 type=0;
	    	 else
	    		 type=1;
	    	 int num=sc.readInt();
	    	 String s[]=new String[101]; 
	    	 for(int j=0;j<num;j++){
	    		 s[j]=sc.readString();
	    	 }
	    	 sol.ph[i]=sol.new Photo(type,num,s);	    	  
	      }
	        
      }
   