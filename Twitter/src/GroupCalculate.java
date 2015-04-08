import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class GroupCalculate {
	
	HashMap<Integer,double[]> initialMap;
	int[] index_list;
	private double alpha=1;
	
	
	int[] min_group;
	double min_score;
	
	HashMap<GroupSet , Double> ScoreMap;
	//HashMap< ,int[]> ScoreMap;
	
	
	public GroupCalculate( HashMap<Integer, double [] > input)
	{
		initialMap= input;
		index_list=new int[ input.size()];
		// hash map identitiy 0~
		for(int i = 0 ;  i < index_list.length ; i++)
		{
			index_list[i]= i;
		}
	}
	public void start()
	{
		
		//Iterator< Integer >initial_Itr = initialMap.keySet().iterator();
		//while(initial_Itr.hasNext())
		
		min_group=new int[]{0};
		min_score=alpha;
		System.out.println("");
		
		for(int i = 0 ; i < index_list.length ; i++)
		{
			
			int [] temp = {index_list[i]};
			this.getTop1GroupSet( temp , 0);
			
			//GroupSet init =new GroupSet(temp);
			//init.setScore(alpha );
			//ScoreMap.put( init, alpha);
			
			//int [] temp= { initial_Itr.next()};
		}
		   
    }
	public void getTop1GroupSet( int[] input_set, double past_diameter )
	{
		
		 printSet(input_set);
		 
		 int input_size= input_set.length;
		 int next_index = input_set[input_size-1]+1;
		 
		 if(initialMap.containsKey(next_index))
		 {
		 	 int min_index= Integer.MAX_VALUE;
			 double max_diameter= past_diameter;
			 double [] point_comparable=initialMap.get(next_index);
			 
			 System.out.println("Next_Index:"+next_index+" "+point_comparable[0]+" "+point_comparable[1]);
			 
			 for(int i = 0 ;  i < input_size ; i ++ )
			 {
				 double [] point_values= initialMap.get(i) ;
				 
				 System.out.println("Past_Index:"+i+" "+point_values[0]+" "+point_values[1]);
				 double diameter =  Math.sqrt( Math.pow( point_values[0]-point_comparable[0]  , 2) + Math.pow( point_values[1]-point_comparable[1]  , 2) );
				 if(min_score > diameter)  // min_score > diameter
				 {
					 if( diameter > max_diameter)
					 {
						 max_diameter= diameter;
						 System.out.println("Max diameter At "+i);
						 //min_index=i;
					 }
				 }
				 else // min_score <= diameter
				 {
					 System.out.println("BOUNDED at "+i);
				 }
				 
			 }
			 
			 double score = max_diameter + alpha/(input_size+1);
			 System.out.println("Diameter:"+ max_diameter+" Score:"+ score);
			 
			 int [] next_set = new int[input_size+1];
			 for(int j = 0 ; j < input_size ; j++)
			 {
			 next_set[j]= new Integer(input_set[j]);
			 }
			 next_set[input_size]=next_index;
			 
			 System.out.print("Next INPUT_SET: ");
			 printSet(next_set);
			 if(score<=min_score)
			 {
				 min_score = score;
				 min_group = next_set;
			//	 min_index=i;
			 }
			  if(past_diameter >= max_diameter)
			 {
			 getTop1GroupSet(next_set,past_diameter);
			 }
			 else
			 {
				 getTop1GroupSet(next_set, max_diameter);
			 }
		 
		 }
		 else
		 {
			 System.out.println("No More Element to Compare in this Tree !");
		 }
	 		
		 
		 
	}
	public void printSet(int [] input)
	{
		System.out.println();
		for(int i =0; i<input.length ; i++)
		{
			System.out.print("["+input[i]+"]");
		}
		System.out.println();
	}
	/*
	public void getTop1GroupSet( GroupSet input_set, double past_best_score )
    {
		// [4][5][7]
			 int[] input= input_set.integer_set;
			int input_size= input.length;
			 int value = input[input_size-1]+1;
			 
			 int [] groupArray = new int[input_size+1];
			 for(int i = 0 ; i < input_size ; i++)
			 groupArray[i]= input[i];
			 groupArray[input_size+1]=value;
			 
			 //groupArray done
			 //[4][5][7][8]
			 int min_index= Integer.MAX_VALUE;
			 double [] comparable=initialMap.get(value);
			 
			 double min_score = min_group.score;
			 for(int i = 0 ;  i < input_size ; i ++ )
			 {
				 double [] point_values= initialMap.get(i) ;
				 double distance =  Math.sqrt( Math.pow( point_values[0]-comparable[0]  , 2) + Math.pow( point_values[1]-comparable[1]  , 2) );
				 
				 double score = distance + alpha/(input_size+1);
				 if(score<min_score)
				 {
					 min_score = score;
					 min_index=i;
				 }
			 }
			 if(min_index < Integer.MAX_VALUE) // min score finded
			 {
				 value, min_index // is pair of small 
			 }
			 
			 ScoreMap.put( new GroupSet(groupArray) , )
			 
    		//input [4][5][7] //it must be sorted
    		//get new score of input
    			
    }*/
	/*
    public GroupSet getTop1GroupSet( GroupSet input, double past_best_score )
    {
    		input.integer_set;
    		//get new score of input
    		//
    		if( Min < df>)
    			
    }*/
	public double getMaxDiameter()
	{
		return 0.0;
	}
	
	/*
	public GroupCalculate( int[][] input)
	{
		initialSet = arrayToSet(input);
	
	}*/
	
		
		
		//for each initalSet
		
		
	
	
	/*
	public int[] setToArray( HashSet<Integer> input )
	{
		
		Iterator Iter_input = input.iterator();
		int input_count=0;
		int [] Result= new int [input.size()] ;
		
		while(Iter_input.hasNext())
		{
			Result[input_count]=(int) Iter_input.next();
		}
		return Result;
		
	}*/
	public HashSet<Integer> arrayToHashSet(int [] input)
	{
		
		HashSet<Integer> ResultSet = new <Integer> HashSet();
		for(int i =0; i<input.length ; i++)
		{
			ResultSet.add(input[i]);
		}
		
		return ResultSet;
	}
	public SortedSet<Integer> arrayToSortedSet(int [] input)
	{
		
		SortedSet<Integer> ResultSet = new <Integer>TreeSet();
		for(int i =0; i<input.length ; i++)
		{
			ResultSet.add(input[i]);
		}
		
		return ResultSet;
	}
	
	
	
	
	public static void main(String args[])
	{
		HashMap<Integer, double []> temp_in = new HashMap<Integer, double []>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("./Empire State Building2.txt"));
			 while(true) 
			 {
		         String line = br.readLine();
		         if (line==null) break;
		         String [] pair=line.split("\\|");
		         String []pos =pair[pair.length-1].split(",");
		         double [] double_pos ={ Double.parseDouble(pos[0]),Double.parseDouble(pos[1])};
		         
		         System.out.print(" "+pair[0]);
		         temp_in.put(Integer.parseInt( pair[0])-1, double_pos);
				         
			 }
			 System.out.println();
	         
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * 
		 */
		/*
		double[] in = {1,2};
		double[] in2 = {0.1,0.4};
		double[] in3 = {1.1,2.2};
		
		temp_in.put(1, in);
		temp_in.put(2, in2);
		temp_in.put(3, in3);
		*/
		GroupCalculate temp = new GroupCalculate(temp_in);
		temp.start();
		System.out.println("***********************");
		
		temp.printSet(temp.min_group);
		System.out.println("**"+" "+temp.min_score);
		
	}
}



