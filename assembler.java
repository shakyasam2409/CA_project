package module1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
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
        ArrayList<String> arr3
        = new ArrayList<String>();

	    File file = new File("C:\\Users\\anant\\Desktop\\assembly_code.txt");
	    @SuppressWarnings("resource")
		Scanner in = new Scanner(file);
	    while (in.hasNextLine()) {
	    	arr3.add(in.nextLine().replaceAll("\\s", ""));
	    }
	    
	    int a=arr3.size();
	    
		String[] arr=new String[a];
		String[] binary=new String[a];
		for(int g=0;g<a;g++) {
			arr[g]=arr3.get(g);
		}
	    
	    for(int i=0;i<a;i++) {
    		if(no(arr[i], ':', 1)!=-1) {
    			arr[i]=arr[i].substring(no(arr[i], ':', 1));
    		}	    	
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
    				for(int k=0;k<a;k++) {
    					int res=is(arr[i].substring(v+1), arr[k].substring(0,no(arr[k], 'r', 1)));			    	
    			        if(res!=-1) {
    			        	arr2[0]=Integer.toBinaryString((k-i)*4);
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
    				for(int k=0;k<a;k++) {
    					int res=is(arr[i].substring(u+1), arr[k].substring(0,no(arr[k], 'r', 1)));		    	
    			        if(res!=-1) {
    			        	arr2[0]=Integer.toBinaryString((k-i)*4);
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
                for(int k=0;k<a;k++) {
                    int res=is(arr[i].substring(v+1), arr[k].substring(0,no(arr[k], 'r', 1)));
                    if(res!=-1) {
                        arr2[0]=Integer.toBinaryString((k-i)*4);
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
                for(int k=0;k<a;k++) {
                    int res=is(arr[i].substring(v+1), arr[k].substring(0,no(arr[k], 'r', 1)));
                    if(res!=-1) {
                        arr2[0]=Integer.toBinaryString((k-i)*4);
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
                for (int k = 0; k < a; k++) {
                    int res = is(arr[i].substring(v+1), arr[k].substring(0,no(arr[k], 'r', 1)));
                    if (res != -1) {
                        arr2[0] = Integer.toBinaryString((k - i) * 4);
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
                for (int k = 0; k < a; k++) {
                    int res = is(arr[i].substring(v + 1), arr[k].substring(0,no(arr[k], 'r', 1)));
                    if (res != -1) {
                        arr2[0] = Integer.toBinaryString((k - i) * 4);
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
	    
	    String text=binary[0];

	    for(int f=1;f<a;f++) {
	    	
	    	text=text.concat("\n".concat(binary[f]));
	    } 
	    
	    Path fileName = Path.of("C:\\Users\\anant\\Desktop\\binary.txt");
        Files.writeString(fileName, text);

	}
}
