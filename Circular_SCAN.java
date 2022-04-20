import java.util.ArrayList;
import java.util.Collections;

public class Circular_SCAN {
    ArrayList<Integer> data ;
    int head ;
    int numberOfData ;
    int lasOne;

    public Circular_SCAN ( ArrayList<Integer> data, int head, int numberOfData, int lasOne ) {
        this.data = data;
        this.head = head;
        this.numberOfData = numberOfData;
        this.lasOne = lasOne;
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

    public int getLasOne () {
        return lasOne;
    }

    public void setLasOne ( int lasOne ) {
        this.lasOne = lasOne;
    }

    public void setHead ( int head ) {
        this.head = head;
    }

    public void setNumberOfData ( int numberOfData ) {
        this.numberOfData = numberOfData;
    }

    public int implementation(ArrayList<Integer> path)
    {
        Collections.sort ( data );
        int start = 0 ;
        for ( int i = 0 ; i < numberOfData ; i++ ) {
            if(data.get ( i ) <= head)
            {
                start =  i ;
            }
        }
        int pointer = head;
        for ( int i = start+1 ; i < numberOfData  ; i++ ) {
            path.add ( pointer );
            pointer = data.get ( i );
        }
        path.add ( pointer );
        path.add ( lasOne );
        pointer = 0 ;
        for ( int i = 0 ; i <= start ; i++ ) {
            path.add ( pointer );
            pointer = data.get ( i );
        }
        path.add ( pointer );
        return lasOne - head + data.get(start);

    }
}
