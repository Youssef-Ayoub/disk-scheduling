import java.util.ArrayList;
import java.util.Collections;

public class SSTF {
    ArrayList<Integer> data ;
    ArrayList<Boolean> visited  = new ArrayList<> (  );
    int head ;
    int numberOfData ;

    public SSTF ( ArrayList<Integer> data, int head, int numberOfData ) {
        this.data = data;
        this.head = head;
        this.numberOfData = numberOfData;
        for ( int i = 0 ; i < numberOfData ; i++ ) {
            visited.add ( false );
        }
    }

    public ArrayList<Integer> getData () {
        return data;
    }

    public int getHead () {
        return head;
    }

    public int getNumberOfData () {
        return numberOfData;
    }

    public void setData ( ArrayList<Integer> data ) {
        this.data = data;
    }

    public void setHead ( int head ) {
        this.head = head;
    }

    public void setNumberOfData ( int numberOfData ) {
        this.numberOfData = numberOfData;
    }
    private Boolean finished()
    {
        Boolean ans = true;
        for ( Boolean x: visited ) {
            ans &= x;
        }
        return ans ;
    }
    public Integer implementation(ArrayList<Integer> path)
    {
       int ans = 0 ;
       int pointer = head ;
       while ( !finished () )
       {
           int partialSum = 10000000 ;
           int index = 0 ;
           for ( int i = 0 ; i < numberOfData ; i++ ) {
               if(partialSum > Math.abs (data.get ( i ) - pointer) && !visited.get ( i ))
               {
                   partialSum = Math.abs (data.get ( i ) - pointer ) ;
                   index = i ;
               }
           }
           ans += partialSum ;
           path.add ( pointer );
           pointer = data.get ( index );
           visited.set ( index , true );
       }
       path.add ( pointer );
       return ans ;
    }
}
