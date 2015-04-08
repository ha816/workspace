import java.util.SortedSet;
import java.util.TreeSet;

public class GroupSet  implements Comparable
	{
		 //HashSet<Integer> set;
		 SortedSet<Integer> set;
		 int[] integer_set;
		 double score=0;
		 public GroupSet(int [] input )
		 {
			 integer_set=input;
			 set= arrayToSortedSet(input);
		 }
		 
		 public void setScore(double score)
		 {
			 this.score = score;
		 }
		 
		@Override
		public int compareTo(Object o) {
			SortedSet<Integer>temp=  (SortedSet<Integer>) o;
			
			  if ( set.first()   < temp.first())
                  return -1;
		     else if ( set.first() == temp.first())
		                  return 0;
		     else 
		    	 return 1;
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
	}