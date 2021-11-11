package module1;

import java.io.*;
import java.util.*;

public class assembler {

	static int no(String str,
            char ch, int N)
{
int occur = 0;
for (int i = 0; i < str.length(); i++)
{
if (str.charAt(i) == ch)
{
    occur += 1;
}
if (occur == N)
    return i;
}
return -1;
}	
	
    static int is(
            String s1, String s2)
        {
            int M = s1.length();
            int N = s2.length();
            for (int i = 0; i <= N - M; i++) {
                int j;
                for (j = 0; j < M; j++)
                    if (s2.charAt(i + j)
                        != s1.charAt(j))
                        break;
     
                if (j == M)
                    return i;
            }
     
            return -1;
        }	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String[] arr=new String[17];
		String[] binary=new String[17];
	    File file = new File("C:\\Users\\anant\\Desktop\\assembly_code.txt");
	    @SuppressWarnings("resource")
		Scanner in = new Scanner(file);
	    int a=0;
	    int e=0;
	    while (in.hasNextLine()) {
	    	arr[a]=in.nextLine();
	    	arr[a]=arr[a].replaceAll("\\s", "");
	    	a++;
	    }
	    
	    
	    
	    for(int i=0;i<17;i++) {
	    	if(arr[i].contains("lw")==true) {
	    		int x=no(arr[i], 'r', 1);
	    	    for(int p=0;p<arr[i].length();p++) {
	    			if(arr[i].charAt(p)==',') {	    		
	    				binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,p)));
	    			}
	    	    }	
	    		int size2=5-binary[i].length();
		    	if(size2!=0) {
		    		for(int k=0;k<size2;k++) {
		    			binary[i]="0".concat(binary[i]);
		    		}
		    	}
	    		binary[i]=binary[i].concat("0000011");
	    		binary[i]="010".concat(binary[i]);  
	    		int y=no(arr[i], 'r', 2);
	    	    binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,arr[i].length()-1))).concat(binary[i]);
        		if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,arr[i].length()-1))).length()!=0) {
        			for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,arr[i].length()-1))).length();k++) {
        				binary[i]="0".concat(binary[i]);
        			}
        		}
	    	    for(int k=0;k<arr[i].length();k++) {
	    			if(arr[i].charAt(k)==',') {
	    				binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(k+1,y-1))).concat(binary[i]);
	    			}
	    		}	
	    	    int size1=32-binary[i].length();
        	    if (size1!=0) {
        	    	for(int k=0;k<size1;k++) {
        	    		binary[i]="0".concat(binary[i]);
        	    	}
        	    } 
	    	}
	    	
	    	else if(arr[i].contains("add")==true && arr[i].contains("addi")==false) {
	    		int x=no(arr[i], 'r', 1);
	    		int y=no(arr[i], 'r', 2);
	    		int u=no(arr[i], ',', 1);
	    		int v=no(arr[i], ',', 2);	    		
	    		binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,u)));
	    		int size2=5-binary[i].length();
		    	if(size2!=0) {
		    		for(int k=0;k<size2;k++) {
		    			binary[i]="0".concat(binary[i]);
		    		}
		    	}
	    		binary[i]=binary[i].concat("0110011");
	    		binary[i]="000".concat(binary[i]);	    		
	    	    binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).concat(binary[i]);
        		if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length()!=0) {
        			for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length();k++) {
        				binary[i]="0".concat(binary[i]);
        			}
        		}
	    		int z=no(arr[i], 'r', 3);
	    	    binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).concat(binary[i]);
        		if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length()!=0) {
        			for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length();k++) {
        				binary[i]="0".concat(binary[i]);
        			}
        		}
	    	    binary[i]="0000000".concat(binary[i]);
	    	}
	    	
	    	else if(arr[i].contains("blt")==true) {
	    		int x=no(arr[i], 'r', 1);
	    		int y=no(arr[i], 'r', 2);
	    		int u=no(arr[i], ',', 1);
	    		int v=no(arr[i], ',', 2);
	    		binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,u)));
	    		int size2=5-binary[i].length();
		    	if(size2!=0) {
		    		for(int k=0;k<size2;k++) {
		    			binary[i]="0".concat(binary[i]);
		    		}
		    	}
	    		binary[i]=binary[i].concat("100");
	    	    binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).concat(binary[i]);
        		if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length()!=0) {
        			for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length();k++) {
        				binary[i]="0".concat(binary[i]);
        			}
        		}
        		String[] arr2=new String[1];
    				for(int k=0;k<17;k++) {
    					int res=is(arr[i].substring(v+1), arr[k].substring(0,no(arr[k], 'r', 1)));			    	
    			        if(res!=-1) {
    			        	arr2[0]=Integer.toBinaryString((k-(i+1))*4);
    			        	int size4=12-arr2[0].length();
    			        	if(size4!=0) {
    			        		for(int n=0;n<size4;n++) {
    			        			arr2[0]="0".concat(arr2[0]);
    			        		}
    			        	}     			        	
    			        }   					
    				}
		        	binary[i]=arr2[0].substring(2,8).concat(binary[i]);
		        	binary[i]=arr2[0].substring(0,1).concat(binary[i]);
		        	binary[i]=binary[i].concat(arr2[0].substring(8));
		        	binary[i]=binary[i].concat(arr2[0].substring(1,2));
		        	binary[i]=binary[i].concat("1100011"); 		        	 
	    	}	    	
	    	
	    	else if(arr[i].contains("jal")==true && arr[i].contains("jalrr")==false) {
	    		int x=no(arr[i], 'r', 1);
	    		int u=no(arr[i], ',', 1);
	    	    for(int p=0;p<arr[i].length();p++) {
	    			if(arr[i].charAt(p)==',') {	  	    		
	    				binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,p)));
	    			}
	    	    }	
	    		int size2=5-binary[i].length();
		    	if(size2!=0) {
		    		for(int k=0;k<size2;k++) {
		    			binary[i]="0".concat(binary[i]);
		    		}
		    	}
		    	String[] arr2=new String[1];
    				for(int k=0;k<17;k++) {
    					int res=is(arr[i].substring(u+1), arr[k].substring(0,no(arr[k], 'r', 1)));		    	
    			        if(res!=-1) {
    			        	arr2[0]=Integer.toBinaryString((k-(i+1))*4);
    			        	int size4=20-arr2[0].length();
    			        	if(size4!=0) {
    			        		for(int n=0;n<size4;n++) {
    			        			arr2[0]="0".concat(arr2[0]);
    			        		}
    			        	}    			            
    			        }   					
    				}	    
		        	binary[i]=arr2[0].substring(1,9).concat(binary[i]);
		        	binary[i]=arr2[0].substring(9,10).concat(binary[i]);
		        	binary[i]=arr2[0].substring(10).concat(binary[i]);
		        	binary[i]=arr2[0].substring(0,1).concat(binary[i]);	
	    		binary[i]=binary[i].concat("1101111");
	    	} 	    		    	
	    	
	    	else if(arr[i].contains("and")==true) {
	    		int x=no(arr[i], 'r', 1);
	    		int y=no(arr[i], 'r', 2);
	    		int z=no(arr[i], 'r', 3);
	    		binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,y)));
	    		int size2=5-binary[i].length();
		    	if(size2!=0) {
		    		for(int k=0;k<size2;k++) {
		    			binary[i]="0".concat(binary[i]);
		    		}
		    	}
	    		binary[i]=binary[i].concat("0110011");
	    		binary[i]="111".concat(binary[i]);
	    	    binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).concat(binary[i]);
        		if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length()!=0) {
        			for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length();k++) {
        				binary[i]="0".concat(binary[i]);
        			}
        		}
	    	    binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).concat(binary[i]);
        		if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length()!=0) {
        			for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length();k++) {
        				binary[i]="0".concat(binary[i]);
        			}
        		}
	    	    binary[i]="0000000".concat(binary[i]);
	    	}
	    	
	    	else if(arr[i].contains("sll")==true) {
	    		int x=no(arr[i], 'r', 1);
	    		int y=no(arr[i], 'r', 2);
	    		int z=no(arr[i], 'r', 3);
	    		binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,y)));
	    		int size2=5-binary[i].length();
		    	if(size2!=0) {
		    		for(int k=0;k<size2;k++) {
		    			binary[i]="0".concat(binary[i]);
		    		}
		    	}
	    		binary[i]=binary[i].concat("0110011");
	    		binary[i]="001".concat(binary[i]);
	    	    binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).concat(binary[i]);
        		if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length()!=0) {
        			for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length();k++) {
        				binary[i]="0".concat(binary[i]);
        			}
        		}	    		
	    	    binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).concat(binary[i]);
        		if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length()!=0) {
        			for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length();k++) {
        				binary[i]="0".concat(binary[i]);
        			}
        		}
	    	    binary[i]="0000000".concat(binary[i]);
	    	}
	    	
	    	else if(arr[i].contains("jalrr")==true) {
                int x=no(arr[i], 'r', 2);
           		int y=no(arr[i], 'r', 3);
	    		int u=no(arr[i], ',', 1);
	    		int v=no(arr[i], ',', 2);
                binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,u)));
                int size2=5-binary[i].length();
                if(size2!=0) {
                    for(int k=0;k<size2;k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }
                binary[i]=binary[i].concat("1100111");
                binary[i]="000".concat(binary[i]);

        
                binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).concat(binary[i]);
                if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length()!=0) {
                    for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length();k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }

                String[] arr2=new String[1];
                for(int k=0;k<17;k++) {
                    int res=is(arr[i].substring(v+1), arr[k].substring(0,no(arr[k], 'r', 1)));
                    if(res!=-1) {
                        arr2[0]=Integer.toBinaryString((k-(i+1))*4);
                        int size4=12-arr2[0].length();
                        if(size4!=0) {
                            for(int n=0;n<size4;n++) {
                                arr2[0]="0".concat(arr2[0]);
                            }
                        }
                    }
                }

                binary[i] = arr2[0].concat(binary[i]);

   
            } 

            else if(arr[i].contains("sub")==true) {
                int x=no(arr[i], 'r', 1);
	    		int y=no(arr[i], 'r', 2);
	    		int z=no(arr[i], 'r', 3);
                binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,y)));
                int size2=5-binary[i].length();
                if(size2!=0) {
                    for(int k=0;k<size2;k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }
                binary[i]=binary[i].concat("0110011");
                binary[i]="000".concat(binary[i]);
              
                binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).concat(binary[i]);
                if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length()!=0) {
                    for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length();k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }
                
                binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).concat(binary[i]);
                if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length()!=0) {
                    for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length();k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }
                binary[i]="0100000".concat(binary[i]);
            }

            else if(arr[i].contains("bne")==true)   {
                int x=no(arr[i], 'r', 1);
	    		int y=no(arr[i], 'r', 2);
	    		int u=no(arr[i], ',', 1);
	    		int v=no(arr[i], ',', 2);
                binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,u)));
                int size2=5-binary[i].length();
                if(size2!=0) {
                    for(int k=0;k<size2;k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }
                binary[i]=binary[i].concat("001");
           
                binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).concat(binary[i]);
                if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length()!=0) {
                    for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length();k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }
                String[] arr2=new String[1];
                for(int k=0;k<17;k++) {
                    int res=is(arr[i].substring(v+1), arr[k].substring(0,no(arr[k], 'r', 1)));
                    if(res!=-1) {
                        arr2[0]=Integer.toBinaryString((k-(i+1))*4);
                        int size4=12-arr2[0].length();
                        if(size4!=0) {
                            for(int n=0;n<size4;n++) {
                                arr2[0]="0".concat(arr2[0]);
                            }
                        }
                    }
                }
                binary[i]=arr2[0].substring(2,8).concat(binary[i]);
                binary[i]=arr2[0].substring(0,1).concat(binary[i]);
                binary[i]=binary[i].concat(arr2[0].substring(8));
                binary[i]=binary[i].concat(arr2[0].substring(1,2));
                binary[i]=binary[i].concat("1100011");

            }

            else if(arr[i].contains("lui")==true) {
                int x=no(arr[i], 'r', 1);
                int u=no(arr[i], ',', 1);
                binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,u)));
                int size2=5-binary[i].length();
                if(size2!=0) {
                    for(int k=0;k<size2;k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }

                binary[i]=binary[i].concat("0110111");

                for(int k=0;k<arr[i].length();k++) {
                    if(arr[i].charAt(k)==',') {
                        binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(k+1,arr[i].length()))).concat(binary[i]);
                    }
                }
                int size1=32-binary[i].length();
                if (size1!=0) {
                    for(int k=0;k<size1;k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }
            }


            else if(arr[i].contains("xor")==true) {
                int x=no(arr[i], 'r', 2);
	    		int y=no(arr[i], 'r', 3);
	    		int z=no(arr[i], 'r', 4);
                binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,y)));
                int size2=5-binary[i].length();
                if(size2!=0) {
                    for(int k=0;k<size2;k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }
                binary[i]=binary[i].concat("0110011");
                binary[i]="100".concat(binary[i]);
             
                binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).concat(binary[i]);
                if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length()!=0) {
                    for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length();k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }
                
                binary[i]=Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).concat(binary[i]);
                if(5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length()!=0) {
                    for(int k=0;k<5-Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length();k++) {
                        binary[i]="0".concat(binary[i]);
                    }
                }
                binary[i]="0000000".concat(binary[i]);
            }	    	
	    	
            else if (arr[i].contains("sw") == true) {
                int x = no(arr[i], 'r', 1);
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(x + 1, no(arr[i], ',', 1))));
                int size2 = 5 - binary[i].length();
                if (size2 != 0) {
                    for (int k = 0; k < size2; k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                int y = no(arr[i], 'r', 2);
                String rs1 = Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,arr[i].length()-1)));
                ;
                int s3 = 5 - rs1.length();
                for (int m = 0; m < s3; m++) {
                    rs1 = "0" + rs1;
                }
                binary[i] = binary[i].concat(rs1);
                binary[i] = binary[i] + "010";

                int off = no(arr[i], ',', 1);
                int off1 = no(arr[i], '(', 1);

                String offset = Integer.toBinaryString(Integer.parseInt(arr[i].substring(off + 1, off1)));

                int size3 = 12 - offset.length();
                if (size3 != 0) {
                    for (int k = 0; k < size3; k++) {
                        offset = "0".concat(offset);
                    }
                }

                binary[i] = offset.substring(0, 8).concat(binary[i]);
                binary[i] = binary[i].concat(offset.substring(8));
                binary[i] = binary[i].concat("0100011");
            }	    	
	    	
            else if (arr[i].contains("or") == true) {
                int x = no(arr[i], 'r', 2);
	    		int y=no(arr[i], 'r', 3);
	    		int z = no(arr[i], 'r', 4);
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,y)));
                int size2 = 5 - binary[i].length();
                if (size2 != 0) {
                    for (int k = 0; k < size2; k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                binary[i] = binary[i].concat("0110011");
                binary[i] = "110".concat(binary[i]);
        
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).concat(binary[i]);
                if (5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length() != 0) {
                    for (int k = 0; k < 5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length(); k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).concat(binary[i]);
                if (5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length() != 0) {
                    for (int k = 0; k < 5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length(); k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                binary[i] = "0000000".concat(binary[i]);
            } 
            
            else if (arr[i].contains("sra") == true) {
                int x = no(arr[i], 'r', 2);
                int y = no(arr[i], 'r', 3);
                int z = no(arr[i], 'r', 4);
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,y)));
                int size2 = 5 - binary[i].length();
                if (size2 != 0) {
                    for (int k = 0; k < size2; k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                binary[i] = binary[i].concat("0110011");
                binary[i] = "101".concat(binary[i]);
                
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).concat(binary[i]);
                if (5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length() != 0) {
                    for (int k = 0; k < 5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,z))).length(); k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).concat(binary[i]);
                if (5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length() != 0) {
                    for (int k = 0; k < 5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(z+1))).length(); k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                binary[i] = "0100000".concat(binary[i]);
            }	 
	    	
            else if (arr[i].contains("beq") == true) {
                int x = no(arr[i], 'r', 1);
	    		int y=no(arr[i], 'r', 2);
	    		int u=no(arr[i], ',', 1);
	    		int v=no(arr[i], ',', 2);
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,u)));
                int size2 = 5 - binary[i].length();
                if (size2 != 0) {
                    for (int k = 0; k < size2; k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                binary[i] = binary[i].concat("000");
            
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).concat(binary[i]);
                if (5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length() != 0) {
                    for (int k = 0; k < 5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length(); k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                String[] arr2 = new String[1];
                for (int k = 0; k < 17; k++) {
                    int res = is(arr[i].substring(v+1), arr[k].substring(0,no(arr[k], 'r', 1)));
                    if (res != -1) {
                        arr2[0] = Integer.toBinaryString((k - (i + 1)) * 4);
                        int size4 = 12 - arr2[0].length();
                        if (size4 != 0) {
                            for (int n = 0; n < size4; n++) {
                                arr2[0] = "0".concat(arr2[0]);
                            }
                        }
                    }
                }
                binary[i] = arr2[0].substring(2, 8).concat(binary[i]);
                binary[i] = arr2[0].substring(0, 1).concat(binary[i]);
                binary[i] = binary[i].concat(arr2[0].substring(8));
                binary[i] = binary[i].concat(arr2[0].substring(1, 2));
                binary[i] = binary[i].concat("1100011");

            } 
            
            else if (arr[i].contains("bge") == true) {
                int x = no(arr[i], 'r', 1);
                int y=no(arr[i], 'r', 2);
	    		int u=no(arr[i], ',', 1);
	    		int v=no(arr[i], ',', 2);
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,u)));
                int size2 = 5 - binary[i].length();
                if (size2 != 0) {
                    for (int k = 0; k < size2; k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                binary[i] = binary[i].concat("101");
        
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).concat(binary[i]);
                if (5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length() != 0) {
                    for (int k = 0; k < 5 - Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v))).length(); k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                String[] arr2 = new String[1];
                for (int k = 0; k < 17; k++) {
                    int res = is(arr[i].substring(v + 1), arr[k].substring(0,no(arr[k], 'r', 1)));
                    if (res != -1) {
                        arr2[0] = Integer.toBinaryString((k - (i + 1)) * 4);
                        int size4 = 12 - arr2[0].length();
                        if (size4 != 0) {
                            for (int n = 0; n < size4; n++) {
                                arr2[0] = "0".concat(arr2[0]);
                            }
                        }
                    }
                }
                binary[i] = arr2[0].substring(2, 8).concat(binary[i]);
                binary[i] = arr2[0].substring(0, 1).concat(binary[i]);
                binary[i] = binary[i].concat(arr2[0].substring(8));
                binary[i] = binary[i].concat(arr2[0].substring(1, 2));
                binary[i] = binary[i].concat("1100011");

            }	 
	    	
            else if (arr[i].contains("addi") == true) {
                int x = no(arr[i], 'r', 1);
	    		int y=no(arr[i], 'r', 2);
	    		int u=no(arr[i], ',', 1);
	    		int v=no(arr[i], ',', 2);
                binary[i] = Integer.toBinaryString(Integer.parseInt(arr[i].substring(x+1,u)));
                int size2 = 5 - binary[i].length();
                if (size2 != 0) {
                    for (int k = 0; k < size2; k++) {
                        binary[i] = "0".concat(binary[i]);
                    }
                }
                binary[i] = binary[i].concat("0010011");
                binary[i] = "000".concat(binary[i]);

         
                String Rs1 = Integer.toBinaryString(Integer.parseInt(arr[i].substring(y+1,v)));
                binary[i] = Rs1.concat(binary[i]);

                int imd_ind = no(arr[i], ',', 2);
                String imm = arr[i].substring(imd_ind + 1);
                binary[i] = Integer.toBinaryString(Integer.parseInt(imm)).concat(binary[i]);
	    	    int size1=32-binary[i].length();
        	    if (size1!=0) {
        	    	for(int k=0;k<size1;k++) {
        	    		binary[i]="0".concat(binary[i]);
        	    	}
        	    }
            }	    	
	    	
	    } 
	    
	    
	    String[] memory=new String[1024];
	    
	    memory[0]=binary[0];
	    memory[4]=binary[1];
	    memory[8]=binary[2];
	    memory[12]=binary[3];
	    memory[16]=binary[4];
	    memory[20]=binary[5];
	    memory[24]=binary[6];
	    memory[28]=binary[7];
	    memory[32]=binary[8];
	    memory[36]=binary[9];
	    memory[40]=binary[10];
	    memory[44]=binary[11];
	    memory[48]=binary[12];
	    memory[52]=binary[13];
	    memory[56]=binary[14];
	    memory[60]=binary[15];
	    memory[64]=binary[16];
	    
	    for(int i=68;i<1023;i=i+4) {
	    	memory[i]="00000000000000000000000000000101";
	    }
	    
	    int[] pc=new int[68];
	    
	    pc[0]=0;
	    pc[1]=4;
	    pc[2]=8;
	    pc[3]=12;
	    pc[4]=16;
	    pc[5]=20;
	    pc[6]=24;
	    pc[7]=28;
	    pc[8]=32;
	    pc[9]=36;
	    pc[10]=40;
	    pc[11]=44;
	    pc[12]=48;
	    pc[13]=52;
	    pc[14]=56;
	    pc[15]=60;
	    pc[16]=64;
	    
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
	    while(i<17) {
	    	if (memory[pc[i]].substring(25,30).equals("00000")==true) {
	    		int s=register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))+Integer.parseInt(memory[pc[i]].substring(0,12),2);
	    		if (s%4!=0) {
	    			s=s*4;
	    		}
	    		register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), Integer.parseInt(memory[s],2));
	    	} 
//	    System.out.println("r".concat(Integer.toString(Integer.parseInt(memory[pc[0]].substring(20,25),2))));
	    	
	    	else if (memory[pc[i]].substring(17,20).equals("000")==true && memory[pc[i]].substring(0,5).equals("00000")==true && memory[pc[i]].substring(25).equals("0110011")==true) {
	    		register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))+register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));
//	    		System.out.println("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))));
	    	} 
	    	
//	    		System.out.println(register.get("r2"));
	    		
	    	else if (memory[pc[i]].substring(17,20).equals("100")==true && memory[pc[i]].substring(25).equals("1100011")==true) {
	    		if (register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))<register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2))))) {
	    			String temp=memory[pc[i]].substring(1,7).concat(memory[pc[i]].substring(20,24));
	    			temp=memory[pc[i]].substring(24,25).concat(temp);
	    			temp=memory[pc[i]].substring(0,1).concat(temp);
	    			i=i+(Integer.parseInt(temp, 2)/4);
	    		}
	    	} 
	    	
	    	else if (memory[pc[i]].substring(25).equals("1101111")==true) {
	    		register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), pc[i]+4);
	    			String temp=memory[pc[i]].substring(11,12).concat(memory[pc[i]].substring(1,11));
	    			temp=memory[pc[i]].substring(12,20).concat(temp);
	    			temp=memory[pc[i]].substring(0,1).concat(temp);
	    			i=i+(Integer.parseInt(temp, 2)/4);
	    	} 	   	
	    	
	    	else if (memory[pc[i]].substring(17,20).equals("111")==true) {
	    		register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))&register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));
	    	} 	
	    	
	    	else if (memory[pc[i]].substring(17,20).equals("001")==true) {
	    		register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))<<register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));
	    	} 	
	    	
	    	else if (memory[pc[i]].substring(0,7).equals("0100000") && memory[pc[i]].substring(17,20).equals("000") && memory[pc[i]].substring(25,32).equals("0110011")) {
            register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20, 25), 2))),
                    register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12, 17), 2)))) -
                            register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7, 12), 2)))));

        }

	    	else if (memory[pc[i]].substring(17,20).equals("000") && memory[pc[i]].substring(25,32).equals("1100111")) {

                int temp = pc[i] + 4;

                int rs1 = register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,16),2))));

                int offset = Integer.parseInt(memory[pc[i]].substring(0,12),2);

                pc[i] = (rs1 + offset)&~1;

                register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,24),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,16),2))))+register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,11),2)))));
            }

	    	else if (memory[pc[i]].substring(17,20).equals("001") && memory[pc[i]].substring(25,32).equals("1100011")) {
                if (register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2)))) != register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2))))) {
                    String temp=memory[pc[i]].substring(1,7).concat(memory[pc[i]].substring(20,25));
                    temp=memory[pc[i]].substring(24,25).concat(temp);
                    temp=memory[pc[i]].substring(0,1).concat(temp);
                    i=i+(Integer.parseInt(temp, 2)/4);
                }
            }

	    	else if (memory[pc[i]].substring(25).equals("0110111")) {
                register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), (Integer.parseInt(memory[pc[i]].substring(0,20), 2) << 12));
            }

	    	else if (memory[pc[i]].substring(0,7).equals("0000000") && memory[pc[i]].substring(17,20).equals("100") && memory[pc[i]].substring(25,32).equals("0110011")) {
                register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20, 25), 2))),
                        register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12, 17), 2)))) ^
                                register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7, 12), 2)))));
            }	    
	    	
	    	else if (memory[pc[i]].substring(17,20).equals("000")==true && memory[pc[i]].substring(25).equals("1100011")==true) {
	    		if (register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))<register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2))))) {
	    			String temp=memory[pc[i]].substring(1,7).concat(memory[pc[i]].substring(20,24));
	    			temp=memory[pc[i]].substring(24,25).concat(temp);
	    			temp=memory[pc[i]].substring(0,1).concat(temp);
	    			i=i+(Integer.parseInt(temp, 2)/4);
	    		}
	    	} 
	    	
	    	else if (memory[pc[i]].substring(17,20).equals("101")==true && memory[pc[i]].substring(25).equals("1100011")==true) {
	    		if (register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))<register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2))))) {
	    			String temp=memory[pc[i]].substring(1,7).concat(memory[pc[i]].substring(20,24));
	    			temp=memory[pc[i]].substring(24,25).concat(temp);
	    			temp=memory[pc[i]].substring(0,1).concat(temp);
	    			i=i+(Integer.parseInt(temp, 2)/4);
	    		}
	    	} 	    
	    	
	    	else if (memory[pc[i]].substring(17,20).equals("111") && memory[pc[i]].substring(0,7).equals("0000000") && memory[pc[i]].substring(25).equals("0110011")) {
	    		register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))|register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));
	    	} 	
	    	
	    	else if (memory[pc[i]].substring(17,20).equals("101") && memory[pc[i]].substring(0,7).equals("0100000") && memory[pc[i]].substring(25).equals("0110011")) {
	    		register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))>>register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(7,12),2)))));
	    	}	    	
	    	
	    	else if (memory[pc[i]].substring(17,20).equals("000") && memory[pc[i]].substring(25).equals("0010011")) {
	    		register.put("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(20,25),2))), register.get("r".concat(Integer.toString(Integer.parseInt(memory[pc[i]].substring(12,17),2))))+Integer.parseInt(memory[pc[i]].substring(0,12),2));
	    	}	  
	    	
	    	
	    	
	    	i++;
	    	cycles=i*5;
	    } 
	    
//	    System.out.println(register.get("r3"));
	    
/*	    System.out.println(register.get("r0"));
	    System.out.println(register.get("r1"));
	    System.out.println(register.get("r2"));
	    System.out.println(register.get("r3"));
	    System.out.println(register.get("r4"));
	    System.out.println(register.get("r5"));
	    System.out.println(register.get("r6"));
	    System.out.println(register.get("r7"));
	    System.out.println(register.get("r8"));
	    System.out.println(register.get("r9")); 
	    System.out.println(register.get("r10"));
	    System.out.println(register.get("r11"));
	    System.out.println(register.get("r12"));
	    System.out.println(register.get("r13"));
	    System.out.println(register.get("r14"));
	    System.out.println(register.get("r15"));
	    System.out.println(register.get("r16"));
	    System.out.println(register.get("r17"));
	    System.out.println(register.get("r18"));
	    System.out.println(register.get("r19")); 	    
	    System.out.println(register.get("r20"));
	    System.out.println(register.get("r21"));
	    System.out.println(register.get("r22"));
	    System.out.println(register.get("r23"));
	    System.out.println(register.get("r24"));
	    System.out.println(register.get("r25"));
	    System.out.println(register.get("r26"));
	    System.out.println(register.get("r27"));
	    System.out.println(register.get("r28"));
	    System.out.println(register.get("r29")); 
	    System.out.println(register.get("r30"));
	    System.out.println(register.get("r31")); */
	    
	    System.out.println(cycles);
	    
	}
}
