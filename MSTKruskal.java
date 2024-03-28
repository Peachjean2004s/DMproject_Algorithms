public class MSTKruskal {
    int to;
    int form;
    int length;
    int [][] matrix;

    MSTKruskal(int f, int t, int l,int [][] matrix) {
        form = f;
        to = t;
        length = l;
        this.matrix = matrix ;

    }

    int getLength(){
        return length ;
    }

}
