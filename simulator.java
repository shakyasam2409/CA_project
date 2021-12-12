package module1;

import java.io.*;
import java.util.*;

public class simulator {
	
	int cl;
	int B;
	static String[] tag;
	String[][] data;
	
	public simulator(int cl, int B) {
		this.cl=cl;
		this.B=B;
		String[] tag1=new String[cl];
		String[][] data1=new String[cl][B];
		tag=tag1;
		data=data1;
	}
	
	String read(String inst) {
		String mes="";
		int x=((Integer.parseInt(inst,2))/4)%cl;
		if (tag[x]==null) {
			tag[x]=inst;
			return null;
		}
		else if (tag[x].contentEquals(inst)) {
			for(int i=0;i<B;i++) {
				if(data[x][i]!=null)
					mes.concat(data[x][i]);
			}
			return mes;
		}
		else {
			tag[x]=inst;
			return null;
		}
	}
	
	void write(String inst, String val) {
		int x=((Integer.parseInt(inst,2))/4)%cl;
		if (tag[x]==null) {
			tag[x]=inst;
			int n=32/B;
			for(int i=0;i<B;i++) {
				data[x][i]=val.substring(i*n,(i*n)+n);
			}
		}
		else if (tag[x].contentEquals(inst)){
			int n=32/B;
			for(int i=0;i<B;i++) {
				data[x][i]=val.substring(i*n,(i*n)+n);
			}			
		}
		else {					
			tag[x]=inst;
			int n=32/B;
			for(int i=0;i<B;i++) {
				data[x][i]=val.substring(i*n,(i*n)+n);
			}		
		}	
	}		

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

        ArrayList<String> arr3
        = new ArrayList<String>();

	    File file = new File("C:\\Users\\anant\\Desktop\\binary.txt");
	    @SuppressWarnings("resource")
		Scanner in = new Scanner(file);
	    while (in.hasNextLine()) {
	    	arr3.add(in.nextLine().replaceAll("\\s", ""));
	    }
	    
	    int a=arr3.size();
	    
		String[] binary=new String[a];
		for(int g=0;g<a;g++) {
			binary[g]=arr3.get(g);
		}		

		@SuppressWarnings("resource")
		Scanner inn=new Scanner(System.in);
		int size=inn.nextInt();
		int line=inn.nextInt();
		int block=inn.nextInt();
		int hit=inn.nextInt();
		int pen=inn.nextInt();
		int acc=inn.nextInt();
		int cl1=line;
		int B1=(size/line)/block; 
		
		simulator cache=new simulator(cl1, B1);	
	    
	    String[] memory=new String[1024];
	    
	    for(int g=0;g<a;g++) {
	    	memory[g*4]=binary[g];
	    }

	    for(int i=a*4;i<1023;i=i+4) {
	    	memory[i]="00000000000000000000000000000101";
	    }
	    
	    int[] pc=new int[a];
	    
	    for(int g=0;g<a;g++) {
	    	pc[g]=g*4;
	    }
	    
	    int r0=0,r1=0,r2=0,r3=0,r4=0,r5=0,r6=0,r7=0,r8=0,r9=0,r10=0,r11=0,r12=0,r13=0,r14=0,r15=0;
	    int r16=0,r17=0,r18=0,r19=0,r20=0,r21=0,r22=0,r23=0,r24=0,r25=0,r26=0,r27=0,r28=0,r29=0,r30=0,r31=0;
	    
	    Dictionary<String, Integer> register = new Hashtable<String, Integer>();
	    
	    register.put("r0", r0);
	    register.put("r1", r1);
	    register.put("r2", r2);
	    register.put("r3", r3);
	    register.put("r4", r4);
	    register.put("r5", r5);
	    register.put("r6", r6);
	    register.put("r7", r7);
	    register.put("r8", r8);
	    register.put("r9", r9);
	    register.put("r10", r10);
	    register.put("r11", r11);
	    register.put("r12", r12);
	    register.put("r13", r13);
	    register.put("r14", r14);
	    register.put("r15", r15);
	    register.put("r16", r16);
	    register.put("r17", r17);
	    register.put("r18", r18);
	    register.put("r19", r19);
	    register.put("r20", r20);
	    register.put("r21", r21);
	    register.put("r22", r22);
	    register.put("r23", r23);
	    register.put("r24", r24);
	    register.put("r25", r25);
	    register.put("r26", r26);
	    register.put("r27", r27);
	    register.put("r28", r28);
	    register.put("r29", r29);	    
	    register.put("r30", r30);
	    register.put("r31", r31);
	    
	    int i=0;
	    int cycles=0;
	    while(i<a) {
	    	cycles=cycles+3;
	    	if (memory[pc[i]].substring(25,30).equals("00000")==true) { //lw
	    		if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
	    			String yes1=cache.read(Integer.toBinaryString(pc[i]));
	    			cycles=cycles+hit;
		    		int s=register.get("r".concat(Integer.toString(Integer.parseInt(yes1.substring(12,17),2))))+Integer.parseInt(yes1.substring(0,12),2);
		    		if (s%4!=0) {
		    			s=s*4;
		    		}
		    		if(cache.read(Integer.toBinaryString(s))==memory[s]) {
		    			String yes2=cache.read(Integer.toBinaryString(s));
		    			cycles=cycles+hit;
		    			register.put("r".concat(Integer.toString(Integer.parseInt(yes1.substring(20,25),2))), Integer.parseInt(yes2,2));
		    		}
		    		else if(cache.read(Integer.toBinaryString(s))!=memory[s]) {
		    			register.put("r".concat(Integer.toString(Integer.parseInt(yes1.substring(20,25),2))), Integer.parseInt(memory[s],2));
			    		cycles=cycles+hit+pen;
		    			int size5=32-memory[s].length();
				    	if(size5!=0) {
				    		for(int k=0;k<size5;k++) {
				    			memory[s]="0".concat(memory[s]);
				    		}
				    	}
		    			cache.write(Integer.toBinaryString(s), memory[s]);
		    		}
	    		}	
	    		else {
		    		cycles=cycles+hit+pen;
	    			int s=register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))+Integer.parseInt(memory[pc[i]].substring(0,12),2);
		    		if (s%4!=0) {
		    			s=s*4;
		    		}
		    		if(cache.read(Integer.toBinaryString(s))==memory[s]) {
		    			String yes2=cache.read(Integer.toBinaryString(s));
		    			cycles=cycles+hit;
		    			register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), Integer.parseInt(yes2,2));
		    		}
		    		else if(cache.read(Integer.toBinaryString(s))!=memory[s]) {
		    			register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), Integer.parseInt(memory[s],2));
			    		cycles=cycles+hit+pen;
		    			int size5=32-memory[s].length();
				    	if(size5!=0) {
				    		for(int k=0;k<size5;k++) {
				    			memory[s]="0".concat(memory[s]);
				    		}
				    	}
		    			cache.write(Integer.toBinaryString(s), memory[s]);
		    		}
		    		cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
	    		}
	    	}
	    	
	    	else if (memory[pc[i]].substring(17,20).equals("000")==true && memory[pc[i]].substring(0,5).equals("00000")==true && memory[pc[i]].substring(25).equals("0110011")==true) {
	    		
	    		if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
	    			String yes=cache.read(Integer.toBinaryString(pc[i]));
	    			cycles=cycles+hit;
	    			register.put("r".concat(Integer.toString(Integer.parseInt(yes.substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2))))+register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(7,12),2)))));
	    		}
	    		else {
	    			register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))+register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));
	    			cycles=cycles+hit+pen;
	    			cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
	    		}
//	    		System.out.println("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))));
	    	} 
	    	
//	    		System.out.println(register.get("r2"));
	    		
	    	else if (memory[pc[i]].substring(17,20).equals("100")==true && memory[pc[i]].substring(25).equals("1100011")==true) { //blt
	    		if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
	    			String yes=cache.read(Integer.toBinaryString(pc[i]));
	    			cycles=cycles+hit;
		    		if (register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2))))<register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(7,12),2))))) {
		    			String temp=yes.substring(1,7).concat(yes.substring(20,24));
		    			temp=yes.substring(24,25).concat(temp);
		    			temp=yes.substring(0,1).concat(temp);
		    			i=i+(Integer.parseInt(temp, 2)/4);
		    		}	    			
	    		}
	    		else {
	    			if (register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))<register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2))))) {
		    			String temp=memory[pc[i]].substring(1,7).concat(memory[pc[i]].substring(20,24));
		    			temp=memory[pc[i]].substring(24,25).concat(temp);
		    			temp=memory[pc[i]].substring(0,1).concat(temp);
		    			i=i+(Integer.parseInt(temp, 2)/4);
		    		}
	    			cycles=cycles+hit+pen;
	    			cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
	    		}
	    	} 
	    	
	    	else if (memory[pc[i]].substring(25).equals("1101111")==true) { //jal
	    		if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
	    			String yes=cache.read(Integer.toBinaryString(pc[i]));
	    			cycles=cycles+hit;
		    		register.put("r".concat(Integer.toString(Integer.parseInt(yes.substring(20,25),2))), pc[i]+4);
	    			String temp=yes.substring(11,12).concat(yes.substring(1,11));
	    			temp=yes.substring(12,20).concat(temp);
	    			temp=yes.substring(0,1).concat(temp);
	    			i=i+(Integer.parseInt(temp, 2)/4);	    			
	    		}
	    		else {
	    			register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), pc[i]+4);
		    			String temp=memory[pc[i]].substring(11,12).concat(memory[pc[i]].substring(1,11));
		    			temp=memory[pc[i]].substring(12,20).concat(temp);
		    			temp=memory[pc[i]].substring(0,1).concat(temp);
		    			i=i+(Integer.parseInt(temp, 2)/4);
		    			cycles=cycles+hit+pen;
		    			cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
	    		}	
	    	} 	   	
	    	
	    	else if (memory[pc[i]].substring(17,20).equals("111")==true) { //and
	    		if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
	    			String yes=cache.read(Integer.toBinaryString(pc[i]));
	    			cycles=cycles+hit;
	    			register.put("r".concat(Integer.toString(Integer.parseInt(yes.substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2))))&register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(7,12),2)))));
	    		}	
	    		else {	    		
	    			register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))&register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));
	    			cycles=cycles+hit+pen;
	    			cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
	    		}
	    	} 	
	    	
	    	else if (memory[pc[i]].substring(17,20).equals("001")==true) { //sll
	    		if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
	    			String yes=cache.read(Integer.toBinaryString(pc[i]));
	    			cycles=cycles+hit;
	    			register.put("r".concat(Integer.toString(Integer.parseInt(yes.substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2))))<<register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(7,12),2)))));
	    		}
	    		else {   		
	    			register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))<<register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));
	    			cycles=cycles+hit+pen;
	    			cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
	    		}
	    	} 	
	    	
//	      subtract

	        if (memory[pc[i]].substring(0,7).equals("0100000") && memory[pc[i]].substring(17,20).equals("000") && memory[pc[i]].substring(25,32).equals("0110011")) {

	            if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
	                String yes=cache.read(Integer.toBinaryString(pc[i]));
	                cycles=cycles+hit;
	                register.put("r".concat(Integer.toString(Integer.parseInt(yes.substring(20,25),2))),
	                        register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2)))) -
	                                register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(7,12),2)))));
	            }
	            else {
	                register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20, 25), 2))),
	                        register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12, 17), 2)))) -
	                                register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7, 12), 2)))));
	                cycles=cycles+hit+pen;
	                cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
	            }
//		    		System.out.println("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))));
	        }

//	        jalr

	        else if (memory[pc[i]].substring(17,20).equals("000") && memory[pc[i]].substring(25,32).equals("1100111")) {

	            if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
	                String yes=cache.read(Integer.toBinaryString(pc[i]));
	                cycles=cycles+hit;
	                int temp = pc[i] + 4;

	                int rs1 = register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,16),2))));

	                int offset = Integer.parseInt(yes.substring(0,12),2);

	                pc[i] = (rs1 + offset)&~1;

	                register.put("r".concat(Integer.toString(Integer.parseInt(yes.substring(20,24),2))), temp);
	            }

	            else {
	                int temp = pc[i] + 4;

	                int rs1 = register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,16),2))));

	                int offset = Integer.parseInt(memory[pc[i]].substring(0,12),2);

	                pc[i] = (rs1 + offset)&~1;

	                register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,24),2))), temp);
	                cycles=cycles+hit+pen;
	                cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
	            }
	        }


//	        bne

	        else if (memory[pc[i]].substring(17,20).equals("001") && memory[pc[i]].substring(25,32).equals("1100011")) {
	            if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
	                String yes=cache.read(Integer.toBinaryString(pc[i]));
	                cycles=cycles+hit;
	                if (register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2)))) != register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(7,12),2))))) {
	                    String temp=yes.substring(1,7).concat(yes.substring(20,24));
	                    temp=yes.substring(24,25).concat(temp);
	                    temp=yes.substring(0,1).concat(temp);
	                    i=i+(Integer.parseInt(temp, 2)/4);
	                }
	            }
	            else {
	                if (register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2)))) != register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2))))) {
	                    String temp=memory[pc[i]].substring(1,7).concat(memory[pc[i]].substring(20,24));
	                    temp=memory[pc[i]].substring(24,25).concat(temp);
	                    temp=memory[pc[i]].substring(0,1).concat(temp);
	                    i=i+(Integer.parseInt(temp, 2)/4);
	                }
	                cycles=cycles+hit+pen;
	                cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
	            }
	        }

//	        lui

	        else if (memory[pc[i]].substring(25).equals("0110111")) {

	            if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
	                String yes=cache.read(Integer.toBinaryString(pc[i]));
	                cycles=cycles+hit;
	                register.put("r".concat(Integer.toString(Integer.parseInt(yes.substring(20,25),2))),
	                        (Integer.parseInt(yes.substring(0,20), 2)));
	            }
	            else {
	                register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))),
	                        (Integer.parseInt(memory[pc[i]].substring(0,20), 2)));
	                cycles=cycles+hit+pen;

	                cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
	            }
	        }
	        
//	        xor

	        else if (memory[pc[i]].substring(0,7).equals("0000000") && memory[pc[i]].substring(17,20).equals("100") && memory[pc[i]].substring(25,32).equals("0110011")) {
	            if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
	                String yes=cache.read(Integer.toBinaryString(pc[i]));
	                cycles=cycles+hit;
	                register.put("r".concat(Integer.toString(Integer.parseInt(yes.substring(20,25),2))),
	                        register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2)))) ^
	                                register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(7,12),2)))));
	            }
	            else {
	                register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20, 25), 2))),
	                        register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12, 17), 2)))) ^
	                                register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7, 12), 2)))));
	                cycles=cycles+hit+pen;
	                cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
	            }
	        }
	    	
	        else if (memory[pc[i]].substring(25,30).equals("01000")==true&&memory[pc[i]].substring(17,20).equals("010")==true) { //sw
                int q= register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))+Integer.parseInt(memory[pc[i]].substring(0,7).concat(memory[pc[i]].substring(20,25)),2);
                if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
                    String yes1=cache.read(Integer.toBinaryString(pc[i]));
                    cycles=cycles+hit;
                    int s=register.get("r".concat(Integer.toString(Integer.parseInt(yes1.substring(7,12),2))));
                    if (s%4!=0) {
                        s=s*4;
                    }
                    if(cache.read(Integer.toBinaryString(s))==Integer.toString(Integer.parseInt(yes1.substring(7,12),2))) {
                        String yes2=cache.read(Integer.toBinaryString(s));
                        cycles=cycles+hit+acc;
                        cache.write(Integer.toBinaryString(s), memory[q]);
                        memory[register.get("r".concat(Integer.toString(Integer.parseInt(yes1.substring(12,17),2))))+Integer.parseInt(yes1.substring(0,7).concat(yes1.substring(20,25)),2)]
                        =Integer.toBinaryString(register.get("r".concat(Integer.toString(Integer.parseInt(yes2.substring(7,12),2)))));
                    }
                    else if(cache.read(Integer.toBinaryString(s))!=Integer.toString(Integer.parseInt(yes1.substring(7,12),2))) {
                        cache.write(Integer.toBinaryString(s), memory[q]);
                        memory[register.get("r".concat(Integer.toString(Integer.parseInt(yes1.substring(12,17),2))))+Integer.parseInt(yes1.substring(0,7).concat(yes1.substring(20,25)),2)]
                                =Integer.toBinaryString(register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));

                        cycles=cycles+hit+pen+acc;
                        int size5=32-memory[s].length();
                        if(size5!=0) {
                            for(int k=0;k<size5;k++) {
                                memory[s]="0".concat(memory[s]);
                            }
                        }
                        cache.write(Integer.toBinaryString(s), memory[s]);
                    }
                }
                else {
                	cycles=cycles+hit+pen;
                    int s=register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2))));
                    if (s%4!=0) {
                        s=s*4;
                    }
                    if(cache.read(Integer.toBinaryString(s))==Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2))) {
                        String yes2=cache.read(Integer.toBinaryString(s));
                        cycles=cycles+hit+acc;
                        cache.write(Integer.toBinaryString(s), memory[q]);
                        memory[register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))+Integer.parseInt(memory[pc[i]].substring(0,7).concat(memory[pc[i]].substring(20,25)),2)]
                                =Integer.toBinaryString(register.get("r".concat(Integer.toString(Integer.parseInt(yes2.substring(7,12),2)))));
                    }
                    else if(cache.read(Integer.toBinaryString(s))!=Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2))) {

                        memory[register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))+Integer.parseInt(memory[pc[i]].substring(0,7).concat(memory[pc[i]].substring(20,25)),2)]
                                =Integer.toBinaryString(register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));
                        s=register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))+
                                Integer.parseInt(memory[pc[i]].substring(0,7).concat(memory[pc[i]].substring(20,25)),2);
                        cycles=cycles+hit+pen+acc;
                        int size5=32-memory[s].length();
                        if(size5!=0) {
                            for(int k=0;k<size5;k++) {

                                memory[s]="0".concat(memory[s]);
                            }
                        }
                        cache.write(Integer.toBinaryString(s), memory[q]);
                    }
                    cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
                }


            }

            else if (memory[pc[i]].substring(17,20).equals("110")==true && memory[pc[i]].substring(0,5).equals("00000")==true && memory[pc[i]].substring(25).equals("0110011")==true) { //OR

                if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
                    String yes=cache.read(Integer.toBinaryString(pc[i]));
                    cycles=cycles+hit;
                    register.put("r".concat(Integer.toString(Integer.parseInt(yes.substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2))))| register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(7,12),2)))));
                }
                else {
                    register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2)))) | register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));
                    cycles=cycles+hit+pen;
                    cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
                }

            }

            else if (memory[pc[i]].substring(17,20).equals("101")==true && memory[pc[i]].substring(0,5).equals("01000")==true && memory[pc[i]].substring(25).equals("0110011")==true) { //SRA

                if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
                    String yes=cache.read(Integer.toBinaryString(pc[i]));
                    cycles=cycles+hit;
                    register.put("r".concat(Integer.toString(Integer.parseInt(yes.substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2))))>>register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(7,12),2)))));
                }
                else {
                    register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))>>register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));
                    cycles=cycles+hit+pen;
                    cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
                }

               }

            else if (memory[pc[i]].substring(17,20).equals("000")==true && memory[pc[i]].substring(25).equals("1100011")==true) { //BEQ
                if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
                    String yes=cache.read(Integer.toBinaryString(pc[i]));
                    cycles=cycles+hit;
                    if (register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2))))==register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(7,12),2))))) {
                        String temp=yes.substring(1,7).concat(yes.substring(20,24));
                        temp=yes.substring(24,25).concat(temp);
                        temp=yes.substring(0,1).concat(temp);
                        i=i+(Integer.parseInt(temp, 2)/4);
                    }
                }
                else {
                    if (register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))==register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2))))) {
                        String temp=memory[pc[i]].substring(1,7).concat(memory[pc[i]].substring(20,24));
                        temp=memory[pc[i]].substring(24,25).concat(temp);
                        temp=memory[pc[i]].substring(0,1).concat(temp);
                        i=i+(Integer.parseInt(temp, 2)/4);
                    }
                    cycles=cycles+hit+pen;
                    cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
                }
            }


            else if (memory[pc[i]].substring(17,20).equals("101")==true && memory[pc[i]].substring(25).equals("1100011")==true) { //BGE
                if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
                    String yes=cache.read(Integer.toBinaryString(pc[i]));
                    cycles=cycles+hit;
                    if (register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2))))>register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(7,12),2))))) {
                        String temp=yes.substring(1,7).concat(yes.substring(20,24));
                        temp=yes.substring(24,25).concat(temp);
                        temp=yes.substring(0,1).concat(temp);
                        i=i+(Integer.parseInt(temp, 2)/4);
                    }
                }
                else {
                    if (register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))>register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2))))) {
                        String temp=memory[pc[i]].substring(1,7).concat(memory[pc[i]].substring(20,24));
                        temp=memory[pc[i]].substring(24,25).concat(temp);
                        temp=memory[pc[i]].substring(0,1).concat(temp);
                        i=i+(Integer.parseInt(temp, 2)/4);
                    }
                    cycles=cycles+hit+pen;
                    cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);
                }
            }

            else if ( memory[pc[i]].substring(17,20).equals("000")==true && memory[pc[i]].substring(25).equals("0010011")==true) { //ADDI

                if(cache.read(Integer.toBinaryString(pc[i]))==memory[pc[i]]) {
                    String yes=cache.read(Integer.toBinaryString(pc[i]));
                    cycles=cycles+hit;
                    register.put("r".concat(Integer.toString(Integer.parseInt(yes.substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(yes.substring(12,17),2))))+ Integer.parseInt(yes.substring(0,12),2) );

                }
                else {
                    register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))+Integer.parseInt(memory[pc[i]].substring(0,12),2));
                    cycles=cycles+hit+pen;
                    cache.write(Integer.toBinaryString(pc[i]), memory[pc[i]]);

                }
           
            }  	
	    	
	    	i++;
	    } 
	    
//	    System.out.println(register.get("r3"));
	    
	    for(int f=0;f<1023;f=f+4) {
	    	System.out.println(memory[f]);
	    } 	    
	    
	    System.out.println(cycles); 
	    
	    for(int h=0;h<cl1;h++) {
	    	for(int l=0;l<B1;l++) {
	    		System.out.println(cache.data[h][l]);
	    	}
	    } 
	}
}
